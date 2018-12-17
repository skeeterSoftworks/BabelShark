package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
@Table (name="students")
public class Student {
	
	@Id 
	@Column(name="student_id")
	private Integer id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_level")
	private String level;
	
	private String language;
	
	@ManyToMany(cascade={CascadeType.ALL})
	@JoinTable(name="student_grade", joinColumns={@JoinColumn(name="student_id")},
	inverseJoinColumns={@JoinColumn(name="grade_id")})
	Set<Grade> grades = new HashSet<>();
	
	
	public Student(){}

	

	public Student(Integer id, String name, String level, String language, Set<Grade> grades) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.language = language;
		this.grades = grades;
	}



	public Set<Grade> getGrades() {
		return grades;
	}



	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	

}
