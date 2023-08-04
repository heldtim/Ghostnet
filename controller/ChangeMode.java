package com.net.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import com.net.model.Person;

/**
 * Servlet implementation class ChangeMode
 */
@WebServlet("/ChangeMode")
public class ChangeMode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeMode() {
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
		String value = request.getParameter("selectMode").toString();
		int toSet = -1;
		if(value.equals("normalMode")) {
			toSet= 0;
		}else if(value.equals("anonymousMode")) {
			toSet= 1;
		}
		
		Transaction tx = Hibernate.callHibernate();
		Person p = (Person)request.getSession().getAttribute("loggedIN");
		
		Person loadedPerson = (Person)Hibernate.session.load(Person.class, p.getPerson_id());
		loadedPerson.setAnnonymous(toSet);
		Hibernate.session.saveOrUpdate(loadedPerson);
		tx.commit();
		Hibernate.session.close();
		
		request.getRequestDispatcher("Logout").forward(request, response);
		
	}

}
