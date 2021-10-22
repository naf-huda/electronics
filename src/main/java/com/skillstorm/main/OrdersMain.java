package com.skillstorm.main;


import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

import com.skillstorm.beans.Orders;
import com.skillstorm.data.OrdersDAO;

public class OrdersMain {

	// Primarily served to test DAO methods 
	public static void main(String[] args) throws SQLException {

		//OrdersDAO dao = new OrdersDAO();
		
		
		// Create new orders object
		//Orders order = new Orders("Nafimul Huda", "Galaxy Note 20", (float) 1299.99, "Samsung", "Smartphone", 4, "2021-03-02", "GREEN");
		//order = dao.create(order);
		
		//System.out.println(order);
		
		
		
		// Retrieve all records from orders table
		//List<Orders> orders = new LinkedList<Orders>();
		//orders = dao.findAll();
		
		//System.out.println(orders);
		
	
		// Update record in the orders table
		//Orders updateOrder = new Orders(46, "Jack Dorsey", "Twitter", (float)888.99, "Twitter", "Social Media", 1, "2021-01-01", "GREEN");
		//dao.update(updateOrder);
		
		//System.out.println(dao.findAll());
		
		
		// Delete record in the orders table by its id
		//Orders deleteOrder = new Orders(46);
		//dao.delete(deleteOrder);
		
		
		//System.out.println(dao.findAll());
	
		
		
		// Retrieve record by id
		//boolean check = dao.findById(100);
		//System.out.println(check);
		
		
	}

}
