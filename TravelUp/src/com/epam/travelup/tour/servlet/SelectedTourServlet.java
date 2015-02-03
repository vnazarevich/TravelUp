package com.epam.travelup.tour.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.model.Comment;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.service.TourService;

/**
 * Servlet implementation class SelectedTourServlet
 */

public class SelectedTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectedTourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("WORKS!");
		String tourId = request.getParameter("selectedtour");
		List<Tour> tours = TourService.getToursWhere("id", tourId, "en");
		Tour tour = tours.get(0);
		
		List<String> placeCoordinats = new ArrayList<String>();
		for(Place place:tour.getPlaces()){
			placeCoordinats.add(place.getxCoordinate() + ", " + place.getyCoordinate());
		}
		String origin = placeCoordinats.get(0);
		String destination = placeCoordinats.get(placeCoordinats.size()-1);
		placeCoordinats.remove(0);
		placeCoordinats.remove(placeCoordinats.size()-1);
		
		List<Comment> comments = TourService.getCommentsForTour(tourId, "en");
			
		Comment.sortByDate(comments);
		
		request.setAttribute("orig", origin);
		request.setAttribute("dest", destination);
		request.setAttribute("placecoordinats", placeCoordinats);
		request.setAttribute("tour", tour);
		request.setAttribute("comments", comments);
		

		request.getRequestDispatcher("pages/tour.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
