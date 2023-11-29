package com.finalproject.mooc.controller;

import com.finalproject.mooc.enums.CourseCategory;
import com.finalproject.mooc.model.responses.CoursePaginationResponse;
import com.finalproject.mooc.model.responses.CourseResponseWithSubject;
import com.finalproject.mooc.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


//sementara yak guys belum bikin Response DTO nya aku


@RestController
@Slf4j
public class CourseController {
    @Autowired
    private CourseService courseService;

    //sementara
    @GetMapping("/category-course")
    public ResponseEntity<CoursePaginationResponse> getCoursesByCategory(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false) List<CourseCategory> categories,
            @RequestParam(required = false) String username) {


        return ResponseEntity.ok(courseService.showCourseByCategory(page, categories, username));
    }

    @GetMapping("/course-detail")
    public ResponseEntity<CourseResponseWithSubject> getShowCourseDetail(
            @RequestParam(value = "courseCode") String courseCode){

        return ResponseEntity.ok(courseService.showDetailCourse(courseCode));
    }
  
    @GetMapping("/course")
    public ResponseEntity<CoursePaginationResponse> showCourse(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false) String username ){

        return ResponseEntity.ok(courseService.showCourse(page, username));
    }

    @GetMapping("/course-search")
    public ResponseEntity<CoursePaginationResponse> showCourseBySearch(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam String title,
            @RequestParam(required = false) String username ){

        return ResponseEntity.ok(courseService.showCourseBySearch(page, title, username));
}
