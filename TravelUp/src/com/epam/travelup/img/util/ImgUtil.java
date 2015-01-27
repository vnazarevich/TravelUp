package com.epam.travelup.img.util;

import javax.servlet.http.Part;

public class ImgUtil {
	
	public static boolean checkFileIsImage(Part part) {
		return part.getContentType().substring(0, 5).equalsIgnoreCase("image");
	}
}
