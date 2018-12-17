package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="grades")
public class Grade {
	
	@Id
	@Column(name="grade_id")
	private Integer id;
	
	@Column
	private String language;
	
	@Column
	private String grade;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column
	private String details;

	@ManyToMany(mappedBy="grades")
	Set<Student> students = new HashSet<>();

	
	public Grade(){}
	
	
	
	
	public Grade(Integer id, String language, String grade, Date date, String details, Set<Student> students) {
		super();
		this.id = id;
		this.language = language;
		this.grade = grade;
		this.date = date;
		this.details = details;
		this.students = students;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
