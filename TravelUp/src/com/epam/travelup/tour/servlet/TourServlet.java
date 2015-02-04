package com.epam.travelup.tour.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.travelup.locaization.LanguageContainer;
import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.TourService;
import com.epam.travelup.requestServices.ModelCreaterService;

/**
 * Servlet implementation class TourServlet
 */

public class TourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<Tour> tours = null;
		if(user == null || !user.isAdmin()){
			tours = TourService.getSimpleTours(LanguageContainer.getBundle().getLocale().getLanguage());
		} else {
			
			String check = (String)request.getSession().getAttribute("check");
			System.out.println("------------" + check);
			if(check == null || check.equals("")){
				request.getSession().setAttribute("check", "1");
				tours = TourService.getAllTours(LanguageContainer.getBundle().getLocale().getLanguage());
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!1");
			}else if(check.equals("0")){
				request.getSession().setAttribute("check", "1");
				tours = TourService.getAllTours(LanguageContainer.getBundle().getLocale().getLanguage());
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2");
			} else if(check.equals("1")){
				request.getSession().setAttribute("check", "0");
				new ModelCreaterService().createModels();
				tours = TourService.getTourMackets();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!3");
			}
			
		}
	
		
		request.setAttribute("tourList", tours);
		System.out.println(tours);
		request.getRequestDispatcher("pages/tours.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
