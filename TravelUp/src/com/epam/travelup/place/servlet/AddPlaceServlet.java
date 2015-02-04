package com.epam.travelup.place.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.epam.travelup.img.util.ImgUtil;
import com.epam.travelup.orm.model.Photo;
import com.epam.travelup.orm.model.Place;
import com.epam.travelup.orm.model.PlaceInfo;
import com.epam.travelup.orm.model.Region;
import com.epam.travelup.orm.service.PhotoService;
import com.epam.travelup.orm.service.PlaceService;
import com.epam.travelup.orm.service.RegionService;

/**
 * Servlet implementation class AddPlaceServlet
 */
public class AddPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPlaceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("pages/addPlace.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uaName = request.getParameter("uaplacename");
		String enName = request.getParameter("enplacename");
		String uaDescription = request.getParameter("uaplacedescription");
		String enDescription = request.getParameter("enplacedescription");
		String regionString = request.getParameter("region");
		String xCoordinate = request.getParameter("xcoordinate");
		String yCoordinate = request.getParameter("ycoordinate");
		
		System.out.println(uaName+" "+enName +" "+ uaDescription+" "+ enDescription+" "+ regionString+" "+ xCoordinate+" "+yCoordinate);

		Place place = new Place();

		List<Region> regions = RegionService.getRegionsWhereNameEquals(
				regionString, "en");
		if (regions.isEmpty()) {
			Region region = new Region();
			region.setUaRegion(regionString);
			RegionService.insertRegion(region);
			place.setRegion(region);
		} else {
			place.setRegion(regions.get(0));
		}

		PlaceInfo placeInfo = new PlaceInfo();
		placeInfo.setUaName(uaName);
		placeInfo.setEnName(enName);
		placeInfo.setUaDescription(uaDescription);
		placeInfo.setEnDescription(enDescription);
		placeInfo.setId(PlaceService.countPlaces() + 1);

		place.setInfo(placeInfo);
		place.setxCoordinate(xCoordinate);
		place.setyCoordinate(yCoordinate);
		PlaceService.insertPlaceInfo(placeInfo);
		PlaceService.insertPlace(place);

		// some fun with images:
		int i = 1;
		Part image = request.getPart("file" + i);
		String savePath = (String) getServletContext()
				.getAttribute("FILES_DIR");
		while (image != null) {
			String link = ImgUtil.saveImage(place.getInfo().getEnName(), image,
					savePath);
			Photo photo = new Photo();
			photo.setPhotolink(link);
			PhotoService.insertPhoto(photo);
			i++;
			image = request.getPart("file" + i);
		}
		
	}

}
