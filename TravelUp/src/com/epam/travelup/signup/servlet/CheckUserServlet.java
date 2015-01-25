package com.epam.travelup.signup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.signup.validation.UserVerification;
import com.epam.travelup.signup.validation.VerificationCommand;


/**
 * Servlet implementation class VerificationServlet
 */
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserServlet() {
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
		String attr = request.getParameter("attr");
		String value = request.getParameter("value");
		VerificationCommand command = UserVerification.getInstance().get(attr);
		boolean result = true;
		if(command!=null){
			result = command.verify(value);
		}
		System.out.println(result);
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    if(!result){
	    	response.getWriter().write("error");
	    }else{
	    	response.getWriter().write("ok");
	    }

	}

}
