package com.udemy.spring.thymeleafdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.spring.thymeleafdemo.models.Student;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String greetHello() {
		return "hello";
	}

	@RequestMapping("/data")
	public ModelAndView sendData() {
		ModelAndView modelAndView = new ModelAndView("data");
		modelAndView.addObject("message", "This is my message");
		return modelAndView;
	}

	@RequestMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView modelAndView = new ModelAndView("student");
		Student student = new Student();
		student.setId(1);
		student.setName("John");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	
	@RequestMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView modelAndView = new ModelAndView("studentlist");
		Student student = new Student();
		student.setId(1);
		student.setName("John");
		
		Student student1 = new Student();
		student1.setId(2);
		student1.setName("Ram");
		
		
		Student student2 = new Student();
		student2.setId(3);
		student2.setName("Alex");
		
		List<Student> students = Arrays.asList(student,student1,student2);
		modelAndView.addObject("students", students);
		return modelAndView;
	}
	
	@RequestMapping("/studentForm")
	public ModelAndView displayStudentForm() {
		ModelAndView modelAndView = new ModelAndView("studentForm");
		Student student = new Student();
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	
	public ModelAndView saveStudent(@ModelAttribute Student student) {	
		ModelAndView modelAndView = new ModelAndView("result");
		modelAndView.addObject("student", student);
		return modelAndView;
	}
}
