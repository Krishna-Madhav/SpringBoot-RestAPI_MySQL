package com.example.repo;

import com.example.binding.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CourseRepository extends JpaRepository<Course, Serializable> {
}
