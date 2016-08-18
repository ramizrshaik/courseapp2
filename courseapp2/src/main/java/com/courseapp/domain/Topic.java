package com.courseapp.domain;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Table;

@Table(name="table")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	private long topicId;
	private String courseId;
	private String topicName;
	private LocalTime topicDuration;

	private Course course;

	public Topic(){
		
	}
	
	public Topic(long topicId, String courseId, String topicName, LocalTime topicDuration, Course course) {
		super();
		this.topicId = topicId;
		this.courseId = courseId;
		this.topicName = topicName;
		this.topicDuration = topicDuration;
		this.course = course;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public LocalTime getTopicDuration() {
		return topicDuration;
	}

	public void setTopicDuration(LocalTime topicDuration) {
		this.topicDuration = topicDuration;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (topicId ^ (topicId >>> 32));
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
		Topic other = (Topic) obj;
		if (topicId != other.topicId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", courseId=" + courseId + ", topicName=" + topicName + ", topicDuration="
				+ topicDuration + "]";
	}

	
	
}
