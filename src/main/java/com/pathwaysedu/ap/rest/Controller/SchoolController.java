package com.pathwaysedu.ap.rest.Controller;

import com.pathwaysedu.ap.rest.Entity.Course;
import com.pathwaysedu.ap.rest.Entity.School;
import com.pathwaysedu.ap.rest.Response.CourseResponse;
import com.pathwaysedu.ap.rest.Response.SchoolResponse;
import com.pathwaysedu.ap.rest.Service.CourseService;
import com.pathwaysedu.ap.rest.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/schools")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @Autowired
    CourseService courseService;

    @GetMapping()
    public List<SchoolResponse> getAllSchools(@RequestParam(required = false) String region) {
        List<School> schools = schoolService.getAllSchools(region);

        List<SchoolResponse> schoolResponse = new ArrayList<>();
        schools.forEach(school -> {
            schoolResponse.add(new SchoolResponse(school));
        });
        return schoolResponse;
    }

/*
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolResponse addSchool(@Valid @RequestBody SchoolRequest schoolRequest) {
        School school = schoolService.addSchool(schoolRequest);
        return new SchoolResponse(school);
    }

    @PutMapping("/{id}")
    public School updateSchool(@PathVariable long id, @Valid @RequestBody SchoolRequest schoolRequest) {
        School school = schoolService.updateSchool(id, schoolRequest);

        return school;
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable long id) {
        schoolService.deleteSchool(id);
    }

    @PostMapping("/{schoolId}/courses")
    public CourseResponse addCourse(
            @PathVariable long schoolId,
            @Valid @RequestBody CourseRequest courseRequest
    ) {
        return new CourseResponse(
                schoolService.addCourseToSchool(schoolId, courseRequest));

    }


 */
    @GetMapping("/{id}/courses")
    public List<CourseResponse> getAllCourses(@PathVariable long id, @RequestParam(required = true) Integer prereq, @RequestParam(required = true) String region) {

        List<Course> courses = courseService.getAllCoursesForSchool(id, prereq, region);
        List<CourseResponse> courseResponse = new ArrayList<>();

        courses.forEach(course -> {
            courseResponse.add(new CourseResponse(course));
        });

        return courseResponse;

    }
}