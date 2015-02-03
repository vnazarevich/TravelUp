package com.epam.travelup.admin.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.locaization.LanguageContainer;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.PlaceService;
import com.epam.travelup.orm.service.UserService;

/**
 * Servlet implementation class StartCreateTourServlet
 */
@WebServlet("/StartCreateTourServlet")
public class StartCreateTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartCreateTourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lang = LanguageContainer.getBundle().getLocale().getLanguage();
		List<Place> places = PlaceService.getAll(lang);
		Map<String, List<User>> specialists = UserService.getSpecialists();
		List<User> guides =specialists.get("guides");
		List<User> photographers =specialists.get("photographers");
		List<User> transporters =specialists.get("transporters");
		request.setAttribute("places", places);
		request.setAttribute("guides", guides);
		request.setAttribute("photographers", photographers);
		request.setAttribute("transporters", transporters);
		request.getRequestDispatcher("pages/createTour.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
