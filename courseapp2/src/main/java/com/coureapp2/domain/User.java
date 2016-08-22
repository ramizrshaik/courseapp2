package com.coureapp2.domain;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.courseapp2.rest.validations.Phone;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Da Vinci's Deemon
 *
 */
@Entity
@Table(name = "user_table")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column
	private long userId;

	@Column
	@Id
	@Email(message = "Expecting email for user name")
	@NotBlank(message = "User name should not be empty")
	private String userName;

	@Column
	@NotBlank(message = "password field should not be left blank")
	@Pattern.List({ @Pattern(regexp = "(?=.*[0-9])", message = "Password must contain one digit."),
			@Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
			@Pattern(regexp = "(?=.*[a-z])", message = "Password must contain one lowercase letter."),
			@Pattern(regexp = "(?=\\S+$)", message = "Password must contain no whitespace.") })

	private String password;
	@Column
	private LocalTime userCreationTime;
	@Column
	private String userUpdatedTime;
	@Column
	@Phone
	private String phoneNumber;

	@JsonIgnore
	@ManyToMany(mappedBy = "registeredUsers")
	private List<Course> courses = new ArrayList<>();

	public User(long userId, String userName, String password, LocalTime userCreationTime, String userUpdatedTime,
			String phoneNumber, List<Course> courses) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userCreationTime = userCreationTime;
		this.userUpdatedTime = userUpdatedTime;
		this.phoneNumber = phoneNumber;
		this.courses = courses;
	}

	public User() {

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
		return "User [userId=" + userId + "]";
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public LocalTime getUserCreationTime() {
		return userCreationTime;
	}

	public void setUserCreationTime(LocalTime userCreationTime) {
		this.userCreationTime = userCreationTime;
	}

	public String getUserUpdatedTime() {
		return userUpdatedTime;
	}

	public void setUserUpdatedTime(String userUpdatedTime) {
		this.userUpdatedTime = userUpdatedTime;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
