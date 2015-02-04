package com.epam.travelup.user.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Cart;
import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.model.UserToTour;
import com.epam.travelup.orm.service.CartService;
import com.epam.travelup.orm.service.TourService;
import com.epam.travelup.orm.service.UserService;
import com.epam.travelup.orm.service.UserToTourService;
import com.epam.travelup.tour.util.DataParser;

/**
 * Servlet implementation class BuyTourServlet
 */
@WebServlet("/BuyTourServlet")
public class BuyTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyTourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		String dateInString = request.getParameter("date");
		String tourId = request.getParameter("tour");
		
		List<Tour> tours = TourService.getToursWhere("id", tourId, "en");
		Tour tour = tours.get(0);
		
		Cart cart = new Cart();
		cart.setPaid(false);
		cart.setTourId(tour);
		cart.setUserId(user);
		Timestamp date = DataParser.parseToSqlDate(dateInString);
		new Dao<Cart>(Cart.class,"en").insert(cart);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String tourId = request.getParameter("tourId");
		Tour tour = TourService.getToursWhere("id", tourId, "en").get(0);
		String quantity = request.getParameter("quantity");
		int quantityInt = Integer.parseInt(quantity);
		if(tour==null){
			System.err.println("no tour found!");
		}else{
			int freePlaces=tour.getMinCapacity()-UserToTourService.getUserCountByTour(tourId);
			if(quantityInt<freePlaces){
				UserToTour userToTour = new UserToTour();
				userToTour.setTourId(tour);
				userToTour.setUserId(user);
				userToTour.setQuantity(quantityInt);
				UserToTourService.insert(userToTour);
				CartService.payForTour(user.getId()+"", tourId);
				request.setAttribute("isPaid", "ok");
			}else{
				request.setAttribute("isPaid", "error");
			}
		}
		//request.getRequestDispatcher("/userpage").forward(request, response);
		response.sendRedirect("userpage");
	}

}
