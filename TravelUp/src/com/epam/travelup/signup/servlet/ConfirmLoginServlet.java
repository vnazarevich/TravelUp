package com.epam.travelup.signup.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.locaization.LanguageContainer;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.UserService;
import com.epam.travelup.password.PasswordCoder;

/**
 * Servlet implementation class ConfirmLoginServlet
 */
@WebServlet("/ConfirmLoginServlet")
public class ConfirmLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		List<User> users=UserService.getUsersWhere("login", login);
		User user=null;
		boolean logined=true;
		if(users.size()==0){
			logined=false;
		}else{
			user=users.get(0);
			try {
				password=PasswordCoder.getSecurePassword(password, user.getMail());
				System.out.println(password);
			} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
				e.printStackTrace();
				logined=false;
			}
			if(!user.getPassword().equals(password)){
				logined=false;
			}
		}
		if(logined){

			if(user.isBanned()){
				response.getWriter().write("banned");
			}else if(!user.isActive()){
				response.getWriter().write("disapproved");
			}else{
				request.getSession().setAttribute("user", user);
				System.out.println(user);
				response.sendRedirect("");
			}

		}else{
			response.getWriter().write("error");
		}

	}

}
