package com.skeeterspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import models.Student;
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
		/*Student stu = new Student();
		stu.setName("Johan");
		stu.setLevel("A1");
		stu.setLanguage("Spanish");
		List<Student> lista = new ArrayList<Student>();
		lista.add(stu);*/
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
	

}
