package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {
	public MarriageServlet() {
		System.out.println("MarriageServlet:: 0-param constructor");
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost(-,-)");
		PrintWriter pw = null;//jh
		String name = null;
		String tage = null;
		String gender=null;
		int age = 0;

		// genral setting
		pw = res.getWriter();
		res.setContentType("text/html");

		// get request parameter values
		name = req.getParameter("name");
		tage = req.getParameter("age");
		gender=req.getParameter("gender");
		// parse age data
		age = Integer.parseInt(tage);

		// write request processing logic
		if(gender.equals("male")) {
			if (age >= 21) {
				pw.println("<h1 style='color:green'>Mr. " + name + " you are Eligible For Marriage</h1>");
				pw.println(" <img src='m2.jpg' style='width: 323px; height: 234px'><Br>");
			} else {
				pw.println("<h1 style='color:red'>Mr. " + name + " you are not Eligible For Marriage</h1>");
				pw.println(" <img src='m3.jpg' style='width: 323px; height: 234px'><Br>");
			}
			
		}//if male
		else if(gender.equalsIgnoreCase("Female")) {
			if (age >= 18) {
				pw.println("<h1 style='color:pink'>Miss. " + name + " you are Eligible For Marriage</h1>");
				pw.println(" <img src='m1.jpg' style='width: 323px; height: 234px'><Br>");
			} else {
				pw.println("<h1 style='color:red'>Miss. " + name + " you are not Eligible For Marriage</h1>");
				pw.println(" <img src='m3.jpg' style='width: 323px; height: 234px'><Br>");
			}
			
		}
		// add hyperlink
		pw.println("<a href='input.html'><img src='home.png' style='width: 79px; height: 72px'></a>");
		// close stream
		pw.close();//Avnish
	}// doPost()

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("VoterServlet.doGet()");
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}// class
