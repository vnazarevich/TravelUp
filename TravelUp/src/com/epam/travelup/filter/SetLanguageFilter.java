package com.epam.travelup.filter;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.travelup.locaization.LanguageContainer;

/**
 * Servlet Filter implementation class SetLanguageFilter
 */
@WebFilter("/SetLanguageFilter")
public class SetLanguageFilter implements Filter {

    /**
     * Default constructor.
     */
    public SetLanguageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		ResourceBundle lang = (ResourceBundle) session.getAttribute("lang");
		String locale = (String) session.getAttribute("langChange");
		if(lang==null){
			if(locale != null){
			LanguageContainer.SetLanguage(locale);
			}
			session.setAttribute("lang", LanguageContainer.getBundle());
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
