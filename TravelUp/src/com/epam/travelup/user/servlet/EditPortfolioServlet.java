package com.epam.travelup.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.epam.travelup.img.util.ImgUtil;
import com.epam.travelup.orm.model.Photo;
import com.epam.travelup.orm.model.Portfolio;
import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.PhotoService;
import com.epam.travelup.orm.service.PortfolioService;

/**
 * Servlet implementation class EditPortfolioServlet
 */
@WebServlet("/EditPortfolioServlet")
@MultipartConfig
public class EditPortfolioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPortfolioServlet() {
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
		User user = (User) session.getAttribute("user");
		String guide = request.getParameter("guide");
		String transporter = request.getParameter("transporter");
		String photographer = request.getParameter("photographer");
		String description = request.getParameter("description");
		Portfolio portfolio = (Portfolio) session.getAttribute("portfolio");
		String portfolioId = portfolio.getId()+"";
		List<Photo> photos = (List<Photo>) session.getAttribute("userPhotos");
		System.out.println("Transporter: "+transporter+" Guide: "+guide+" Photographer: "+photographer);

		//update description
		if(description!=null&&!description.equals(portfolio.getDescription())){
			description=description.replaceAll("\\s"," ");
			PortfolioService.updatePortfolio(portfolioId, "description", description);
			portfolio.setDescription(description);
		}
		//update occupation
		boolean isGuide = guide!=null&&guide.equals("on");
		boolean isTransporter = transporter!=null&&transporter.equals("on");
		boolean isPhotographer = photographer!=null&&photographer.equals("on");


		if(isGuide!=portfolio.isGuide()){
			portfolio.setGuide(isGuide);
			PortfolioService.updatePortfolio(portfolioId, "is_guide", isGuide+"");
		}
		if(isPhotographer!=portfolio.isPhotographer()){
			portfolio.setPhotographer(isPhotographer);
			PortfolioService.updatePortfolio(portfolioId, "is_photographer", isPhotographer+"");
		}
		if(isTransporter!=portfolio.isCarrier()){
			portfolio.setCarrier(isTransporter);
			PortfolioService.updatePortfolio(portfolioId, "is_carrier", isTransporter+"");
		}


		//add images:
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
		//remove images
		for(int j=0; j<photos.size();){
			int photoId = photos.get(j).getId();
			String isExisting = request.getParameter("photo"+photoId);
			if(isExisting!=null&&isExisting.equals("deleted")){
				photos.remove(j);
				PhotoService.deleteImageById(photoId+"");
			}else{
				j++;
			}
		}
		//setting new session attr
		user.setPortfolio(portfolio);
		session.setAttribute("portfolio", portfolio);
		session.setAttribute("userPhotos", photos);
		response.sendRedirect("userpage");
	}

}
