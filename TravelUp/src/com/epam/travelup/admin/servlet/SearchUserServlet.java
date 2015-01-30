package com.epam.travelup.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.admin.util.UserSearcher;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.UserService;

/**
 * Servlet implementation class SearchUserServlet
 */
@WebServlet("/SearchUserServlet")
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guides=request.getParameter("guides");
		String transporters=request.getParameter("transporters");
		String photographers=request.getParameter("photographers");
		if(request.getParameter("pageNo")==null){
			request.setAttribute("pageNo", 0);
		}
		String pageString=request.getParameter("pageNo");
		int pageNo=0;
		try{
			pageNo=Integer.parseInt(pageString);
		}catch(Exception e){
			System.out.println("Wrong page number format");
		}
		System.out.println("Page: "+pageNo);
		final int rowCount=5;
		int offset=pageNo*rowCount;

		boolean isGuide=false;
		boolean isTransporter=false;
		boolean isPhoto=false;

		if(guides!=null){
			isGuide=guides.equals("on");
		}

		if(transporters!=null){
			isTransporter=transporters.equals("on");
		}

		if(photographers!=null){
			isPhoto=photographers.equals("on");
		}
		String key = request.getParameter("key");
		List<User> users = UserSearcher.search(key, isPhoto, isTransporter, isGuide, offset, rowCount);
		User.sortByDate(users);
		int userCount = UserService.countUsers();
		System.out.println("User count: "+userCount);
		int pageCount = (userCount/rowCount)+(userCount%rowCount>0?1:0);
		System.out.println("Page count: "+pageCount);
		System.out.println(users);
		request.setAttribute("users", users);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNo", pageNo);
		if(isGuide||isPhoto||isTransporter){
			request.setAttribute("pagination", "no");
		}
		request.getRequestDispatcher("pages/admin_users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
