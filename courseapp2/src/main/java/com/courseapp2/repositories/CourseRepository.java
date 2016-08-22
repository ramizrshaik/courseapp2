package com.courseapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coureapp2.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
