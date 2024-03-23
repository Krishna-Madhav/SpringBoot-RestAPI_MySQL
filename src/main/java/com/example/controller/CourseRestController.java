package com.example.controller;

import com.example.binding.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
        String upsert = courseService.upsert(course);
        return new ResponseEntity<>(upsert, HttpStatus.CREATED);
    }

    @GetMapping("/courses/{cid}")
    public ResponseEntity<Course> getCourse(@PathVariable Integer cid){
        Course retreivedCourse = courseService.getById(cid);
        return new ResponseEntity<>(retreivedCourse, HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> retreivedCourses = courseService.getAllCourses();
        return new ResponseEntity<>(retreivedCourses, HttpStatus.OK);
    }

    @PutMapping("/courses")
    public ResponseEntity<String> updateCourse(@RequestBody Course course){
        String upsert = courseService.upsert(course);
        return new ResponseEntity<>(upsert, HttpStatus.OK);
    }

    @DeleteMapping("/courses/{cid}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer cid){
        String status = courseService.deleteCourseById(cid);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
