package com.epam.travelup.locaization;

import java.util.Locale;
import java.util.ResourceBundle;


public class LanguageContainer {
	private static  ResourceBundle bundle;
	public static void SetLanguage(String language){
		Locale locale;
		if(language.toLowerCase().equals("ua")){
			locale = new Locale.Builder().setLanguage("ua").setRegion("UA").build();
		}else{
			locale = new Locale.Builder().setLanguage("en").setRegion("US").build();
		}
		bundle = ResourceBundle.getBundle("option", locale,new UTF8Control());
	}

	public static ResourceBundle getBundle(){
		if(bundle==null){
			SetLanguage("en");
		}
		return bundle;
	}
}
