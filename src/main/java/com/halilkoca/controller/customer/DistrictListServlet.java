package com.halilkoca.controller.customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.halilkoca.business.services.common.DistrictServiceImpl;
import com.halilkoca.model.common.District;

/**
 * Servlet implementation class DistrictListServlet
 */
@WebServlet("/admin/customer/districtlist")
public class DistrictListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistrictListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getParameter("cityValue") == null || request.getParameter("cityValue") == "") {
			System.out.println("cityValue boş olamaz");
			return;
		}
		List<District> districts = new ArrayList<>();
		DistrictServiceImpl districtSI = new DistrictServiceImpl();

		try {
					
			String cityValue = request.getParameter("cityValue");
			String json = null;
			
			districts = districtSI.getWithCityAll(Integer.parseInt(cityValue));

			json = new Gson().toJson(districts);
			response.setContentType("application/json");
			response.getWriter().write(json);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
