package jpa.entitymodels;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

	@Column(name = "id")
	@Id
	private int cId;

	@Column(name = "name", nullable = false, length = 50)
	private String cName;
	@Column(name = "instructor", nullable = false, length = 50)
	private String cInstructor;

	public Course() {
		this.cId = 0;
		this.cName = "";
		this.cInstructor = "";
	}

	public Course(int id, String name, String instructor) {
		this.cId = id;
		this.cName = name;
		this.cInstructor = instructor;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int id) {
		this.cId = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String name) {
		this.cName = name;
	}

	public String getcInstructor() {
		return cInstructor;
	}

	public void setcInstructor(String instructor) {
		this.cInstructor = instructor;
	}

}
