package com.net.controller;

import java.util.List;

import org.hibernate.SQLQuery;

import com.net.model.Net;
import com.net.model.Person;

public class Dispatcher {

	{
		//Hibernate.callHibernate();
		 //String sqlQuery = "SELECT * FROM person WHERE email = :email AND password = :password";
        //SQLQuery query = Hibernate.session.createSQLQuery(sqlQuery);
       // query.setParameter("email", email);
        //query.setParameter("password", password);
        //query.addEntity(Person.class); // Specify the result entity type

        // Get the result (Person object) or null if no matching record found
        //Person person = (Person) query.uniqueResult();
       
      //  if(person!=null) {
       	 //Hibernate.logged_in_person=person; 
       	 //request.getSession().setAttribute("loggedIN", person);
       	 
           // request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
           
        //}
        
        
        
      
        
        
	}
	
	  public List<Net> getLostNets() {
		  
		    Hibernate.callHibernate();
			String sqlQuery = "SELECT * FROM net WHERE recovered_by_person_id IS NULL";
	        SQLQuery query = Hibernate.session.createSQLQuery(sqlQuery);
	        query.addEntity(Net.class); 
	        
	       
	        @SuppressWarnings("unchecked")
			List<Net> nets = query.list();
	        System.out.println(nets.size());
	       Hibernate.session.close();
	        return nets;
      	
      }
	  
 public List<Net> getRecoveredNets(Person p) {
		  
		    Hibernate.callHibernate();
			String sqlQuery = "SELECT * FROM net WHERE recovered_by_person_id = :pid";
	        SQLQuery query = Hibernate.session.createSQLQuery(sqlQuery);
	        query.setParameter("pid", p.getPerson_id());
	        query.addEntity(Net.class);
	        
	       
	        @SuppressWarnings("unchecked")
			List<Net> nets = query.list();
	        System.out.println(nets.size());
	        Hibernate.session.close();
	        return nets;
      	
      }
	  
	
}
