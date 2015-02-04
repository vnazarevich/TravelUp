package com.epam.travelup.place.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.service.PlaceService;

/**
 * Servlet implementation class PlaceServlet
 */
public class PlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Place> places = PlaceService.getAll("en");
		
		List<String> placeCoordinats = new ArrayList<String>();
		List<String> description = new ArrayList<String>();
	
		for(Place place: places){
			placeCoordinats.add(place.getxCoordinate() + ", " + place.getyCoordinate());
			
			description.add(place.getInfo().getUaDescription());
		}
		
		 StringBuffer sb = new StringBuffer();
		    sb.append("[");
		    for(int i=0; i<description.size(); i++){
		        sb.append("\"").append(description.get(i)).append("\"");
		        if(i+1 < description.size()){
		            sb.append(",");
		        }
		    }
		    sb.append("]");
		    
		request.setAttribute("placecoordinats", placeCoordinats);
		request.setAttribute("places", places);
		request.setAttribute("description", sb.toString());
		

		request.getRequestDispatcher("pages/places.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
