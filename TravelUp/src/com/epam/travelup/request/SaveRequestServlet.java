package com.epam.travelup.request;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.requestServices.RequestCreaterService;

/**
 * 
 * @author Nazarevich V.
 *
 */
@WebServlet("/SaveRequestServlet")
public class SaveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SaveRequestServlet:: doPost()");
		
		String[] places = request.getParameterValues("places");
		Integer minCapac = new Integer (request.getParameter("minCapas"));
		Integer maxCapac = new Integer (request.getParameter("maxCapas"));
		Integer maxPrice = new Integer (request.getParameter("price"));
		Integer minDuration = new Integer (request.getParameter("minDuration"));
		Integer maxDuration = new Integer (request.getParameter("maxDuration"));	
		Date startDate =new Date(new Long(request.getParameter("startData")));
		Date endDate =new Date(new Long(request.getParameter("endData")));
		User user = (User) request.getSession().getAttribute("user");
		
		Tour requestTour = new Tour();
		requestTour.setCreaterTourId(user.getId());
		if (minCapac > maxCapac){
			requestTour.setMinCapacity(minCapac);
			requestTour.setMaxCapacity(maxCapac);
		} else {
			requestTour.setMinCapacity(minCapac);
			requestTour.setMaxCapacity(maxCapac);			
		}
		if (minDuration > maxDuration){
			requestTour.setMinDuration(maxDuration);
			requestTour.setMaxDuration(minDuration);		
		} else {
			requestTour.setMinDuration(minDuration);
			requestTour.setMaxDuration(maxDuration);
		}
		requestTour.setMaxPrice(maxPrice);
		if (startDate.after(endDate)){
			requestTour.setStartDate(endDate);
			requestTour.setEndDate(startDate);
		} else{
		requestTour.setStartDate(startDate);
		requestTour.setEndDate(endDate);
		}
		System.out.println("START RequestCreaterService.createRequest(requestTour, places)");
		RequestCreaterService.createRequest(requestTour, places);
		
		request.getRequestDispatcher("pages/request.jsp").forward(request, response);
		
		
	}

}
