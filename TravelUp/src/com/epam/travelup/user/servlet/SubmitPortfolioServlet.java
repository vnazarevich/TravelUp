package com.epam.travelup.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.epam.travelup.img.util.ImgUtil;
import com.epam.travelup.orm.model.Photo;
import com.epam.travelup.orm.model.Portfolio;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.PhotoService;
import com.epam.travelup.orm.service.PortfolioService;
import com.epam.travelup.orm.service.UserService;

/**
 * Servlet implementation class SubmitPortfolioServlet
 */
@WebServlet("/SubmitPortfolioServlet")
@MultipartConfig
public class SubmitPortfolioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitPortfolioServlet() {
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
		User user = (User) request.getSession().getAttribute("user");
		String guide = request.getParameter("guide");
		String transporter = request.getParameter("transporter");
		String photographer = request.getParameter("photographer");
		String description = request.getParameter("description");
		System.out.println("Transporter: "+transporter+" Guide: "+guide+" Photographer: "+photographer);
		if(description!=null){
			description=description.replaceAll("\\s"," ");
		}
		Portfolio portfolio = new Portfolio();
		if(guide!=null&&guide.equals("on")){
			portfolio.setGuide(true);
		}
		if(transporter!=null&&transporter.equals("on")){
			portfolio.setCarrier(true);
		}
		if(photographer!=null&&photographer.equals("on")){
			portfolio.setPhotographer(true);
		}
		portfolio.setDescription(description);
		int portfolioId=PortfolioService.insertPortfolio(portfolio);
		user.setPortfolio(portfolio);
		UserService.updateUserInfo(user.getId()+"", "portfolio_id", portfolioId+"");
		//some fun with images:
		int i=1;
		Part image = request.getPart("file"+i);
		String savePath = (String) getServletContext().getAttribute("FILES_DIR");
		while(image!=null){
			String link = ImgUtil.saveImage(user.getLogin(), image, savePath);
			Photo photo = new Photo();
			photo.setPhotographId(user.getId());
			photo.setPhotolink(link);
			PhotoService.insertPhoto(photo);
			i++;
			image=request.getPart("file"+i);
		}
		response.sendRedirect("userpage");
	}

}
