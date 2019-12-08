package com.ashsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ashsoft.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public String add(String sid, String sname, String saddr) {
		String status="";
		Student student=search(sid);
		if(student==null) //inserting record if it is not existed
		{
			int rowCount=jdbcTemplate.update("insert into student values('"+sid+"','"+sname+"','"+saddr+"')");
			if(rowCount==1)
			{
				status="success";
			}
			else
			{
				status="failure";
			}
		}
		else //returning existed status, if record already exists with sid
		{
			status="existed";
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student std=null;
		List<Student> stdList= jdbcTemplate.query("select * from student where SID ='"+sid+"'", (rs,i)->{
			Student s= new Student();
			s.setSid(rs.getString("SID"));
			s.setSname(rs.getString("SNAME"));
			s.setSaddr(rs.getString("SADDR"));
			return s;
		});
		if(stdList.isEmpty()==true) //if record doesn't exist
		{
			std=null;
		}
		else
		{
			std=stdList.get(0);  //getting the existed record
		}
		return std;
	}

	@Override
	public String update(String sid, String sname, String saddr) {
		String status="";
		int rowCount=jdbcTemplate.update("update student set SNAME='"+sname+"',SADDR='"+saddr+"' where SID ='"+sid+"'");
		if(rowCount==1)
		{
			status="success";
		}
		else
		{
			status="failure";
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		String status="";
		Student student=search(sid);
		if(student==null)
		{
			status="notexisted";
		}
		else
		{
			int rowCount=jdbcTemplate.update("delete from student where SID='"+sid+"'");
			if(rowCount==1)
			{
				status="success";
			}
			else
			{
				status="failure";
			}
		}
		return status;
	}

}
