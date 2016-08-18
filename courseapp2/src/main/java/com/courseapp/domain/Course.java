package com.courseapp.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

@Table(name="Course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String courseId;
	private String courseName;
	private String courseDescription;
	private LocalTime courseCreateTime;
	private LocalTime courseUpdatedTime;
	private String userName;
	private String author;

	private List<User> registeredUsers = new ArrayList<>();
	
	private List<Topic> topics= new ArrayList<>();
	
	private SkillLevel courseSkillLevel;

	
	public Course(){
		
	}
	
	public Course(long id, String courseId, String courseName, String courseDescription, LocalTime courseCreateTime,
			LocalTime courseUpdatedTime, String userName, String author, List<User> registeredUsers, List<Topic> topics,
			SkillLevel courseSkillLevel) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseCreateTime = courseCreateTime;
		this.courseUpdatedTime = courseUpdatedTime;
		this.userName = userName;
		this.author = author;
		this.registeredUsers = registeredUsers;
		this.topics = topics;
		this.courseSkillLevel = courseSkillLevel;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public LocalTime getCourseCreateTime() {
		return courseCreateTime;
	}

	public void setCourseCreateTime(LocalTime courseCreateTime) {
		this.courseCreateTime = courseCreateTime;
	}

	public LocalTime getCourseUpdatedTime() {
		return courseUpdatedTime;
	}

	public void setCourseUpdatedTime(LocalTime courseUpdatedTime) {
		this.courseUpdatedTime = courseUpdatedTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public SkillLevel getCourseSkillLevel() {
		return courseSkillLevel;
	}

	public void setCourseSkillLevel(SkillLevel courseSkillLevel) {
		this.courseSkillLevel = courseSkillLevel;
	}

	public List<User> getUser() {
		return registeredUsers;
	}

	public void setUser(List<User> user) {
		this.registeredUsers = user;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
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
		Course other = (Course) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", courseCreateTime=" + courseCreateTime + ", courseUpdatedTime="
				+ courseUpdatedTime + ", userName=" + userName + ", author=" + author + ", courseSkillLevel="
				+ courseSkillLevel + "]";
	}

	
}
