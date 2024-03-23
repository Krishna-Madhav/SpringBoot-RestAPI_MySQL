package com.example.service;

import com.example.binding.Course;
import com.example.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServicImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String upsert(Course course) {
        courseRepository.save(course);
        return "Success";
    }

    @Override
    public Course getById(Integer cid) {
        Optional<Course> course = courseRepository.findById(cid);
        if (course.isPresent()) {
            return course.get();
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public String deleteCourseById(Integer cid) {
        if (courseRepository.existsById(cid)) {
            courseRepository.deleteById(cid);
            return "Successfully deleted";
        }
        else {
            return "No record found";
        }
    }
}
