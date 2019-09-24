package com.wipro;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class numberCount
 */
@WebServlet("/numberCount")
public class numberCount extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 int num = Integer.parseInt(request.getParameter("num"));
		if(num<10)
		{
			response.sendRedirect("page1");
		}
		else if(num>10 && num<99)
		{
			response.sendRedirect("page2");
		}
		else
		{
			response.sendRedirect("page3");
		}
	}

}
