package com.pathwaysedu.ap.rest.Controller;

import com.pathwaysedu.ap.rest.Entity.Course;
import com.pathwaysedu.ap.rest.Response.CourseResponse;
import com.pathwaysedu.ap.rest.Service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping()
    public List<CourseResponse> getAllCourses(@RequestParam(required = true)Integer prereq,
                                              @RequestParam(required = true)Integer college,
                                              @RequestParam(required = true)String country,
                                              @RequestParam(required = true)String region,
                                              @RequestParam(required = true)String district
                                              ){

        List<Course> courses = courseService.getAllCourses(prereq, college, country, region, district);
        List<CourseResponse> courseResponse = new ArrayList<>();

        courses.forEach(course -> {
            courseResponse.add(new CourseResponse(course));
        });

        return courseResponse;
    }
/*
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse addCourse(@RequestBody CourseRequest courseRequest){
        Course course = courseService.insertCourse(courseRequest);

        return new CourseResponse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable long id, @Valid @RequestBody CourseRequest courseRequest){
        Course course = courseService.updateCourse(id, courseRequest);

        return course;
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable long id){
        courseService.deleteCourse(id);
    }

 */
}
