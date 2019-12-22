package com.ashsoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashsoft.dao.StudentDao;
import com.ashsoft.entity.Student;

@Service
@Transactional //provides Transactional Support
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	@Override
	public String addStudent(String sid, String sname, String saddr) {
		String status="";
		Student s=new Student();
		s.setSaddr(saddr);
		s.setSid(sid);    //setting the  provided data into Student object
		s.setSname(sname);
		try {
			Student.isNew=true;
			Student std=studentDao.save(s); //inserting the record
			if(std.getSid().equals(sid))  
			{
				status="success";
			}
			else
			{
				status="failure";
			}
	   
		} catch (Exception e) {
			status="failure";        //if any exception is raised
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		Student std=null;
		try {
			Optional<Student>opt=studentDao.findById(sid); //searching
			std=opt.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public String updateStudent(String sid, String sname, String saddr) {
		String status="";
		Student s= new Student();
		s.setSid(sid);
		s.setSname(sname);
		s.setSaddr(saddr);
		try {
			Student.isNew=false;
			Student std=studentDao.save(s); //updating a record
			if(std.getSid().equals(sid))
			{
				status="success";
			}
			else
			{
				status="failure";
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String deleteStudent(String sid) {
		String status="";
		try {
			studentDao.deleteById(sid); //deleting a record
			status="success";
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}		
		return status;
	}
   
}
