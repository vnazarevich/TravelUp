package com.epam.travelup.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.locaization.LanguageContainer;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.service.PlaceService;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lang = LanguageContainer.getBundle().getLocale().getLanguage();
		List<Place> places = PlaceService.getAll(lang);
		request.setAttribute("places", places);
		
		request.getRequestDispatcher("pages/request.jsp").forward(request, response);
	}

}
