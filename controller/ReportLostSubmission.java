package com.net.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import com.net.model.Net;
import com.net.model.Person;
import com.net.model.Status;

/**
 * Servlet implementation class ReportLostSubmission
 */
@WebServlet("/ReportLostSubmission")
public class ReportLostSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportLostSubmission() {
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
		
		try {
		Person p = (Person)request.getSession().getAttribute("loggedIN");
		if(p.getAnnonymous()==1) {
			  request.getRequestDispatcher("/WEB-INF/operation.jsp").forward(request, response);
		}else {
			
			String size = request.getParameter("size");
			String latitude = request.getParameter("latitude");
			String longitude =request.getParameter("longitude");
			
			Transaction tx = Hibernate.callHibernate();
			
			
			String sqlQuery = "SELECT * FROM status WHERE status = :s";
	        SQLQuery query = Hibernate.session.createSQLQuery(sqlQuery);
	        query.setParameter("s", "Lost");
	        
	        query.addEntity(Status.class); // Specify the result entity type

	        
	        Status status = (Status) query.uniqueResult();
	       
	        if(status!=null) {
	       	 
	       
	        	Net net = new Net();
				net.setLatitute(Double.parseDouble(latitude));
				net.setLongitude(Double.parseDouble(longitude));
				net.setSize(Integer.parseInt(size));
				net.setNet_status(status);
				net.setReported_by(p);
	          
				Hibernate.session.saveOrUpdate(net);
				tx.commit();
	           Hibernate.session.close();
	       	   request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	        }
			
		}
		}catch(Exception e) {
			response.getWriter().write("Go back and enter data very carefully");
		}
	}

}
