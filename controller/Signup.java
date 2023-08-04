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
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
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
	String email = request.getParameter("email").toString();
	String password = request.getParameter("password").toString();
	String name = request.getParameter("name").toString();
	String phone = request.getParameter("phone").toString();
	String surname = request.getParameter("surname").toString();
	
	
	Transaction tx = Hibernate.callHibernate();
	Person p = new Person();
	p.setEmail(email);
	p.setName(name);
	p.setPhone(phone);
	p.setSurname(surname);
	p.setPassword(password);
	
	Hibernate.session.saveOrUpdate(p);
	tx.commit();
	Hibernate.session.close();
	
    request.getRequestDispatcher("Logout").forward(request, response);
	}

}
