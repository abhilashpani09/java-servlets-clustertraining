package com.wipro;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalTime;

public class time extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		LocalTime currentTime = LocalTime.now();
		System.out.println(currentTime);
		String a = currentTime.toString();
		int h = Integer.parseInt(a.substring(0,2));
		System.out.println(h);
		if (h>=0 && h<12)
		{
			res.getWriter().println("Good Morning");
		}
		if (h>=12 && h<17)
		{
			res.getWriter().println("Good AfterNoon");
		}
		if (h>=17 && h<=23)
		{
			res.getWriter().println("Good Evening");
		}
		
	}

}
