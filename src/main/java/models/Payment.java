package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="payments")
public class Payment {
	
	@Id
	@Column(name="payment_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Temporal(TemporalType.DATE)
	@Column(name="payment_date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	public Payment(){}

	

	public Payment(int id, int quantity, Date date, Student student) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.date = date;
		this.student = student;
	}



	public int getId() {
		return id;
	}
	
	
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
