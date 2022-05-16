package jpa.mainrunner;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.logging.*;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	//Creating variables to be used by all methods in this class
	static StudentService ss;
	static CourseService cs;
	Student student;
	static Scanner scan;

	public static void main(String[] args) {
		
//		I tried to find a way to get rid of all the debug text that hibernate puts into the
//		console, but couldn't find a good way to do it. Sorry for the mess in console!
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
		
		scan = new Scanner(System.in);
		//Used to call our other methods of the class into the main method
		SMSRunner sms = new SMSRunner();
		
		//This is used to input the default data that is required for the database.
		//Press Y to put all the required data in the first run, and N for every other instance.
		System.out.println("Input default data into the database? Y/N");
		switch(scan.next()) {
		case "Y": 
			//Method that inputs all the data given from the text files
			sms.insertData();
			break;
		case "N":
			break;
		default:
			System.out.println("Invalid input. Defaulting to not inputting data into DB.");
			break;
		}
		
		
		ss = new StudentService();
		cs = new CourseService();

		//This method is the meat of this class, and all other classes are called inside of it.
		sms.display();
		//After the display method is done, we close out all the other classes being used.
		ss.close();
		cs.close();
		scan.close();
	}

	public void display() {
		

		System.out.println("Are you a(n)");
		System.out.println("1. Student" + '\n' + "2. quit");
		System.out.println("Please, enter 1 or 2");

		//I use scan.next() instead of scan.nextInt() because scan.next() can handle people inputting non-Integers
		switch (scan.next()) {
		case "1":
			System.out.println("Enter Your Email:");
			String email = scan.next();
			System.out.println("Enter Your Password:");
			String pass = scan.next();

			if (ss.validateStudent(email, pass)) {

				student = ss.getStudentByEmail(email);

				if (ss.getStudentCourses(email) == null) {
					System.out.println("You have no registered courses.");
				} else {
					displayStudentCourses(email);
				}

				registerDisplay(email); // void Method used to display the registration menu

			} else {
				System.out.println("The Username and/or Password is incorrect.");
				break;
			}
			break;
		case "2":
			System.out.println("You have successfully quit the SMS.");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}

	}

	// This method is used to add a course to a student
	public void displayRegisterToClass(String email) {

		System.out.println("Which Course? (Please Input Course ID)");

		// If someone puts in something other than an int, this try will catch it.
		try {
			int id = scan.nextInt();
			ss.registerStudentToCourse(email, id);

			// If the course ID isn't in the DB, the user is notified and is sent back to
			// the register menu
			if (id > cs.getAllCourses().size()) {
				System.out.println("This Course ID doesn't exist in the system.");
				// This sends the user back to the register menu
				registerDisplay(email);
			} else {
				// This happens when a user successfully adds a course
				displayStudentCourses(email);
				System.out.println("Logging out of the system.");
			}

		} catch (Exception e) {
			// If anything other than an int is inputted, this occurs
			System.out.println("An error occurred when inputting Course ID.");
			e.printStackTrace();
			registerDisplay(email);
		}
	}

	// Method used as the register menu
	public void registerDisplay(String email) {
		System.out.println("1. Register to Class" + '\n' + "2. Logout");

		switch (scan.next()) {
		case "1":
			displayAllCourses();
			// This method will be used for the actual registering to a course
			displayRegisterToClass(email);
			break;
		// Logs the user out
		case "2":
			System.out.println("You have successfully logged out.");
			break;
		// If an illegal input is put in, this will put the user back to the register
		// menu
		default:
			System.out.println("Invalid Input");
			registerDisplay(email);
		}
	}

	// Displays courses the student is registered in already
	public void displayStudentCourses(String email) {
		if (ss.getStudentCourses(email) != null) {
			System.out.println("My Classes:");
			System.out.printf("%-3s", "#");
			System.out.printf("%-20s", "COURSE NAME");
			System.out.printf("%-20s%n", "INSTRUCTOR NAME");

			for (Course c : ss.getStudentCourses(email)) {

				System.out.printf("%-3d", c.getcId());
				System.out.printf("%-20s", c.getcName());
				System.out.printf("%-20s%n", c.getcInstructor());

			}
		}

	}
	//Displays all Courses in the course table
	public void displayAllCourses() {
		System.out.println("All Courses:");
		System.out.printf("%-3s", "ID");
		System.out.printf("%-20s", "COURSE NAME");
		System.out.printf("%-20s%n", "INSTRUCTOR NAME");

		for (Course c : cs.getAllCourses()) {
			System.out.printf("%-3d", c.getcId());
			System.out.printf("%-20s", c.getcName());
			System.out.printf("%-20s%n", c.getcInstructor());
		}
	}

	// Used to insert the required data for the sba
	public void insertData() {

//		
//		Connects method to the database sms
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

//		Creation of all the student entities to be entered into DB
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		Student s5 = new Student();
		Student s6 = new Student();
		Student s7 = new Student();
		Student s8 = new Student();
		Student s9 = new Student();
		Student s10 = new Student();

		s1.setsEmail("hluckham0@google.ru");
		s1.setsName("Hazel Luckham");
		s1.setsPass("X1uZcoIh0dj");

		s2.setsEmail("sbowden1@yellowbook.com");
		s2.setsName("Sonnnie Bowden");
		s2.setsPass("SJc4aWSU");

		s3.setsEmail("qllorens2@howstuffworks.com");
		s3.setsName("Quillan Llorens");
		s3.setsPass("W6rJuxd");

		s4.setsEmail("cstartin3@flickr.com");
		s4.setsName("Clem Startin");
		s4.setsPass("XYHzJ1S");

		s5.setsEmail("tattwool4@biglobe.ne.jp");
		s5.setsName("Thornie Attwool");
		s5.setsPass("Hjt0SoVmuBz");

		s6.setsEmail("hguerre5@deviantart.com");
		s6.setsName("Harcourt Guerre");
		s6.setsPass("OzcxzD1PGs");

		s7.setsEmail("htaffley6@columbia.edu");
		s7.setsName("Holmes Taffley");
		s7.setsPass("xowtOQ");

		s8.setsEmail("aiannitti7@is.gd");
		s8.setsName("Alexandra Iannitti");
		s8.setsPass("TWP4hf5j");

		s9.setsEmail("ljiroudek8@sitemeter.com");
		s9.setsName("Laryssa Jiroudek");
		s9.setsPass("bXRoLUP");

		s10.setsEmail("cjaulme9@bing.com");
		s10.setsName("Cahra Jaulme");
		s10.setsPass("FnVklVgC6r6");

		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);
		session.save(s7);
		session.save(s8);
		session.save(s9);
		session.save(s10);

