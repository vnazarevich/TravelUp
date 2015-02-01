package com.epam.travelup.tour.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.travelup.orm.dao.Dao;
import com.epam.travelup.orm.model.Comment;
import com.epam.travelup.orm.model.Tour;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.tour.util.DataParser;

/**
 * Servlet implementation class AddCommentServlet
 */
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
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
		Dao<Comment> dao = new Dao<>(Comment.class, "en");
		Dao<Tour> dao2 = new Dao<>(Tour.class, "en");
		String text = request.getParameter("comment");
		String tourId = request.getParameter("tourId");
		User user = (User) request.getSession().getAttribute("user");
		String dateInString = request.getParameter("date");
		Timestamp date = DataParser.parseToSqlDate(dateInString);
		List<Tour> tours = dao2.selectWhere("id", tourId, "=");
		
		System.out.println(text + " " + tourId +" "+ dateInString + " " + user);
		
		Comment newComment = new Comment(tours.get(0), user, text, date);
		
		dao.insert(newComment);
	}

}
