
package com.skillstorm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.Orders;
import com.skillstorm.data.OrdersDAO;
import com.skillstorm.service.OrdersService;

@WebServlet(urlPatterns = "/api/orders")
public class OrdersController extends HttpServlet {

	OrdersDAO dao = new OrdersDAO();
	OrdersService service = new OrdersService();

	// Controller method responsible for forwarding HTTP requests to proper service method
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {

		switch (req.getMethod()) {
		case "GET":
			 service.doGetImpl(req,resp);
			 break;
		case "POST":
			 service.doPostImpl(req, resp);
			 break;
		case "PUT":
			 service.doPutImpl(req, resp);
			 break;
		case "DELETE":
			service.doDeleteImpl(req, resp);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			processRequest(req,resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
			processRequest(req, resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			processRequest(req, resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		 try {
			processRequest(req, resp);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void init() throws ServletException {
		super.init();
		// called when servlet is created
		System.out.println("servlet init()");
	}

	@Override
	public void destroy() {
		super.destroy();
		// called when the servlet is destroyed
		System.out.println("servlet destroy()");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// called before EACH incoming HTTP request
		System.out.println("servlet service()");
		super.service(req, resp); // forward the request to the proper HTTP method
	}
}
