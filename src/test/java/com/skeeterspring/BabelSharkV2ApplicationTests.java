package com.skeeterspring;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Optional;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import models.Grade;
import models.Payment;
import models.Student;
import repositories.StudentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BabelSharkV2ApplicationTests {
	
	@Autowired
	StudentRepository studentRepository;

	@Test
	public void contextLoads() {
	}
	
	//@Test
	public void saveStudent(){
		
		Student stu = new Student();
		
		stu.setLanguage("Russian");
		stu.setLevel("A1");
		stu.setName("Mikoyan Guryevich");
		Grade grade = new Grade();
		grade.setDetails("test iz reci");
		grade.setGrade("A");
		grade.setLanguage("Italian");
	
		
		studentRepository.save(stu);

		
	}
	
	//@Test
	public void makePayment(){
		
		Student stu = new Student();
		
		stu.setLanguage("Russian");
		stu.setLevel("A1");
		stu.setName("Mika Guryevich");
		
		Payment pay = new Payment();
		pay.setDate(new Date(System.currentTimeMillis()));
		pay.setQuantity(3500);
		
		stu.addPayment(pay);
		
		studentRepository.save(stu);
		
		Student guryevich = studentRepository.findByName("Mika Guryevich");
		assert guryevich.getLanguage().equals(stu.getLanguage());
		
		Set<Payment> gurPay =  guryevich.getPayments();
		assertTrue(  gurPay.size()>0);
	}
	//@Test
	public void deleteStudent(){
		
		for (int i=138; i<=142;i++){
		studentRepository.deleteById(i);
		}
		
		studentRepository.deleteById(120);
		
	}
	
	//@Test
	public void clearGrades(){
		
		
		
		Optional<Student> stu = studentRepository.findById(102);
		Student student = stu.get();
		
		for (Grade g : student.getGrades()){
			
			studentRepository.deleteById(g.getId());
		}
		
		assertTrue(student.getGrades().size()==0);
		studentRepository.save(student);
	}

}

