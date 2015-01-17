package com.epam.dakhniy.signup.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.dakhniy.locaization.LanguageContainer;
import com.epam.dakhniy.orm.dao.Dao;
import com.epam.dakhniy.orm.model.User;
import com.epam.dakhniy.orm.service.UserService;
import com.epam.dakhniy.orm.transformer.Transformer;
import com.epam.dakhniy.signup.validation.UserVerification;
import com.epam.dakhniy.signup.validation.VerificationCommand;

/**
 * Servlet implementation class ConfirmSignupServlet
 */
@WebServlet("/ConfirmSignupServlet")
public class ConfirmSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmSignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean confirmed=true;
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()){
			String attr = en.nextElement();
			String value = request.getParameter(attr);
			VerificationCommand command = UserVerification.getInstance().get(attr);
			if(command!=null){
				confirmed=command.verify(value);
				if(!confirmed){
					break;
				}
			}
		}
		if(confirmed){
			User user = new User();
			java.util.Calendar cal = java.util.Calendar.getInstance();
			java.util.Date utilDate = cal.getTime();
			user.setDateOfRegistration(new Date(utilDate.getTime()));
			user.setLogin(request.getParameter("login"));
			user.setMail(request.getParameter("email"));
			user.setFirstName(request.getParameter("name"));
			user.setActive(false);
			user.setLastName(request.getParameter("surname"));
			user.setPassword(request.getParameter("password"));
			try{
				UserService.insertUser(user);
			}catch(Exception e){
				//LOG HERE
				request.setAttribute("status", LanguageContainer.getBundle().getString("auth.fail"));
			}
			request.setAttribute("status", LanguageContainer.getBundle().getString("auth.success"));

		}else{
			request.setAttribute("status", LanguageContainer.getBundle().getString("auth.fail"));
		}
		request.getRequestDispatcher("pages/signup.jsp").forward(request, response);

	}

}
