package com.ngp.servlet.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	String flag="incorrect";
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String un=request.getParameter("username");
		String pass=request.getParameter("password");
		
				System.out.println(1);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		System.out.println(2);
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		System.out.println(3);
		Statement stmt=connection.createStatement();
		String sql="select * from login where username='"+un+"'and password='"+pass+"'";
		ResultSet rs=stmt.executeQuery(sql);
		System.out.println(sql);
		//ResultSet rs=stmt.executeQuery(sql);
		//System.out.println(5);
		
		if(rs.next())
		{
			System.out.println(4);
			flag="corrct";
			
		}
		//while(rs.next()) {
			//String sid=rs.getString(1);
			//String sname=rs.getString(2);
			//System.out.println(sid);
			//System.out.println(sname);
			
		//}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
			if("corrct".equals(flag)) {
		//if("ngp".equals(un)&&("123".equals(pass))) {
			
			
			System.out.println(5);
			ArrayList<String> al= new ArrayList<String>();
			al.add("sachin");
			al.add("mahesh");
			al.add("kiran");
			al.add("ram");
			al.add("sham");
			request.setAttribute("data", al);
			RequestDispatcher rd= request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("msg", "Password is wrong...");
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}
		
			}
	}


