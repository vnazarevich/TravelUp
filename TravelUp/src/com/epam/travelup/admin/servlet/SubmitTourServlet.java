package com.epam.travelup.admin.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.PlaceToRoute;
import com.epam.travelup.orm.model.Route;
import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.model.TourName;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.PlaceService;
import com.epam.travelup.orm.service.TourService;
import com.epam.travelup.orm.service.UserService;

/**
 * Servlet implementation class SubmitTourServlet
 */
@WebServlet("/SubmitTourServlet")
public class SubmitTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitTourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enName = request.getParameter("enName");
		String uaName = request.getParameter("uaName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String capacity = request.getParameter("capacity");
		String price = request.getParameter("price");
		String photographer = request.getParameter("photographer");
		String guide = request.getParameter("guide");
		String transporter = request.getParameter("transpoter");
		String lenth = request.getParameter("lenth");
		String trans = request.getParameter("trans");
		String region = request.getParameter("region");

		//create name
		TourName name = new TourName();
		name.setUaName(uaName);
		name.setEnName(enName);
		//insert name
		Dao<TourName> dao = new Dao<TourName>(TourName.class, "en");
		int nameId = dao.insert(name);
		name.setId(nameId);
		System.out.println("name added!"+name);
		//insert route
		Route route = new Route();
		route.setMinDuration(Double.parseDouble(lenth));
		route.setRegion(region);
		Dao<Route> routeDao = new Dao<Route>(Route.class, "en");
		int routeId = routeDao.insert(route);
		route.setId(routeId);
		System.out.println("route added!"+route);
		String[] placeNames = request.getParameterValues("places");
		//get places, set to route
		Dao<PlaceToRoute> ptrDao = new Dao<PlaceToRoute>(PlaceToRoute.class, "en");
		for(String placeName:placeNames){
			Place place = PlaceService.getPlaceByName(placeName);
			PlaceToRoute placeToRoute = new PlaceToRoute();
			placeToRoute.setPlaceId(place);
			placeToRoute.setRouteId(route);
			ptrDao.insert(placeToRoute);

		}
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date start=null, end=null;
		try {
			start = df.parse(startDate);
			System.out.println(start.toString());
			end = df.parse(endDate);
			System.out.println(end.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		//create tour
		Tour tour = new Tour();
		tour.setName(name);
		if(trans!=null){
			if(trans.equals("bus")){
				tour.setTransport("by bus");
			}else if(trans.equals("train")){
				tour.setTransport("by train");
			}else{
				tour.setTransport("by foot");
			}
		}else{
			tour.setTransport("undefined");
		}
		tour.setRoute_id(route);
		tour.setStartDate(new java.sql.Date(start.getTime()));
		tour.setEndDate(new java.sql.Date(end.getTime()));
		long diffTime = end.getTime() - start.getTime();
		int diffDays = (int) (diffTime / (1000 * 60 * 60 * 24));
		tour.setMinDuration(diffDays);
		tour.setMinCapacity(Integer.parseInt(capacity));
		tour.setMinPrice(Integer.parseInt(price));
		tour.setTripDays("no matter");
		tour.setStatusId("open");
		tour.setTripId(3);

		//create users
		if(photographer!=null&&photographer.length()>0){
			List<User> users = UserService.getUsersWhere("login", photographer);
			if(users.size()>0){
				tour.setPhotographId(users.get(0));
				tour.setPhotographRequired(true);
			}
		}
		if(guide!=null&&guide.length()>0){
			List<User> users = UserService.getUsersWhere("login", guide);
			if(users.size()>0){
				tour.setGuideId(users.get(0));
			}
		}
		if(transporter!=null&&transporter.length()>0){
			List<User> users = UserService.getUsersWhere("login", transporter);
			if(users.size()>0){
				tour.setTransporter(users.get(0));
			}
		}
		System.out.println("=======================");
		System.out.println(tour);
		TourService.insertTour(tour);
	}

}
