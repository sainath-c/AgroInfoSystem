package com.serv;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class AISServ
 */
@WebServlet("/AISServ")
public class AISServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AISServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub\
       String text = "some text";
        
		System.out.println(text);
		System.out.println(request.getParameter("region"));
		//String region=request.getParameter("region");
		//String soiltype=request.getParameter("soiltype");
		//int soilph=Integer.parseInt(request.getParameter("soilPH"));
		//int temperature=Integer.parseInt(request.getParameter("temperature"));
		
		JSONArray list = new JSONArray();
		  list.add("Maize");
		  list.add("Bhendi");

		JSONObject obj=new JSONObject();
		obj.put("crops",list);
		
		  StringWriter out = new StringWriter();
		  obj.writeJSONString(out);
		  String jsonText = out.toString();
		  System.out.print(jsonText);
		  
		
	    response.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
	    //response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(jsonText);       // Write response body.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
