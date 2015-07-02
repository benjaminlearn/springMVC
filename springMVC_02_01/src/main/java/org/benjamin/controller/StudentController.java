package org.benjamin.controller;

import java.util.ArrayList;
import java.util.List;

import org.benjamin.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

	private static List<Student> studentList=new ArrayList<Student>();
	
	static{
		studentList.add(new Student(1,"����",11));
		studentList.add(new Student(2,"����",12));
		studentList.add(new Student(3,"����",13));
	}
	
	@RequestMapping("/list")
	public ModelAndView list(){
		ModelAndView mav=new ModelAndView();
		mav.addObject("studentList", studentList);
		mav.setViewName("student/list");
		return mav;
	}
	
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false) String id){
		ModelAndView mav=new ModelAndView();
		if(id!=null){
			mav.addObject("student", studentList.get(Integer.parseInt(id)-1));
			mav.setViewName("student/update");
		}else{
			mav.setViewName("student/add");			
		}
		return mav;
	}
}
