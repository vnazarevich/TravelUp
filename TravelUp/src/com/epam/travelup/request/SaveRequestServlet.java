package com.epam.travelup.request;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Tour;

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
	//	String placeName = request.getParameter("place");
	
		Integer minCapac = new Integer (request.getParameter("minCapas"));
		Integer maxCapac = new Integer (request.getParameter("maxCapas"));
		Integer maxPrice = new Integer (request.getParameter("price"));
		Integer minDuration = new Integer (request.getParameter("minDuration"));
		Integer maxDuration = new Integer (request.getParameter("maxDuration"));	
//		Date startDate =new Date(new Long(request.getParameter("startData")));
//		Date endDate =new Date(new Long(request.getParameter("endData")));
		
		Tour requestTour = new Tour();
		requestTour.setMinCapacity(minCapac);
		requestTour.setMaxCapacity(maxCapac);
		requestTour.setMaxPrice(maxPrice);
		requestTour.setMinDuration(minDuration);
		requestTour.setMaxDuration(maxDuration);
//		requestTour.setStartDate(startDate);
//		requestTour.setEndDate(endDate);
		
		new Dao <Tour>(Tour.class, "en").insert(requestTour);		
			
	}

}
