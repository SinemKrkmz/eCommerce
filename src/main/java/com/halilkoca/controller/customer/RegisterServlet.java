package com.halilkoca.controller.customer;


import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.halilkoca.business.services.common.AddressServiceImpl;
import com.halilkoca.business.services.common.CityServiceImpl;
import com.halilkoca.business.services.common.DistrictServiceImpl;
import com.halilkoca.business.services.customer.CustomerServiceImpl;
import com.halilkoca.model.catalog.product.manufacturer.Manufacturer;
import com.halilkoca.model.catalog.product.supplier.Supplier;
import com.halilkoca.model.common.Address;
import com.halilkoca.model.common.City;
import com.halilkoca.model.common.Country;
import com.halilkoca.model.common.District;
import com.halilkoca.model.customer.Customer;
import com.halilkoca.model.gender.Gender;
import com.mysql.jdbc.PreparedStatement;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/admin/customer/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
	private String phonemobile;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String company;
	private String ipRegistrationNewsletter;
	private String website;
	private String note;
	private String secureKey;
	private Customer customer;
	private String idGender;
	private String birthDay;
	private String password;
	private String outstandingallowamount;
	private String maxpaymentdays;	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		
		List<City> cities = new ArrayList<>();
		List<District> districts = new ArrayList<>();
		CityServiceImpl citySI = new CityServiceImpl();
		DistrictServiceImpl districtSI = new DistrictServiceImpl();
					
		try {
			
			cities = citySI.getWithCountryAll(1);
			request.setAttribute("cities", cities);
			
			districts = districtSI.getWithCityAll(10);
			request.setAttribute("districts", districts);
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/customer/register.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		System.out.println("district id: "+request.getParameter("district"));
		System.out.println("city id: " + request.getParameter("city"));

		String err = "";

		String isNewsletter = "0";
		String showpublicprices = "0";
		String isActive = "0";
		String isguest = "0";
		String isdeleted = "0";
		
		

		if (!(request.getParameter("firstname") == (null)) && !(request.getParameter("lastname") == (null))
				&& !(request.getParameter("username") == (null)) && !(request.getParameter("email") == (null))
				&& !(request.getParameter("gender") == (null)) && !(request.getParameter("birthday") == (null))
				&& !(request.getParameter("password")== (null))
				&& !(request.getParameter("outstandingallowamount") == (null))
				&& !(request.getParameter("maxpaymentdays") == (null))
				&& !(request.getParameter("city") == null) || !(request.getParameter("city") == "") 
				
				
				) {
			firstName = request.getParameter("firstname");
			lastName = request.getParameter("lastname");
			username = request.getParameter("username");
			email = request.getParameter("email");
			idGender = request.getParameter("gender");
			birthDay = request.getParameter("birthday");
			note = request.getParameter("note");
			company = request.getParameter("company");
			password = request.getParameter("password");
			phonemobile = request.getParameter("phonemobile");

			if ((request.getParameter("newsletter") != null)) {
				isNewsletter = request.getParameter("newsletter");
			}
			if ((request.getParameter("showpublicprices") != null)) {
				showpublicprices = request.getParameter("showpublicprices");
			}
			if ((request.getParameter("active") != null)) {
				isActive = request.getParameter("active");
			}
			if ((request.getParameter("isguest") != null)) {
				isguest = request.getParameter("isguest");
			}
			if ((request.getParameter("deleted") != null)) {
				isdeleted = request.getParameter("deleted");
			}

			outstandingallowamount = request.getParameter("outstandingallowamount");
			maxpaymentdays = request.getParameter("maxpaymentdays");
			website = request.getParameter("website");

			// tarihler
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			birthday = new Date();
			try {
				birthday = sdf.parse(birthDay);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			// gender id set etme
			int id_Gender = Integer.parseInt(idGender);
			Gender genderC = new Gender();
			genderC.setId_gender(id_Gender);

			// sifreleme
			try {
				secureKey = makeMD5SecureKey();
				password = makeSHA256(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}

			// tarihe cevirme
			Date dateAdd = new Date();
			dateUpd = dateAdd;

			// ip address
			ipRegistrationNewsletter = getClientIpAddr(request);

			newsletterDateAdd = dateAdd;

			outstandingAllowAmount = Double.parseDouble(outstandingallowamount);

			showPublicPrices = Integer.valueOf(showpublicprices);

			maxPaymentDays = Integer.parseInt(maxpaymentdays);
			newsletter = Integer.valueOf(isNewsletter);
			active = Integer.valueOf(isActive);
			isGuest = Integer.valueOf(isguest);
			deleted = Integer.valueOf(isdeleted);	

			customer = new Customer(genderC, company, firstName, lastName, username, email, password, birthday,
					phonemobile, newsletter, ipRegistrationNewsletter, newsletterDateAdd, website, outstandingAllowAmount,
					showPublicPrices, maxPaymentDays, secureKey, note, active, isGuest, deleted, dateAdd, dateUpd);

			CustomerServiceImpl customerSI = new CustomerServiceImpl();
			try {
				customerSI.addCustomer(customer);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			customerSI = new CustomerServiceImpl();
			Customer idCustomer = new Customer();
			try {
				idCustomer = customerSI.getByUsername(request.getParameter("username"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			// address tablosu 
			int cityValue = Integer.valueOf(request.getParameter("city"));
			int districtValue = Integer.valueOf(request.getParameter("district"));
			String postcode = request.getParameter("postcode");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			Date updated = new Date();
			
						
			Address address = new Address(idCustomer, cityValue, districtValue, 
					address1, address2, postcode, "boş", company, lastName, firstName, phonemobile, updated, 1, 0);
			
			AddressServiceImpl addressSI = new AddressServiceImpl();
			try {
				
				addressSI.addAddressFromRegister(address);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			

		} else {
			err += "** Eksik alanları doldurunuz";
		}

		if (err.length() > 0) {
			request.setAttribute("errors", err);

		}
		
		doGet(request, response);
	}

	// md5 uretir random UUID ile
	private String makeMD5SecureKey() throws NoSuchAlgorithmException {
		String secure_key = UUID.randomUUID().toString();

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(secure_key.getBytes());

		byte byteData[] = md.digest();

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();

	}

	private String makeSHA256(String password) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

	private static String getClientIpAddr(HttpServletRequest request) {
		String ip = null;
		// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		// {
		// ip = request.getHeader("Proxy-Client-IP");
		// }
		// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		// {
		// ip = request.getHeader("WL-Proxy-Client-IP");
		// }
		// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		// {
		// ip = request.getHeader("HTTP_CLIENT_IP");
		// }
		// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		// {
		// ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		// }
		// if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		// {
		// ip = request.getRemoteAddr();
		// }
		if (request != null) {
			ip = request.getHeader("X-FORWARDED-FOR");
			if (ip == null || "".equals(ip)) {
				ip = request.getRemoteAddr();
			}
		}
		return ip;
	}

}
