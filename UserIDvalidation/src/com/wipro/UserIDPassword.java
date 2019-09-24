package com.wipro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class UserIDPassword extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter(); 
		String username = req.getParameter("uname");
		String password = req.getParameter("password");
		// HttpSession session = req.getSession();
		System.out.println(username + password+"jkhbjmhc");
		boolean flag = false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin","root","mysql");
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			while(rs.next())
			{
				if(username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
				flag = true;
				res.sendRedirect("success");
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
