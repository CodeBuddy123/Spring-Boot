package com.ashsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ashsoft.entity.Student;
import com.ashsoft.service.StudentService;

@Controller
public class StudentController {
   @Autowired
   StudentService studentService;
   
   @RequestMapping("/home")
   public String getHomePage()
   {
	   return "home";
   }
   @RequestMapping(value = "/addform", method =RequestMethod.GET )
   public String getAddForm()
   {
	   return "addform";
   }
   @RequestMapping(value = "/add",method = RequestMethod.POST)
   public String add(@RequestParam String sid,@RequestParam String sname,@RequestParam String saddr,ModelMap map)
   {
	   String status="";
	   status=studentService.addStudent(sid, sname, saddr);
	   map.addAttribute("studentOperation","Insertion");
	   return status;
   }
   @RequestMapping(value = "/searchform", method = RequestMethod.GET)
   public String getSearchForm()
   {
	   return "searchform";
   }
   
   @RequestMapping(value = "/search", method = RequestMethod.POST)
   public ModelAndView search(Student student,@RequestParam String sid)
   {
	student=studentService.searchStudent(sid);
	if(student==null)
	{
		return new ModelAndView("notexisted");
	}
	else
	{
		return new ModelAndView("studentdetails","student",student);
	}
   }
   @RequestMapping(value = "/deleteform", method = RequestMethod.GET)
   public String getDeleteForm()
   {
	   return "deleteform";
   }
   @RequestMapping(value = "/delete",method = RequestMethod.POST)
   public String delete(@RequestParam String sid,ModelMap map)
   {
	   String status="";
	   status=studentService.deleteStudent(sid);
	   map.addAttribute("studentOperation","Deletion");
	   return status;
   }
   @RequestMapping(value = "/updateform", method = RequestMethod.GET)
   public String getUpdateForm()
   {
	   return "updateform";
   }
   @RequestMapping(value = "/editform", method = RequestMethod.POST)
   public String getEditForm(@RequestParam String sid,ModelMap map)
   {
	   Student student=studentService.searchStudent(sid);
	   if(student==null)
	   {
		   return "notexisted";
	   }
	   else
	   {
		   map.addAttribute("std",student);
		   return "editform";
	   }
   }
   @RequestMapping(value = "/update",method = RequestMethod.POST)
   public String update(@RequestParam String sid,@RequestParam String sname,@RequestParam String saddr,ModelMap map)
   {
	   String status="";
	   status=studentService.updateStudent(sid, sname, saddr);
	   map.addAttribute("studentOperation","Updation");
	   return status;
   }
}
