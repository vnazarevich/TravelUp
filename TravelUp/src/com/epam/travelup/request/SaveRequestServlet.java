package com.epam.travelup.request;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.requestServices.RequestCreaterService;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * 
 * @author Nazarevich V.
 *
 */
@WebServlet("/SaveRequestServlet")
public class SaveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger
			.getLogger("SaveRequestServlet ::");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SaveRequestServlet:: doPost()");
			User user = (User) request.getSession().getAttribute("user");
			if (null == user){
				LOGGER.warning("from doPost, user - gest " );
			}
		
		try {
			String[] places = request.getParameterValues("places");
			Integer minCapac = new Integer(request.getParameter("minCapas"));
			Integer maxCapac = new Integer(request.getParameter("maxCapas"));
			Integer maxPrice = new Integer(request.getParameter("maxPrice"));
			Integer minDuration = new Integer(
					request.getParameter("minDuration"));
			Integer maxDuration = new Integer(
					request.getParameter("maxDuration"));
			System.out.println("3" + request.getParameter("startDate"));

			System.out.println("4");
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date startDate = null, endDate = null;
				startDate = df.parse(request.getParameter("startDate"));
				endDate = df.parse(request.getParameter("endDate"));
				System.out.println("a");
			Tour requestTour = new Tour();
			requestTour.setCreaterTourId(user.getId());
			System.out.println("a1");
			if (minCapac > maxCapac) {
				requestTour.setMinCapacity(minCapac);
				requestTour.setMaxCapacity(maxCapac);
			} else {
				requestTour.setMinCapacity(minCapac);
				requestTour.setMaxCapacity(maxCapac);
			}
			if (minDuration > maxDuration) {
				requestTour.setMinDuration(maxDuration);
				requestTour.setMaxDuration(minDuration);
			} else {
				requestTour.setMinDuration(minDuration);
				requestTour.setMaxDuration(maxDuration);
			}
			requestTour.setMaxPrice(maxPrice);
			if (startDate.after(endDate)) {
				requestTour.setStartDate(new java.sql.Date(endDate.getTime()));
				requestTour.setEndDate(new java.sql.Date(startDate.getTime()));
			} else {
				requestTour.setStartDate(new java.sql.Date(startDate.getTime()));
				requestTour.setEndDate(new java.sql.Date(endDate.getTime()));
			}
			System.out
					.println("START RequestCreaterService.createRequest(requestTour, places)");
			RequestCreaterService.createRequest(requestTour, places);

		} catch (Exception e) {
			LOGGER.info("from do Post(), wrong parameters tyrpe " + e);
			request.getRequestDispatcher("pages/request.jsp").forward(request,
					response);
		}
		request.getRequestDispatcher("pages/request.jsp").forward(request,
				response);
	}

	private int[] parseDate(String startDateString) {
		String[] temp = startDateString.split("/");
		Integer[] result = new Integer[3];
		for (int i = 0; i < temp.length; i++) {
			result[i] = new Integer(temp[i]);
		}
		return null;
	}

}
