package com.epam.travelup.signup.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.locaization.LanguageContainer;
import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.UserService;
import com.epam.travelup.sender.MailActivationSender;

/**
 * @author Nazarevich V.
 */
@WebServlet("/ActivationAccountServlet")
public class ActivationAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	private final static Logger LOGGER = Logger.getLogger("ActivationAccountlServlet ::");
	private final static String LOGIN = "login";
	private final static String HASH = "hash";
	private final static String EMAIL = "mail";
	private String login;
	private String pass;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActivationAccountServlet() {
        super();
        System.out.println("Start activation account");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("ActivationAccountlServlet :: doGet()");
		User user1 = null;
		User user2 = null;
		List <User> userList1 = UserService.getUsersWhere(LOGIN, request.getParameter(LOGIN));
		List <User> userList2 = UserService.getUsersWhere(EMAIL, request.getParameter(HASH));
		
		System.out.println("request.getParameter(LOGIN) = " + request.getParameter(LOGIN));
		System.out.println("request.getParameter(HASH) = " + request.getParameter(HASH));
		
		System.out.println("List <User> userList1 = " + userList1);
		System.out.println("List <User> userList2 = " + userList2);

		try {
		if((userList1.size() == 1)  && (userList2.size() == 1)) {
			user1 = userList1.get(0);
			user2 = userList2.get(0);
		} if (user1.getId() == user2.getId() ){
			user1.setActive(true);
			//Dakhniy code
			UserService.activateUser(new Integer(user1.getId()).toString());
			//end code
			new MailActivationSender(user1.getFirstName(), user1.getMail(), user1.getLogin())
			.sendRegistrationCompleted();
			}
		} catch (Exception e) {
			LOGGER.info("ActivationAccountServlet :: doGet() +" + e);
			new MailActivationSender(null, request.getParameter(HASH), null);
			//Page Error
		}
		request.setAttribute("status", LanguageContainer.getBundle().getString("auth.approved"));
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
	}



}
