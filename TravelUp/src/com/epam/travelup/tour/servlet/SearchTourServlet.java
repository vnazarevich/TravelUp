package com.epam.travelup.tour.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.tour.util.TourSearcher;

/**
 * Servlet implementation class SearchTourServlet
 */

public class SearchTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchTourServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String key = (String) request.getParameter("key");
		String startDate = request.getParameter("start-date");
		String endDate =  request.getParameter("end-date");
		String minPriceString = request.getParameter("minprice");
		String maxPriceString = request.getParameter("maxprice");
		String duration = (String) request.getParameter("durbox");
		String dayType = (String) request.getParameter("daybox");
		String reg1 = request.getParameter("check1");
		String reg2 = request.getParameter("check2");

		int minPrice = (int) Double.parseDouble(minPriceString);
		int maxPrice = (int) Double.parseDouble(maxPriceString);
		int minDuration = 0;
		int maxDuration = 0;
		boolean region1 = false;
		boolean region2 = false;
		if (reg1 != null) {
			region1 = reg1.equals("on");
		}
		if (reg2 != null) {
			region2 = reg2.equals("on");
		}
		if (!duration.equals("")) {
			if (duration.contains("-")) {
				duration = duration.replace(" ", "");
				String[] splitted = duration.split("-");
				minDuration = Integer.parseInt(splitted[0]);
				maxDuration = Integer.parseInt(splitted[1]);
			} else {
				minDuration = maxDuration = Integer.parseInt(duration);
			}
		}
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date start = null, end = null;
		
		try {
			start = df.parse(startDate);
			System.out.println(start);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			end = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		List<Tour> tours = TourSearcher.search(key, start, end,
				minPrice, maxPrice, minDuration, maxDuration, dayType, region1, region2);

		request.setAttribute("tourList", tours);
		request.getRequestDispatcher("pages/tours.jsp").forward(request,
				response);

		// System.out.println(key + " " + startDate + " " + endDate + " " +
		// minPrice + " " + maxPrice + " " + duration + " " + days + " " +
		// check1 + " " + check2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
