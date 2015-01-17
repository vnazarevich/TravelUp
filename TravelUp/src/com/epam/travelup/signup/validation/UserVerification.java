package com.epam.travelup.signup.validation;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import com.epam.travelup.orm.model.User;
import com.epam.travelup.orm.service.UserService;

public class UserVerification extends HashMap<String, VerificationCommand> {

	private static UserVerification instance;

	private static final long serialVersionUID = 1L;

	private final String nameRegex="^\\p{L}+$";
	private final String loginRegex="^[A-Za-z0-9]+$";
	private final String emailRegex="^[A-Za-z0-9][^@\\!\\~\\?\\#\\$\\&()\\^]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

	private class NameVerificator implements VerificationCommand{
		@Override
		public boolean verify(String value) {
			Pattern pattern = Pattern.compile(nameRegex);
			return pattern.matcher(value).matches();
		}

	}

	private class EmailVerificator implements VerificationCommand{
		@Override
		public boolean verify(String value) {
			Pattern pattern = Pattern.compile(emailRegex);
			if(!pattern.matcher(value).matches()){
				return false;
			}

			return isUnique(value);
		}

		private boolean isUnique(String value){
			List<User> users = UserService.getUsersWhere("mail",value);
			if(users.size()==0){
				return true;
			}
		return false;
		}
	}

	private class LoginVerificator implements VerificationCommand{
		@Override
		public boolean verify(String value) {
			Pattern pattern = Pattern.compile(loginRegex);
			if(!pattern.matcher(value).matches()){
				return false;
			}

			return isUnique(value);
		}
		private boolean isUnique(String value){
			List<User> users = UserService.getUsersWhere("login", value);
			if(users.size()==0){
				return true;
			}
			return false;
		}

	}

	private UserVerification(){
		this.put("name", new NameVerificator());
		this.put("surname", new NameVerificator());
		this.put("login", new LoginVerificator());
		this.put("email", new EmailVerificator());
	}

	public static synchronized UserVerification getInstance(){
		if(instance==null){
			instance = new UserVerification();
		}
		return instance;
	}
}
