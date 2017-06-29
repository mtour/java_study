package com.mtour.rest.resources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	int age;
	String userid;
	String username;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
