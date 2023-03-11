package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		try {
			  //create the student object
			Student tempStudent1= new Student("Shekhar", "Sman","shekhar@gmail.com");
			Student tempStudent2= new Student("jeet", "singh","jeet@gmail.com");
			Student tempStudent3= new Student("Anindita", "Shome","anindita@gmail.com");
			//start the transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		}

	}


