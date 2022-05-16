package jpa.entitymodels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

	@Column(name = "email", length = 50)
	@Id
	private String sEmail;

	@Column(name = "name", nullable = false, length = 50)
	private String sName;
	@Column(name = "password", nullable = false, length = 50)
	private String sPass;

	@OneToMany(targetEntity = Course.class, cascade = CascadeType.ALL)
	private List<Course> sCourses;

	public Student() {
		this.sEmail = "";
		this.sName = "";
		this.sPass = "";
		this.sCourses = new ArrayList<Course>();

	}

	public Student(String email, String name, String password, List<Course> courses) {
		this.sEmail = email;
		this.sName = name;
		this.sPass = password;
		this.sCourses = courses;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String email) {
		this.sEmail = email;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String name) {
		this.sName = name;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String password) {
		this.sPass = password;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}

	public void addCourse(Course course) {
		this.sCourses.add(course);
	}

}
