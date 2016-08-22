package com.coureapp2.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // if we declare a class as an "entity" means it represents a class in
		// the database
@Table(name = "course_table")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id // represents the primary key in the database table
	@GeneratedValue(strategy = GenerationType.AUTO) // auto increments the
													// primary key value
	@NotEmpty
	@Size(min=4, max=8, message="enter valid course id") //JPA validation
	private long courseId;
	
	@Column
	@NotEmpty
	private String courseName;
	@Column
	private String courseDescription;
	@Column
	private LocalTime courseCreatedTime;
	@Column
	private LocalTime courseUpdatedTime;
	@Column
	private String userName;
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Column
	private String author;

	@Column
	@Enumerated(EnumType.STRING)
	private SkilLevel courseSkilLevel;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinTable(name = "course_user", joinColumns = @JoinColumn(name = "courseId", referencedColumnName = "courseId"), inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"))
	private List<User> registeredUsers = new ArrayList<>();

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Topic> topics = new ArrayList<>();
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (courseId ^ (courseId >>> 32));
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
		if (courseId != other.courseId)
			return false;
		return true;
	}

	public Course(){
		
	}
	public Course(long courseId, String courseName, String courseDescription, LocalTime courseCreatedTime,
			LocalTime courseUpdatedTime, String userName, String author, SkilLevel courseSkilLevel,
			List<User> registeredUsers, List<Topic> topics) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseCreatedTime = courseCreatedTime;
		this.courseUpdatedTime = courseUpdatedTime;
		this.userName = userName;
		this.author = author;
		this.courseSkilLevel = courseSkilLevel;
		this.registeredUsers = registeredUsers;
		this.topics = topics;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
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

	public LocalTime getCourseCreatedTime() {
		return courseCreatedTime;
	}

	public void setCourseCreatedTime(LocalTime courseCreatedTime) {
		this.courseCreatedTime = courseCreatedTime;
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

	public SkilLevel getCourseSkilLevel() {
		return courseSkilLevel;
	}

	public void setCourseSkilLevel(SkilLevel courseSkilLevel) {
		this.courseSkilLevel = courseSkilLevel;
	}

	public List<User> getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(List<User> registeredUsers) {
		this.registeredUsers = registeredUsers;
	}



	
}
