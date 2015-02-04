package com.epam.travelup.admin.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.scene.control.TabBuilder;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.epam.travelup.locaization.LanguageContainer;
import com.epam.travelup.orm.model.User;

public class UserTag extends SimpleTagSupport {
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void doTag() throws IOException {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String date = formatter.format(user.getDateOfRegistration());
		StringBuilder tagBuilder = new StringBuilder();
		// header
		tagBuilder.append("<div class='row'/>");
		if (user.isAdmin()) {
			tagBuilder.append("<div class='panel panel-primary'>");
		} else {
			if (user.isBanned()) {
				tagBuilder.append("<div class='panel panel-danger'>");
			} else {
				tagBuilder.append("<div class='panel panel-success'>");
			}
		}
		tagBuilder.append("<div class='panel-heading'>");
		tagBuilder.append("<h3 class='panel-title'>"
				+ user.getLogin()
				+ " "
				+ (user.isAdmin() ? "(admin) " : user.isBanned() ? "(BANNED) "
						: ""));
		if (user.getPortfolio() != null && user.getPortfolio().isPhotographer()) {
			tagBuilder.append("<i class='fa fa-picture-o'></i> ");
		}
		if (user.getPortfolio() != null && user.getPortfolio().isGuide()) {
			tagBuilder.append("<i class='fa fa-location-arrow'></i> ");
		}
		if (user.getPortfolio() != null && user.getPortfolio().isCarrier()) {
			tagBuilder.append("<i class='fa fa-bus'></i> ");
		}
		tagBuilder.append("</h3></div>");
		// body
		tagBuilder.append("<div class='panel-body'>");
		tagBuilder.append("<div class='col-md-8'>");
		tagBuilder.append("<ui>");
		tagBuilder.append("<li><b>" + user.getFirstName() + " "
				+ user.getLastName() + "</b></li>");
		tagBuilder.append("<li><b>"+LanguageContainer.getBundle().getString("users.page.email")+": </b>" + user.getMail() + "</li>");
		tagBuilder.append("<li><b>"+LanguageContainer.getBundle().getString("users.page.date")+": </b>" + date + "</li>");
		tagBuilder.append("</ui>");
		tagBuilder.append("</div>");
		tagBuilder.append("<div class='col-md-4'>");
		tagBuilder.append("<form method='get' action='userinfo'>");
		tagBuilder.append("<input type='hidden' name='userId' value='"
				+ user.getId() + "'>");
		tagBuilder
				.append("<button type='submit' class='btn btn-success btn-sm profile btn-block green' style='margin-top:5px'>"+LanguageContainer.getBundle().getString("users.page.profile")+"</button>");
		tagBuilder.append("</form>");
		if (!user.isAdmin()) {
			if (!user.isBanned()) {
				tagBuilder
						.append("<button class='btn btn-danger btn-sm ban btn-block green' user-id='"
								+ user.getId()
								+ "' style='margin-top:5px'>"+LanguageContainer.getBundle().getString("users.page.ban")+"</button>");
			} else {
				tagBuilder
						.append("<button class='btn btn-warning btn-sm unban btn-block green' user-id='"
								+ user.getId()
								+ "' style='margin-top:5px'>"+LanguageContainer.getBundle().getString("users.page.unban")+"</button>");
			}
			tagBuilder
					.append("<button class='btn btn-primary btn-sm admin btn-block green' user-id='"
							+ user.getId()
							+ "' style='margin-top:5px'>"+LanguageContainer.getBundle().getString("users.page.setadmin")+"</button>");
		}
		tagBuilder.append("</div>");
		tagBuilder.append("</div>");
		tagBuilder.append("</div>");
		tagBuilder.append("</div>");
		JspWriter out = getJspContext().getOut();
		out.println(tagBuilder.toString());
	}
}