//		Creation of all the course entities to be added to DB

		Course c1 = new Course();
		Course c2 = new Course();
		Course c3 = new Course();
		Course c4 = new Course();
		Course c5 = new Course();
		Course c6 = new Course();
		Course c7 = new Course();
		Course c8 = new Course();
		Course c9 = new Course();
		Course c10 = new Course();

		c1.setcId(1);
		c1.setcName("English");
		c1.setcInstructor("Anderea Scamaden");

		c2.setcId(2);
		c2.setcName("Mathematics");
		c2.setcInstructor("Eustace Niemetz");

		c3.setcId(3);
		c3.setcName("Anatomy");
		c3.setcInstructor("Reynolds Pastor");

		c4.setcId(4);
		c4.setcName("Organic Chemistry");
		c4.setcInstructor("Odessa Belcher");

		c5.setcId(5);
		c5.setcName("Physics");
		c5.setcInstructor("Dani Swallow");

		c6.setcId(6);
		c6.setcName("Digital Logic");
		c6.setcInstructor("Glenden Reilingen");

		c7.setcId(7);
		c7.setcName("Object Oriented Programming");
		c7.setcInstructor("Giselle Ardy");

		c8.setcId(8);
		c8.setcName("Data Structures");
		c8.setcInstructor("Carolan Stoller");

		c9.setcId(9);
		c9.setcName("Politics");
		c9.setcInstructor("Carmita De Maine");

		c10.setcId(10);
		c10.setcName("Art");
		c10.setcInstructor("Kingsly Doxsey");

		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		session.save(c5);
		session.save(c6);
		session.save(c7);
		session.save(c8);
		session.save(c9);
		session.save(c10);

		t.commit();
		session.close();
		factory.close();
	}

}
