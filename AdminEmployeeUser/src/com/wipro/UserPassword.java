package com.wipro;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UserPassword
 */
@WebServlet("/UserPassword")
public class UserPassword extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		
		boolean flag = false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","mysql");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from t1");
			while(rs.next()) 
			{
				if(username.equals(rs.getString(1)) && password.equals(rs.getString(2)) && usertype.equals(rs.getString(3)))
				{
					flag = true;
					if (usertype.equals("A"))
					{
						response.sendRedirect("Admin");
					}
					if (usertype.equals("E"))
					{
						response.sendRedirect("Employee");
					}
					
				}
			}
			if(flag==false)
			{
				out.print("invalid username or password");
			}
			
		}catch(Exception p)
		{
			out.print(p);
		}
		
	}

}
