package com.net.controller;

import org.hibernate.SQLQuery;
import org.hibernate.Transaction;

import com.net.model.Net;
import com.net.model.Person;
import com.net.model.Status;

public class Executor {

	
	public boolean markAsRecovered(int net_id,int person_id) {
		
		try {
		Transaction tx = Hibernate.callHibernate();
		Net net = (Net)Hibernate.session.load(Net.class, net_id);
		Person person = (Person) Hibernate.session.load(Person.class, person_id);
		
		String sqlQuery = "SELECT * FROM status WHERE status = :s";
        SQLQuery query = Hibernate.session.createSQLQuery(sqlQuery);
        query.setParameter("s", "Recovered");
        
        query.addEntity(Status.class); // Specify the result entity type

        Status status = (Status) query.uniqueResult();
		
		net.setNet_status(status);

		net.setRecovered_by(person);
		Hibernate.session.saveOrUpdate(net);
		
		tx.commit();
		
		Hibernate.session.close();
		return true;
		}catch(Exception e) {
			return false;
		}
		
	}
	
	
	
	
}
