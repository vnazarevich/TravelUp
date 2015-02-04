package com.epam.travelup.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.travelup.locaization.LanguageContainer;
import com.epam.travelup.orm.model.Cart;
import com.epam.travelup.orm.model.Photo;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.CartService;
import com.epam.travelup.orm.service.PhotoService;

/**
 * Servlet implementation class StartUserServlet
 */
@WebServlet("/StartUserServlet")
public class StartUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user = (User)session.getAttribute("user");
		List<Photo> photos = PhotoService.getPhotosForUser(user.getId()+"");
		System.out.println(photos);
		session.setAttribute("userPhotos", photos);
		String language = LanguageContainer.getBundle().getLocale().getLanguage();
		List<Cart> orders = CartService.getCart(user.getId()+"", language);
		System.out.println(orders);
		request.setAttribute("orderList", orders);
		request.getRequestDispatcher("pages/userPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();



		if(session.getAttribute("user") == null){
			response.getWriter().write("0");
		} else {
			response.getWriter().write("1");
		}
	}

}
