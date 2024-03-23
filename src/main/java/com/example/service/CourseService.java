package com.example.service;

import com.example.binding.Course;

import java.util.List;

public interface CourseService {

    // Performs insert and update
    public String upsert(Course course);

    // To get single course based on id
    public Course getById(Integer id);

    public List<Course> getAllCourses();

    public String deleteCourseById(Integer cid);



}
