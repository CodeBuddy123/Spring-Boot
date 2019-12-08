package com.ashsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashsoft.dao.StudentDao;
import com.ashsoft.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	@Override
	public String addStudent(String sid, String sname, String saddr) {	
		String status= studentDao.add(sid, sname, saddr);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		Student std=studentDao.search(sid);
		return std;
	}

	@Override
	public String updateStudent(String sid, String sname, String saddr) {
		String status=studentDao.update(sid, sname, saddr);
		return status;
	}

	@Override
	public String deleteStudent(String sid) {
		String status=studentDao.delete(sid);
		return status;
	}
   
}
