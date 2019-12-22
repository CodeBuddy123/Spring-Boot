package com.ashsoft.dao;

import org.springframework.data.repository.CrudRepository;

import com.ashsoft.entity.Student;

public interface StudentDao extends CrudRepository<Student,String> {
  
	
}
