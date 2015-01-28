package com.epam.travelup.signup.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.locaization.LanguageContainer;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.UserService;
import com.epam.travelup.password.PasswordCoder;
import com.epam.travelup.sender.MailActivationSender;
import com.epam.travelup.signup.validation.UserVerification;
import com.epam.travelup.signup.validation.VerificationCommand;




/**
 * Servlet implementation class ConfirmSignupServlet
 */
@WebServlet("/ConfirmSignupServlet")
public class ConfirmSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOGGER = Logger.getLogger("ConfirmSignupServlet::");

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmSignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	response.sendRedirect("index");
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
			MailActivationSender sender = new MailActivationSender(user.getFirstName(), user.getMail(), user.getLogin());
			sender.sendActivationAccount();
			try {
				String password = PasswordCoder.getSecurePassword(request.getParameter("password"), user.getMail());
				user.setPassword(password);
	   			UserService.insertUser(user);
			}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("status", LanguageContainer.getBundle().getString("auth.fail"));
			}
			request.setAttribute("status", LanguageContainer.getBundle().getString("auth.success"));

		}else{
			request.setAttribute("status", LanguageContainer.getBundle().getString("auth.fail"));
		}
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);

	}

}
