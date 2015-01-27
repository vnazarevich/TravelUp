package com.epam.travelup.img.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.epam.travelup.img.util.ImgUtil;
import com.epam.travelup.orm.model.User;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
// 50MB
public class ImgLoaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ImgLoaderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/imgLoader.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User sessionUser = (User) session.getAttribute("user");

		Part image = request.getPart("image");

		if (image.getSize() > 0) {
			if (ImgUtil.checkFileIsImage(image)){
				
			String fileName = sessionUser.getLogin() + "_"
					+ image.getSubmittedFileName();
			String savePath = (String) getServletContext().getAttribute(
					"FILES_DIR");

			image.write(savePath + File.separator + fileName);
			System.out.println(savePath);
			request.setAttribute("loadimage", fileName);

			}else{
				System.out.println("File is not an image");
				request.getRequestDispatcher("pages/imgLoader.jsp").forward(request,
						response);
			}
				
		}else{
			System.out.println("File not found");
			request.getRequestDispatcher("pages/imgLoader.jsp").forward(request,
					response);
		}
		request.getRequestDispatcher("pages/imgShow.jsp").forward(request,
				response);

	}
}
