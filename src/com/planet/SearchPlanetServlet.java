package com.planet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.*;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class SearchPlanetServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String action = req.getParameter("action");
		String planetName = req.getParameter("planet");
		
		System.out.println("Planet name: "+planetName);
		
		if("searchterm".equals(action)){
			//signIn(req, result);
		}
		/*else if ("get-centers-for-dealer".equals(action)){
			getCentersForDealer(req,result);
		}*/

		//Add it back to session
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=UTF-8");
		//resp.getWriter().print(new Gson().toJson(result));
	}
	
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, java.io.IOException {
	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) resp;

	    // This should be added in response to both the preflight and the actual request
	    response.addHeader("Access-Control-Allow-Origin", "*");

	    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
	        response.addHeader("Access-Control-Allow-Credentials", "true");
	    }

	    chain.doFilter(req, resp);
	}
}
