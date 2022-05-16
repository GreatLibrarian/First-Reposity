package jpa.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {

	private Session session;
	private SessionFactory factory;
	private Transaction t;

	// When the class is initialized, it'll connect to the database
	public StudentService() {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
	}

	@Override
	public List<Student> getAllStudents() {
		String query = "SELECT a FROM Student a";
//		I do get a warning here that the conversion from List<Object> to List<Student> 
//		isn't safe, but since all data from the DB is made with Student data, it should be fine
		List<Student> data = session.createQuery(query).getResultList();

		return data;
	}

	@Override
	public Student getStudentByEmail(String email) {

		try {
//			String query = "SELECT a FROM student a WHERE a.email = '" + email + "'"; <- I tried 
//			using this for a good hour to no avail as I would always get an error on the format
//			So I resorted to using an enhanced for loop instead to get the data.

			Student result = null;
			List<Student> data = getAllStudents();
			for (Student s : data) {
				if (email.equals(s.getsEmail())) {
					result = new Student(s.getsEmail(), s.getsName(), s.getsPass(), s.getsCourses());
				}
			}
//			V this vestige was also part of the attempts at using the query String from above
//			Student result = new Student(data.get(0).getsEmail(), data.get(0).getsName(), data.get(0).getsPass());

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error occurred when obtaining a result with that email");
		}
		return null;

	}

	@Override
	public boolean validateStudent(String email, String pass) {
		//If the Student object is invalid, we have to return false before attempting to 
		//access any methods with it, or it'll throw an exception.
		if (getStudentByEmail(email) == null) {
			return false;
		}
		if (getStudentByEmail(email).getsPass().equals(pass)) {
			return true;
		}
		return false;
	}

	@Override
	public void registerStudentToCourse(String email, int cid) {
		Student student = getStudentByEmail(email);
		// We need CourseService so we can access all the courses
		CourseService cs = new CourseService();
		// This is to check if the person has already enrolled via the next statement
		boolean enrolled = false;

		// This is supposed to check if the student's currently enrolled classes are
		// zero, so
		// in the case that it is, we don't call any illegal methods from a null class.
		if (getStudentCourses(email) == null) {
			// This enhanced for loop checks if the course ID exists in the DB at all
			for (Course c : cs.getAllCourses()) {
				if (cid == c.getcId()) {
					student.addCourse(c);
					// Using merge here because we already have the primary key and are just
					// modifying data
					session.merge(student);
					System.out.println("Course Successfully Added.");
				}
			} // If the above condition fails, we then check if the course exists in our
			//Student's course List already
		} else {
			int counter = 0;
			boolean bool = false;
			//We make a new List that contains the courses so we don't have to call into 
			//the DB every time to check its elements
			List<Course> temp = getStudentCourses(email);
			
			//This while loops checks if it exists at all in the student Courses List.
			//It ends either when it finds the course, or when it gets through the whole list.
			while (!bool && counter < temp.size()) {
				if (cid == temp.get(counter).getcId()) {
					System.out.println("This Student is already enrolled in that Course.");
					enrolled = true;
					bool = true;
					
				}
				counter++;
			}
			
			//We then use the same methods as above to check if the Course exists in our
			//Existing All Courses List.
			counter = 0;
			bool = false;
			temp = cs.getAllCourses();
			if (!enrolled) {
				while (!bool && counter < temp.size()) {
					if (cid == temp.get(counter).getcId()) {
						student.addCourse(cs.getAllCourses().get(counter));
						session.merge(student);
						System.out.println("Course Successfully Added.");
						bool = true;
					}
					counter++;
				}
			}
		}

		//Gotta Remember to commit to the DB and Close the session!
		t.commit();
		cs.close();

	}

	@Override
	public List<Course> getStudentCourses(String email) {
		Student student = getStudentByEmail(email);
		//If the Student Object made by getStudentByEmail is invalid, it'll be null.
		//If the Student Object is valid but has no courses, it'll be null.
		if (student == null || student.getsCourses().isEmpty()) {
			return null;
		}
		//Only occurs if the above two conditions fail
		return student.getsCourses();
	}

	//Make sure to close your connections and sessions!
	public void close() {
		session.close();
		factory.close();
	}

}
