package com.epam.travelup.admin.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmitTourServlet
 */
@WebServlet("/SubmitTourServlet")
public class SubmitTourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitTourServlet() {
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
		String enName = request.getParameter("enName");
		String uaName = request.getParameter("uaName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date start=null, end=null;
		try {
			start = df.parse(startDate);
			System.out.println(start.toString());
			end = df.parse(endDate);
			System.out.println(end.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}


	}

}
