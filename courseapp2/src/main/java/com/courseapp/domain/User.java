package com.courseapp.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private long userId;
	private String userName;
	private String password;
	private LocalTime userCreatedTime;
	private LocalTime userUpdatedTime;

	private List<Course> course = new ArrayList<>();
	
	public User(){
		
	}
	
	public User(long userId, String userName, String password, LocalTime userCreatedTime, LocalTime userUpdatedTime,
			List<Course> course) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userCreatedTime = userCreatedTime;
		this.userUpdatedTime = userUpdatedTime;
		this.course = course;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalTime getUserCreatedTime() {
		return userCreatedTime;
	}

	public void setUserCreatedTime(LocalTime userCreatedTime) {
		this.userCreatedTime = userCreatedTime;
	}

	public LocalTime getUserUpdatedTime() {
		return userUpdatedTime;
	}

	public void setUserUpdatedTime(LocalTime userUpdatedTime) {
		this.userUpdatedTime = userUpdatedTime;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userCreatedTime="
				+ userCreatedTime + ", userUpdatedTime=" + userUpdatedTime + "]";
	}
	
	
	

}
