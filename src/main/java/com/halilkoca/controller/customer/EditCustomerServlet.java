package com.halilkoca.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.halilkoca.business.services.common.AddressServiceImpl;
import com.halilkoca.business.services.customer.CustomerServiceImpl;
import com.halilkoca.model.common.Address;
import com.halilkoca.model.customer.Customer;

/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/admin/customer/edit")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerServiceImpl customerSI;
	private Customer customer;
	private AddressServiceImpl addressSI;
	private Address address;
	
	private int id_customer;
	private int newsletter;
	private Date newsletterDateAdd;
	private double outstandingAllowAmount;
	private int showPublicPrices;
	private int maxPaymentDays;
	private int active;
	private int isGuest;
	private int deleted;
	private Date dateUpd;
	private Date birthday;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String company;
	private String ipRegistrationNewsletter;
	private String website;
	private String note;
	private String secureKey;

	private String idGender;
	private String birthDay;
	private String password;
	private String outstandingallowamount;
	private String maxpaymentdays;	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		if (request.getParameter("id_customer") != null) {
			
			id_customer = Integer.parseInt(request.getParameter("id_customer"));
			
			
			customerSI = new CustomerServiceImpl();
			customer = new Customer();
			
			addressSI = new AddressServiceImpl();
			address = new Address();
			
			try {
				customer = customerSI.getById(id_customer);
				request.setAttribute("customer", customer);
				
				address = addressSI.getCustomerById(id_customer);
						
				request.setAttribute("address", address);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}else{
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/404.jsp");
			dispatcher.forward(request, response);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/customer/editcustomer.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isNewsletter = "0";
		String showpublicprices = "0";
		String isActive = "0";
		String isguest = "0";
		String isdeleted = "0";
		
		
		
		
		
		
		doGet(request, response);
	}

}
