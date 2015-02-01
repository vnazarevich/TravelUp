package com.epam.travelup.locaization.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.travelup.locaization.LanguageContainer;


/**
 * Servlet implementation class LanguageChangeServlet
 */
public class LanguageChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LanguageChangeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* Changing locale cookie */
		String locale = (String) request.getParameter("locale");
		if (locale != null) {
			HttpSession session = ((HttpServletRequest) request).getSession();
			if (locale.equals("ua")) {
				session.removeAttribute("lang");
				session.setAttribute("langChange", locale);
				LanguageContainer.SetLanguage("ua");
			} else {
				session.removeAttribute("lang");
				session.setAttribute("langChange", "en");
				LanguageContainer.SetLanguage("en");
			}

		}
		response.sendRedirect(request.getHeader("referer"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
