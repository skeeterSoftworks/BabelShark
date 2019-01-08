package models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
@Table (name="students")
public class Student {
		
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer id;
	
	@Column(name="student_name")
	@Size(min=2, max=20, message="Mora ime izmedju 2 i 20 slova")
	@NotEmpty
	private String name;
	
	@Column(name="student_level")
	@Size(min=1, max=2, message="Ne moze tako, mora neki nivo da se upise")
	@NotEmpty
	private String level;
	
	@NotEmpty
	@Size(min=2, max=20, message="Ne valja, jezik mora da ima izmedju 2 i 20 slova")
	private String language;
	
	@ManyToMany(cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name="student_grade", joinColumns={@JoinColumn(name="student_id")},
	inverseJoinColumns={@JoinColumn(name="grade_id")})
	private Set<Grade> grades = new HashSet<>();
	
	@OneToMany(mappedBy="student",cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	private Set<Payment>payments= new HashSet<>();
	
	public Student(){}

	public Student(Integer id, String name, String level, String language, Set<Grade> grades, Set<Payment> payments) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.language = language;
		this.grades = grades;
		this.payments = payments;
	}

	

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	
	public void clearGrades(){
		grades.clear();
	}
	
	public void clearPayments(){
		payments.clear();
	}
	public void addPayment(Payment payment){
		
		payments.add(payment);
		payment.setStudent(this);
		
	}
	
	public void removePayment(Payment payment){
		
		payments.remove(payment);
		payment.setStudent(null);
	}

	public Set<Grade> getGrades() {
		return grades;
	}



	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
