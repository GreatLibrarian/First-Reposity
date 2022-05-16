package unitTesting;


import org.junit.jupiter.api.Test;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

//These tests only work when the default Info is put into the database from SMSRunner.
//Make sure to do that before starting these tests!
public class UnitTest {
	static StudentService ss;
	static CourseService cs;
	
	//This creates our connections to the DB
	@BeforeAll
	public static void init() {
		ss = new StudentService();
		cs = new CourseService();
	}
	
	//This test checks if the names are properly returned when calling a List of
	//Student Objects in the DB. Could've also checks the other elements too but I ran out of time.
	@Test
	public void testGetAllStudents() {
		System.out.println("Testing getAllStudents()");

		String[] expected = new String[10];
		expected[0] = "Alexandra Iannitti";
		expected[1] = "Cahra Jaulme";
		expected[2] = "Clem Startin";
		expected[3] = "Harcourt Guerre";
		expected[4] = "Hazel Luckham";
		expected[5] = "Holmes Taffley";
		expected[6] = "Laryssa Jiroudek";
		expected[7] = "Quillan Llorens";
		expected[8] = "Sonnnie Bowden";
		expected[9] = "Thornie Attwool";

		String[] actual = new String[10];

		int counter = 0;
		for (Student s : ss.getAllStudents()) {
			actual[counter] = s.getsName();
			counter++;
		}
		counter = 0;
		
		for(int x = 0; x < 10; x++) {
			assertEquals(expected[x], actual[x]);
		}
	}
	
	//This checks if we get the proper name when we search for an individual Student Object.
	//It also checks if it's properly null when a dummy email is inserted.
	@Test
	public void testGetStudentByEmail() {
		System.out.println("Testing getStudentByEmail()");
		
		String expected = "Hazel Luckham";
		String email = "hluckham0@google.ru";
		
		String actual = ss.getStudentByEmail(email).getsName();
		assertEquals(expected, actual);
		
		expected = null;
		if(ss.getStudentByEmail("") != null) {
			actual = ss.getStudentByEmail("").getsName();
		} else {
			actual = null;
		}
		
		assertEquals(expected, actual);
	}
	
	//This checks both if the proper information correctly valiidates the student, and
	//If the same correct but with another student's password invalidates the method.
	@Test
	public void testValidateStudent() {
		System.out.println("Testing validateStudent()");
		
		boolean expected = true;
		String email = "sbowden1@yellowbook.com";
		String pass = "SJc4aWSU";
		boolean actual = ss.validateStudent(email, pass);
		
		assertEquals(expected, actual);
		
		expected = false;
		email = "sbowden1@yellowbook.com";
		pass = "XYHzJ1S";
		actual = ss.validateStudent(email, pass);
		
		assertEquals(expected, actual);
	}
	
	//This behaves similarly to the getAllStudents() test method
	@Test
	public void testGetAllCourses() {
		System.out.println("Testing getAllCourses()");
		
		String[] expected = new String[10];
		expected[0] = "English";
		expected[1] = "Mathematics";
		expected[2] = "Anatomy";
		expected[3] = "Organic Chemistry";
		expected[4] = "Physics";
		expected[5] = "Digital Logic";
		expected[6] = "Object Oriented Programming";
		expected[7] = "Data Structures";
		expected[8] = "Politics";
		expected[9] = "Art";

		String[] actual = new String[10];

		int counter = 0;
		for (Course s : cs.getAllCourses()) {
			actual[counter] = s.getcName();
			counter++;
		}
		counter = 0;
		
		for(int x = 0; x < 10; x++) {
			assertEquals(expected[x], actual[x]);
		}
	}
	
	//This tests if the getStudentCourses() method can handle dummy information, and also
	//If it provides the correct result with actual information.
	@Test
	public void testGetStudentCourses() {
		System.out.println("Testing getStudentCourses()");
		
		List<Course> expected =  null;
		List<Course> actual = ss.getStudentCourses("");
		
		assertEquals(expected, actual);
		
		String expected2 = "Digital Logic";
		ss.registerStudentToCourse("ljiroudek8@sitemeter.com", 6);
		String actual2 = ss.getStudentCourses("ljiroudek8@sitemeter.com").get(0).getcName();
		
		assertEquals(expected2, actual2);
	}
	
	//Remember to close your connections and sessions!
	@AfterAll
	public static void close() {
		ss.close();
		cs.close();
	}
	
}
