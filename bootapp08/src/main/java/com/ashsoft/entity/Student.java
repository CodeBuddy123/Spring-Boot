package com.ashsoft.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

public class Student implements Persistable<String> {
	private String sname;
	@Id
	private String sid;
	private String saddr;
	
	public static boolean isNew= false;
	@Override
	public String getId() {
		return sid;
	}
	@Override
	public boolean isNew() {
		
		return isNew;   //this method is called by save method
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	
}
