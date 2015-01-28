package com.epam.travelup.user.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.epam.travelup.img.util.ImgUtil;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.UserService;

/**
 * Servlet implementation class UserImageServlet
 */
@WebServlet("/UserImageServlet")
@MultipartConfig
public class UserImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int BUFFER_LENGTH = 4096;
	private final String SAVE_DIR = "user-pictures";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserImageServlet() {
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
		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("user");
		Part image = request.getPart("image");
		String savePath = (String) getServletContext().getAttribute("FILES_DIR");
		String link = ImgUtil.saveImage(sessionUser.getLogin(), image, savePath);
		if(link!=null){

			sessionUser.setPicture(link);
			UserService.updateUserInfo(sessionUser.getId()+"", "picture", link);
		}

	}



}
