package com.skeeterspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import models.Grade;
import models.Payment;
import models.Student;
import models.StudentReport;
import models.User;
import repositories.StudentRepository;
import repositories.WisdomRepository;

import com.skeeterspring.UserService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:8888", maxAge = 3600)
@Controller
public class SharkController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private UserService userService;
	
	@Autowired
	WisdomRepository wisdomRepository;
	
	@Autowired
	ReportService reportService;
	


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

		return "index.html";

	}


	@PostMapping("/newstudent")
	public String newStudent(@Valid Student student, BindingResult result){

		if (result.hasErrors()){
			return "students";
		}

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
		//ne moze se lepo redirectovati u grades jer fali studentid param
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


	@GetMapping(value="/registration")
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	

	@PostMapping(value = "/registration")
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
			.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUserAs(user,"admin");
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");

		}
		return modelAndView;

	}
	@GetMapping(value="/admin/cpanel")
	public String adminPanel(Model model){

		List<User> users = userService.findAllUsers();
		model.addAttribute("usersList", users);

		return "Cpanel";

	}
	
	@GetMapping("/wisdom")
	@ResponseBody
	public String getNewWisdom(){
		return wisdomRepository.getRandomWisdom().getWisdom();
	}
	

	@GetMapping("/print_report")
	@ResponseBody
	public String printReport(@RequestParam("studentid")int id){
	
		Optional<Student> stuOpt = studentRepository.findById(id);
		Student stu = stuOpt.get();
		
		return Base64.getEncoder().encodeToString(reportService.generateReport(stu));
	}
	
	@GetMapping("/students")
	@ResponseBody
	public List<Student> showStudents(){
		Iterable<Student> iterable = studentRepository.findAll();
		List<Student> array = StreamSupport
				.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
		return array;
	}
}
