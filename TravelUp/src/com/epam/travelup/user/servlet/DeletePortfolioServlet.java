package com.epam.travelup.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.PhotoService;
import com.epam.travelup.orm.service.PortfolioService;

/**
 * Servlet implementation class DeletePortfolioServlet
 */
@WebServlet("/DeletePortfolioServlet")
public class DeletePortfolioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePortfolioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		PortfolioService.removePortfolio(user.getId()+"");
		PhotoService.deleteImagesByUser(user.getId()+"");
		user.setPortfolio(null);
		session.setAttribute("user", user);
		session.setAttribute("portfolio", null);
		session.setAttribute("userPhotos", null);
		response.sendRedirect("userpage");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
