package com.epam.dakhniy.signup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.dakhniy.locaization.LanguageContainer;

/**
 * Servlet implementation class SignUpStartServlet
 */
@WebServlet("/SignUpStartServlet")
public class SignUpStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpStartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		LanguageContainer.SetLanguage("ua");
		//System.out.println(LanguageContainer.getBundle().getString("auth.message.wrong-password"));
		session.setAttribute("lang", LanguageContainer.getBundle());
		request.getRequestDispatcher("pages/signup.jsp").forward(request, response);
	}

}
