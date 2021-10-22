package com.skillstorm.data;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.beans.Orders;

public class OrdersDAO {

	// database credentials
	private static final String url = "jdbc:mysql://localhost:3306/electronics";
	private static final String username = "root";
	private static final String password = "password";

	static { // loads driver immediately into memory as soon as this class is loaded
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// CRUD operation(s) implementation

	// CREATE
	public Orders create(Orders order) throws SQLException {

		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false); // begin our transaction
		boolean isCommitable = true;

		// 2. create the connection AND 5. closing the connection (try-with-resources)
		try {

			// 3. creating our statement

			String sql = "insert into orders(full_name, product_name, price, company, category, stock, order_date, order_status)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, order.getFull_name()); // sets placeholder 1
			stmt.setString(2, order.getProduct_name()); // set placeholder 2
			stmt.setFloat(3, order.getPrice()); // sets placeholder 3
			stmt.setString(4, order.getCompany()); // sets placeholder 4
			stmt.setString(5, order.getCategory()); // sets placeholder 5
			stmt.setInt(6, order.getStock()); // sets placeholder 6
			stmt.setString(7, order.getOrder_date()); // sets placeholder 7
			stmt.setString(8, order.getOrder_status()); // sets placeholder 8

			// 4. execute the statement
			stmt.executeUpdate();

			// getting back the auto-incremented id from database
			ResultSet keys = stmt.getGeneratedKeys();
			keys.next();
			int orderID = keys.getInt(1);
			order.setId(orderID);

		} catch (SQLException e) {
			// if anything ever goes wrong, rollback the transaction
			isCommitable = false;
			conn.rollback();
			e.printStackTrace();
		} finally {

			// if no error occurred, commit the transaction
			if (isCommitable) {
				conn.commit();
			}
			conn.close();
		}

		// return back the updated movie with an ID
		return order;
	}

	// RETRIEVE 
	public List<Orders> findAll() throws SQLException {

		List<Orders> allOrders = new LinkedList<>();

		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false); // begin our transaction
		boolean isCommitable = true;

		// 2. create the connection AND 5. closing the connection (try-with-resources)
		try {

			// 3. creating our statement
			String sql = "select id, full_name, product_name, price, company, category, stock, order_date, order_status from orders";
			PreparedStatement stmt = conn.prepareStatement(sql); // tells database to return generated keys

			// 4. execute the statement
			ResultSet rs = stmt.executeQuery(); // Query because retrieving from table

			while (rs.next()) {

				// retrieves our returned attributes
				int orderID = rs.getInt("id");
				String orderFullName = rs.getString("full_name");
				String orderProductName = rs.getString("product_name");
				float price = rs.getFloat("price");
				String company = rs.getString("company");
				String category = rs.getString("category");
				int stock = rs.getInt("stock");
				String order_date = rs.getString("order_date");
				String order_status = rs.getString("order_status");

				// creates the new order object with those attributes
				Orders order = new Orders(orderID, orderFullName, orderProductName, price, company, category, stock,
						order_date, order_status);

				// adds the new order to set of all orders
				allOrders.add(order);
			}

		} catch (SQLException e) {
			isCommitable = false;
			conn.rollback();
			e.printStackTrace();
		} finally {

			// if no error occurred, commit the transaction
			if (isCommitable) {
				conn.commit();
			}
			conn.close();
		}

		// return back the updated movie with an ID
		return allOrders;
	}

	// Helper method to find a record by its 'id'
	public boolean findById(int id) throws SQLException {
		// Create connection and close connection

		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false); // begin our transaction
		boolean isCommitable = true;

		try {

			// Create our statement
			String sql = "select id, full_name, product_name, price, company, category, stock, order_date, order_status from orders where id = "
					+ id;
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Execute our statement
			ResultSet rs = stmt.executeQuery();

			// Check if order does not exist in table
			if (!rs.next()) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e) {
			isCommitable = false;
			conn.rollback();
			e.printStackTrace();
		} finally {

			// if no error occurred, commit the transaction
			if (isCommitable) {
				conn.commit();
			}
			conn.close();
		}
		return false;
	}

	// UPDATE 
	public void update(Orders newOrder) throws SQLException {

		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false); // begin our transaction
		boolean isCommitable = true;

		try {

			// if(newOrder.findById(newOrder.getId()) != null) {
			String sql = "UPDATE orders SET full_name = ?, product_name = ?, price = ?, company = ?, category = ?, stock = ?, "
					+ "order_date = ?, order_status = ? " + "WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, newOrder.getFull_name());
			stmt.setString(2, newOrder.getProduct_name());
			stmt.setFloat(3, newOrder.getPrice());
			stmt.setString(4, newOrder.getCompany());
			stmt.setString(5, newOrder.getCategory());
			stmt.setInt(6, newOrder.getStock());
			stmt.setString(7, newOrder.getOrder_date());
			stmt.setString(8, newOrder.getOrder_status());
			stmt.setInt(9, newOrder.getId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			isCommitable = false;
			conn.rollback();
			e.printStackTrace();
		} finally {

			// if no error occurred, commit the transaction
			if (isCommitable) {
				conn.commit();
			}
			conn.close();
		}
	}

	// DELETE
	public void delete(Orders order) throws SQLException {

		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false); // begin our transaction
		boolean isCommitable = true;
		
		int iD = order.getId();

		try {

			String sql = "delete from orders where id = " + iD;

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			isCommitable = false;
			conn.rollback();
			e.printStackTrace();
		} finally {

			// if no error occurred, commit the transaction
			if (isCommitable) {
				conn.commit();
			}
			conn.close();
		}
	}

}
