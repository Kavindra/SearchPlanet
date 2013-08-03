package com.planet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.googlecode.objectify.Objectify;

@SuppressWarnings("serial")
public class SearchPlanetServlet extends HttpServlet {
	
	Objectify db = DatabaseFactory.getDatabase();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String action = req.getParameter("action");
		String planetName = req.getParameter("planet");
		String time = req.getParameter("time");
		
		System.out.println("Planet name: "+planetName);
		System.out.println("Time: "+time);
		System.out.println("Action: "+action);
		
		//storeData(req, resp);
		
		if ("save-data".equals(action)){
			storeData(req,resp);
		}

		//Add it back to session
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=UTF-8");
		resp.getWriter().print("Search Planet");
	}
	
	/*public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, java.io.IOException {
	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) resp;

	    // This should be added in response to both the preflight and the actual request
	    response.addHeader("Access-Control-Allow-Origin", "*");

	    if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
	        response.addHeader("Access-Control-Allow-Credentials", "true");
	    }

	    chain.doFilter(req, resp);
	}*/
	
	public void storeData(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String planetName = req.getParameter("planet");
		String time = req.getParameter("time");
		
		SearchPlanet planet = new SearchPlanet();
		
		try{
			planet.setSearchWord(planetName);
			planet.setTime(time);
			
			//List<SearchPlanet> planetsList = new ArrayList<SearchPlanet>();
			
			save(planet);
			
			resp.setStatus(200);
		}catch(Exception e){
			e.printStackTrace();
			resp.setStatus(-1);
		}
		
		
		
	}
	
	public void save(SearchPlanet sp){
		db.put(sp);
	}
}
