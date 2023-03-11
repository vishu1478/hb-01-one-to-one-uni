package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
        //create sessionfactory
		
	SessionFactory factory=new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Student.class).buildSessionFactory();
	
	//create session
	Session session=factory.getCurrentSession();
	try {
		  //create the student object
		Student tempStudent= new Student("Vishwajeet", "Agrwal","agrawal.vishwajeet5@gmail.com");
		//start the transaction
		session.beginTransaction();
		
		//save the student object
		System.out.println("saving the student");
		session.save(tempStudent);
		
		//commit transaction
		session.getTransaction().commit();
		
	} finally {
		factory.close();
	}
	}

}
