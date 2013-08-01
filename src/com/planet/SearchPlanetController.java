package com.planet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

/**
 * Servlet implementation class SearchPlanetController
 */
public class SearchPlanetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchPlanetController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String planetName = request.getParameter("planet");
		DefaultHttpClient   httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://data.nasa.gov/api/get_search_results/?search=" + planetName);
		// Depends on your web service
		httppost.setHeader("Content-type", "application/json");

		InputStream inputStream = null;
		String result = null;
		List<String> excerpts = new ArrayList<String>();
		
		try {
			HttpResponse jsonresponse = httpclient.execute(httppost);           
		    HttpEntity entity = jsonresponse.getEntity();

		    inputStream = entity.getContent();
		    // json is UTF-8 by default
		    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
		    StringBuilder sb = new StringBuilder();

		    String line = null;
		    while ((line = reader.readLine()) != null)
		    {
		        sb.append(line);
		    }
		    result = sb.toString();
		    		    
		    System.out.println("Result: " + result);
		    
		    System.out.println("Status1: ");
		    NasaResponseEntity data = new Gson().fromJson(result, NasaResponseEntity.class);
		    System.out.println("Status: " + data.getStatus());
		    
		    excerpts = data.getExcerpts();
		    
		    for(String excerpt:excerpts)
		    {
		    	System.out.println("Excerpt: " + excerpt);
		    }
		    
		} catch (Exception e) { 
		    // Oops
			System.out.println("Error: " + e);
		}
		finally {
		    try{if(inputStream != null)inputStream.close();}catch(Exception squish){}
		}
		
		request.setAttribute("jsonstring", result);
		request.setAttribute("excerpts", excerpts);
		RequestDispatcher view = request.getRequestDispatcher("PlanetDetails.jsp");
		view.forward(request,response);	
	}

}