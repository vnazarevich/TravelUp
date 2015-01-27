package com.epam.travelup.img.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

public class ImgUtil {

	public static boolean checkFileIsImage(Part part) {
		return part.getContentType().substring(0, 5).equalsIgnoreCase("image");
	}


	/* In servlet:
	 *  image = request.getPart("<name of the file input>");
	 * savePath = (String) getServletContext().getAttribute("FILES_DIR");
	 * returns link if all is OK, else - null*/
	public static String saveImage(String userLogin, Part image, String savePath){
		String fileName=null;
		if (image.getSize() > 0) {
			if (ImgUtil.checkFileIsImage(image)){

			fileName = userLogin + "_"+System.currentTimeMillis()+"_"+ image.getSubmittedFileName();
			try {
				image.write(savePath + File.separator + fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(savePath);

			}else{
				System.out.println("File is not an image");
			}

		}else{
			System.out.println("File not found");
		}
		return fileName;
	}
}
