package com.planet;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.*;

import com.google.gson.Gson;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.annotation.Parent;

@SuppressWarnings("serial")
public class SearchPlanetServlet extends HttpServlet {
	
	Objectify db = DatabaseFactory.getDatabase();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
	}
	
	@Parent Key<SearchPlanet> parentKey;
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try{
			
		
		//String action = req.getParameter("action");
		String planetName = req.getParameter("planet");
		String time = req.getParameter("time");
		
		System.out.println("Planet name: "+planetName);
		System.out.println("Time: "+time);
		
		storeData(req, resp);
		
		/*else if ("get-centers-for-dealer".equals(action)){
			getCentersForDealer(req,result);
		}*/

		
		//DatabaseFactory dbFactory = new DatabaseFactory();
		//List<SearchPlanet> planetList = dbFactory.getStoredEntries();
		
		//Add it back to session
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=UTF-8");
		
		}catch(Exception e){
			System.out.println("Servlet error:"+e);
		}
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
	
	public void storeData(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String planetName = req.getParameter("planet");
		String time = req.getParameter("time");
		
		SearchPlanet planet = new SearchPlanet();
		
		try{
			planet.setSearchWord(planetName);
			planet.setTime(time);
			
			save(planet);
			
			resp.setStatus(1);
						
		}catch(Exception e){
			e.printStackTrace();
			resp.setStatus(-1);
			System.out.println("Error");
		}
		
		
		
	}
	
	public void save(SearchPlanet sp){
		
		List<SearchPlanet> planetList = db.query(SearchPlanet.class).list();

		int count = planetList.size();
		
		if (count >= 10){
			
			List<Long> sortList = new ArrayList<Long>();
			for (SearchPlanet planet: planetList){
				sortList.add(planet.id);
			}
			while(sortList.size() >= 10){
				SearchPlanet firstEntry = db.get(new Key<SearchPlanet>(SearchPlanet.class, sortList.get(0)));
				db.delete(firstEntry);	
				sortList.remove(sortList.get(0));
			}
			
		}
		
		db.put(sp);
		
		planetList.clear();
		planetList = db.query(SearchPlanet.class).list();
		
		System.out.println("Current Planet Search List:");
		
		for (SearchPlanet planet: planetList){
			System.out.println(planet.searchWord);
		}
		
		
	
	}
}
