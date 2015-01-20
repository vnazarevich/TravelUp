package com.epam.travelup.admin.util;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.epam.travelup.orm.model.User;

public class UserTag extends SimpleTagSupport {
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void doTag() throws IOException{
		StringBuilder tagBuilder = new StringBuilder();
		//header

		if(user.isAdmin()){
			tagBuilder.append("<div class='panel panel-primary'>");
		}else{
			if(user.isBanned()){
				tagBuilder.append("<div class='panel panel-danger'>");
			}else{
				tagBuilder.append("<div class='panel panel-success'>");
			}
		}
		tagBuilder.append("<div class='panel-heading'>");
		tagBuilder.append("<h3 class='panel-title'>"+user.getLogin()+" ");
		tagBuilder.append("<div class='btn-group btn-group-sm' role='group' aria-label='...'>");
		tagBuilder.append("<button class='btn btn-success btn-sm profile' user-id='"+user.getId()+"'>Go to profile</button>");
		if(!user.isAdmin()){
			if(!user.isBanned()){
				tagBuilder.append("<button  class='btn btn-danger btn-sm ban' user-id='"+user.getId()+"'>Ban User</button>");
			}else{
				tagBuilder.append("<button  class='btn btn-warning btn-sm unban' user-id='"+user.getId()+"'>Unban User</button>");
			}
			tagBuilder.append("<button class='btn btn-primary btn-sm admin' user-id='"+user.getId()+"'>Set admin</button>");
		}

		tagBuilder.append("</div>");

		tagBuilder.append("</h3></div>");
		//body
		tagBuilder.append("<div class='panel-body'>");

		tagBuilder.append("</div>");
		tagBuilder.append("</div>");
		//System.out.println(tagBuilder);
	    JspWriter out = getJspContext().getOut();
	    out.println(tagBuilder.toString());
	}
}
