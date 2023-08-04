package com.net.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportHandler
 */
@WebServlet("/ReportHandler")
public class ReportHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  Executor exe = new Executor();
		  boolean isDone = exe.markAsRecovered(Integer.parseInt(request.getParameter("netId").toString()), Integer.parseInt(request.getParameter("personId").toString()));
		  response.setContentType("text/plain");
	      response.setCharacterEncoding("UTF-8");
		  if(isDone) {
			  System.out.println("Done");
			  response.getWriter().write("Done");
		  }else {
			  System.out.println("Not Done");
			  response.getWriter().write("Not Done");
		  }
	}

}
