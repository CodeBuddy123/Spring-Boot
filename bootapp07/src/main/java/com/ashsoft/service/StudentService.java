package com.ashsoft.service;

import com.ashsoft.entity.Student;

public interface StudentService {
	public String addStudent(String sid,String sname,String saddr);
	public Student searchStudent(String sid);
	public String updateStudent(String sid,String sname,String saddr);
	public String deleteStudent(String sid);
}
