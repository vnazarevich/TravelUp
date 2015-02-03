package com.epam.travelup.place.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.service.PlaceService;

/**
 * Servlet implementation class SelectedPlaceServlet
 */
public class SelectedPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectedPlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String placeId = request.getParameter("selectedplace");
		List<Place> places = PlaceService.getPlacesWhere("id", placeId, "en");
		Place place = places.get(0);
		
		String placeCoordinats = place.getxCoordinate() + ", " + place.getyCoordinate();
		
		request.setAttribute("placecoordinats", placeCoordinats);
		request.setAttribute("place", place);
		
		request.getRequestDispatcher("pages/place.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
