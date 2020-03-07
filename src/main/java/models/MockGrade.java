package models;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class MockGrade {
	
	private String language;

	private String grade;

	private Date date;

	private String details;

	Set<Student> students = new HashSet<>();

	
	public MockGrade(){}
	
	
	public MockGrade(String language, String grade, Date date, String details, Set<Student> students) {
		super();
		this.language = language;
		this.grade = grade;
		this.date = date;
		this.details = details;
		this.students = students;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
}
