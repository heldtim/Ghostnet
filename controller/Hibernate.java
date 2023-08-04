package com.net.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.net.model.Net;
import com.net.model.Person;
import com.net.model.Status;

public class Hibernate {


	public static Session session;


	public static void main(String args[]) {
		
		Transaction tx = callHibernate();
		
		Status status1 = new Status();
		status1.setStatus("Recovered");
		
		Status status2 = new Status();
		status2.setStatus("Lost");
		
		
		session.saveOrUpdate(status1);
		session.saveOrUpdate(status2);
		
		Person person = new Person();
		person.setAnnonymous(0);
		person.setName("John");
		person.setPhone("01234567");
		person.setSurname("Doe");
		person.setEmail("s@gmail.com");
		person.setPassword("123");
		session.saveOrUpdate(person);
		
		
		Net net = new Net();
		net.setLatitute(111);
		net.setLongitude(222);
		net.setNet_status(status2);
		net.setReported_by(person);
		net.setSize(100);
	
		net.setReported_by(person);
		session.saveOrUpdate(net);
		List<Net> list = new ArrayList<>();
		list.add(net);
		
		person.setReportedby_nets(list);
		session.saveOrUpdate(person);
		
		tx.commit();
		
		
	}

	public static Transaction callHibernate(){
		
		System.out.println("Initializing Connection...");
		String configFilePath = "hibernate.cfg.xml";
		Configuration configuration = new Configuration().configure(configFilePath);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
			session  = factory.openSession();
			System.out.println("Session Started...");
			Transaction tx = session.beginTransaction();
			return tx;
	}
	
	
	
	}

	

