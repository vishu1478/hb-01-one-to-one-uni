package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create sessionfactory

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		try {

			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").list();

			// display Student
			displayStudents(theStudents);

			// query students: lastname =agrwal
			theStudents = session.createQuery("from Student s where s.lastName='agrwal'").list();

			// display Student
			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where s.lastName='agrwal' OR s.firstName='shekhar'")
					.list();
			displayStudents(theStudents);
			System.out.println("hiiiiii");
			theStudents = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").list();
			displayStudents(theStudents);
			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
