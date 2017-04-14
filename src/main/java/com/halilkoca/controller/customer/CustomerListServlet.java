package com.halilkoca.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halilkoca.business.services.customer.CustomerServiceImpl;
import com.halilkoca.model.customer.Customer;

/**
 * Servlet implementation class CustomerListServlet
 */
@WebServlet("/admin/customer/list")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Customer> customers;
	CustomerServiceImpl csi;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		

		
		try {
			csi = new CustomerServiceImpl();
			customers = csi.getAll();
			
			request.setAttribute("customers", customers);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

		
		
		
		
		
		
		
		

		RequestDispatcher disp = request.getRequestDispatcher("/admin/customer/customerlist.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {



		doGet(request, response);
	}

}
