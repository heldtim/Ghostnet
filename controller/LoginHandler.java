package com.net.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SQLQuery;

import com.net.model.Person;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loggedIN")==null) {
					
		}else{
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

		}

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();
		
	 
		Hibernate.callHibernate();
		 String sqlQuery = "SELECT * FROM person WHERE email = :email AND password = :password";
         SQLQuery query = Hibernate.session.createSQLQuery(sqlQuery);
         query.setParameter("email", email);
         query.setParameter("password", password);
         query.addEntity(Person.class); // Specify the result entity type

         // Get the result (Person object) or null if no matching record found
         Person person = (Person) query.uniqueResult();
         Hibernate.session.close();
         if(person!=null) {
        	 //Hibernate.logged_in_person=person; 
        	
        	 request.getSession().setAttribute("loggedIN", person);
             request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            
            
         
		}
	}

}
