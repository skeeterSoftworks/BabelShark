package com.skeeterspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.Grade;
import models.Payment;
import models.Student;
import models.User;
import repositories.StudentRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Controller
public class SharkController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@ModelAttribute("studentsList")
	public List<Student> getStudents(){
		Iterable<Student> iterable = studentRepository.findAll();
		List<Student> array = StreamSupport
		    .stream(iterable.spliterator(), false)
		    .collect(Collectors.toList());
		return array;
	}
	
	@GetMapping("/")
	public String home(Model model){
		
		return "home";

	}
	
	@GetMapping("/students")
public String showStudents(Model model){
		model.addAttribute("student", new Student());
		return "students";
	}
	
	@PostMapping("/newstudent")
	public String newStudent(@ModelAttribute("student")Student student){
		
		studentRepository.save(student);
		
		return "redirect:students";
	}
	
	@GetMapping("/login")
	public String loginpage(Model model){
		User user = new User();
		model.addAttribute("user", user);
			return "login";
		}
	
	@PostMapping("/signin")
	public String signin(Model model){
		
		return "signin";
	}
	
	@GetMapping("/grades")
	public String showGrades(@RequestParam("studentId")int id, Model model){
		
		Optional<Student> stuOpt = studentRepository.findById(id);
		
		Student stu = stuOpt.get();
		model.addAttribute("student", stu);
		model.addAttribute("grade", new Grade());
		
		return "grades";
	}
	
	@PostMapping("/addgrade")
	public String addGrade(@ModelAttribute("grade")Grade grade, @RequestParam("studentid")int id){
		
		Optional<Student> stuOpt = studentRepository.findById(id);
		
		Student stu = stuOpt.get();
		grade.setDate(new Date(System.currentTimeMillis()));
		
		Set<Grade> studGrades = stu.getGrades();
		studGrades.add(grade);
		stu.setGrades(studGrades);
		
		studentRepository.save(stu);
		
		//Da se nekako ugnezdi request param u model koji se vraca sa return vrednoscu?
		//dodaju se ocene; nema timestamp, i ne moze se lepo redirectovati u grades jer fali studentid param
		return "redirect:/students";
		
		
	}
	
	@GetMapping("/payments")
	public String showPayments(@RequestParam("studentId")int id, Model model){
		
		Optional<Student> stuOpt = studentRepository.findById(id);
		
		Student stu = stuOpt.get();
		model.addAttribute("student", stu);
		model.addAttribute("payment", new Payment());
		
		int sum = 0;
		Set<Payment> payments = stu.getPayments();
		for (Payment p: payments){
			
			sum+=p.getQuantity();
			
		}
		model.addAttribute("paidfees", sum);
		
		return "payments";
		
	}
	
	@PostMapping("/addpayment")
	public String addPayment(@ModelAttribute("payment")Payment payment, @RequestParam("studentid")int id){
		
		Optional<Student> stuOpt = studentRepository.findById(id);
		Student stu = stuOpt.get();
		payment.setDate(new Date(System.currentTimeMillis()));
		
		stu.addPayment(payment);
		studentRepository.save(stu);
		
		return "redirect:/students";
		
		
	}

}
