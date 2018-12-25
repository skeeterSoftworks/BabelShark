package com.skeeterspring;

import java.util.Date;
import java.util.HashSet;
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
	
	@Test
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
	
	@Test
	public void makePayment(){
		
		Student stu = new Student();
		stu.setLanguage("Russian");
		stu.setLevel("A1");
		stu.setName("Mik Guryevich");
		Payment pay = new Payment();
		pay.setDate(new Date(System.currentTimeMillis()));
		pay.setQuantity(3500);
		Set<Payment>pays = new HashSet<>();
		pays.add(pay);
		stu.setPayments(pays);
		
		studentRepository.save(stu);
		
		Student guryevich = studentRepository.findByName("Mik Guryevich");
		assert guryevich.getLanguage().equals(stu.getLanguage());
	}

}

