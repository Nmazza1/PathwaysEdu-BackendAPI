package com.pathwaysedu.ap.rest.Service;

import com.pathwaysedu.ap.rest.Entity.Course;
import com.pathwaysedu.ap.rest.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;


    public List<Course> getAllCoursesForSchool(Long school_id, Integer prerequisite, String region){
            return courseRepository.findAllBySchool_IdAndPrerequisiteAndSchool_Region(school_id, prerequisite, region );
    }

    public List<Course> getAllCourses(Integer prerequisite, String region){
            return courseRepository.findAllByPrerequisiteAndSchool_Region(prerequisite, region);
    }
/*
    public Course insertCourse(CourseRequest courseRequest){
        return courseRepository.save(new Course(courseRequest));
    }

    public Course updateCourse(long courseId, CourseRequest courseRequest) {

        return courseRepository.findById(courseId).map(course -> {
            Course courseToBeUpdated = new Course(courseRequest);
            courseToBeUpdated.setCourseid(course.getCourseid());
            return courseRepository.save(courseToBeUpdated);
        }).orElseThrow(()->new ResourceNotFound("Course ID could not be found"));
    }

    public void deleteCourse(long courseId){
        courseRepository.findById(courseId).orElseThrow(()->new ResourceNotFound("Course ID could not be found"));
        courseRepository.deleteById(courseId);
    }
    */

}