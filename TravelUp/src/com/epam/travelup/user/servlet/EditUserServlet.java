package com.epam.travelup.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.UserService;
import com.epam.travelup.signup.validation.UserVerification;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
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
		User user = (User) request.getSession().getAttribute("user");
		boolean verificationStatus=true;
		if(attr.equals("mail")){
			verificationStatus=UserVerification.getInstance().get("email").verify(value);
		}else{
			verificationStatus=UserVerification.getInstance().get("name").verify(value);
		}
		if(verificationStatus){
			UserService.updateUserInfo(new Integer(user.getId()).toString(), attr, value);
			user = UserService.getUsersWhere("id", ""+user.getId()).get(0);
			request.getSession().setAttribute("user", user);
			response.getWriter().write("ok");
		}else{
			response.getWriter().write("error");
		}
	}

}
