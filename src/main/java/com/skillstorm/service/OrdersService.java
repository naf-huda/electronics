package com.skillstorm.service;

import java.io.IOException;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.*;
import com.skillstorm.data.OrdersDAO;

public class OrdersService  {

	OrdersDAO dao = new OrdersDAO();

	// Get method implementation
	public void doGetImpl(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		System.out.println("servlet GET()");
		List<Orders> allOrders = null;
		try {
			allOrders = dao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// convert our list of orders to a json string
		String json = new ObjectMapper().writeValueAsString(allOrders);

		// write the json string to our http response
		resp.getWriter().print(json);

		// setting content type to JSON
		resp.setContentType("application/json");
		
	}

	// Post method implementation
	public void doPostImpl(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		System.out.println("doPostImpl() works!");

		// parse the http request body
		InputStream requestBody = req.getInputStream();

		// convert the request body into a java object
		Orders order = new ObjectMapper().readValue(requestBody, Orders.class);

		// updating the movie object to contain the generated id
		Orders updatedOrder = null;
		try {
			updatedOrder = dao.create(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// returning back the updated order as a json string
		resp.getWriter().print(new ObjectMapper().writeValueAsString(updatedOrder));

		// set the status code to 201: CREATED
		resp.setStatus(201);

		// setting content type to JSON
		resp.setContentType("application/json");
	}

	// Put method implementation
	public void doPutImpl(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		
		System.out.println("doPutImpl() works!");

		// parse the http request body
		InputStream requestBody = req.getInputStream();

		// convert the request body into a java object
		Orders order = new ObjectMapper().readValue(requestBody, Orders.class);

		// check if this order already exists in the table
		boolean check = false;
		try {
			check = dao.findById(order.getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (check) { // it already exists, so just update that existing order
			try {
				dao.update(order);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else { // it does not already exist, so create that new order
			try {
				order = dao.create(order);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// returning back the updated movie as a json string
		resp.getWriter().print(new ObjectMapper().writeValueAsString(order));

		// set the status code to 201: CREATED
		resp.setStatus(204);

		// setting content type to JSON
		resp.setContentType("application/json");
	}

	// Delete method implementation
	public void doDeleteImpl(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
		
		System.out.println("doDeleteImpl() works!");

		// parse the http request body
		InputStream requestBody = req.getInputStream();

		// convert the request body into a java object
		Orders order = new ObjectMapper().readValue(requestBody, Orders.class);

		// check if this order already exists in the table
		boolean check = false;
		try {
			check = dao.findById(order.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (check) { // it already exists, so just update that existing order
			try {
				dao.delete(order);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // else, do nothing since we have nothing to delete from the table

		// returning back the updated movie as a json string
		resp.getWriter().print(new ObjectMapper().writeValueAsString(order));

		// set the status code to 201: CREATED
		resp.setStatus(204);

		// setting content type to JSON
		resp.setContentType("application/json");
	}

}