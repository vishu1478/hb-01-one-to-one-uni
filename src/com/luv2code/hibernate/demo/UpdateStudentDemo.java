package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create sessionfactory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		try {
			int studentId=1;
		// create session
		Session session = factory.getCurrentSession();
		
             
             
			// start the transaction
			session.beginTransaction();
         Student myStudent=session.get(Student.class, studentId);
         myStudent.setFirstName("Roahn");
			// commit transaction
			session.getTransaction().commit();
			session = factory.getCurrentSession();
			// start the transaction
			session.beginTransaction();
			
			//update all email to abc@gmail.com
         session.createQuery("update Student set email='abc@gmail.com'").executeUpdate();
			// commit transaction
		session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
