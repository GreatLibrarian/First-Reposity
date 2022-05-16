package jpa.service;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.CourseDAO;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {
	
	private Session session;
	private SessionFactory factory;
	private Transaction t;

	//When the class is initialized it connects to the DB
	public CourseService() {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
	}

	//I took what I did for getAllStudents() and translated it to here
	@Override
	public List<Course> getAllCourses() {
		String query = "SELECT a FROM Course a";
		List<Course> data = session.createQuery(query).getResultList();
		return data;
	}
	
	//Method to close the sessions when we're done
	public void close() {
		session.close();
		factory.close();
	}
}
