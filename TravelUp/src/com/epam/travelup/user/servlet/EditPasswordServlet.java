package com.epam.travelup.user.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.UserService;
import com.epam.travelup.password.PasswordCoder;

/**
 * Servlet implementation class EditPasswordServlet
 */
@WebServlet("/EditPasswordServlet")
public class EditPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPasswordServlet() {
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
		try {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			User user = (User) request.getSession().getAttribute("user");
			oldPassword = PasswordCoder.getSecurePassword(oldPassword, user.getMail());
			if(oldPassword.equals(user.getPassword())){
				newPassword = PasswordCoder.getSecurePassword(newPassword, user.getMail());
				UserService.updateUserInfo(""+user.getId(), "password", newPassword);
				user.setPassword(newPassword);
				request.getSession().setAttribute("user", user);
				response.getWriter().write("ok");
			}else{
				response.getWriter().write("error");
			}
		} catch (Exception e) {
			response.getWriter().write("error");
			e.printStackTrace();
		}

	}

}
