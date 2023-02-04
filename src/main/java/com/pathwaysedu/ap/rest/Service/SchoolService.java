package com.pathwaysedu.ap.rest.Service;

import com.pathwaysedu.ap.rest.Entity.School;
import com.pathwaysedu.ap.rest.Repository.CourseRepository;
import com.pathwaysedu.ap.rest.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    CourseRepository courseRepository;

    public List<School> getAllSchools(String region){
        if(region == null || region.isEmpty())
            return (List<School>) schoolRepository.findAll();
        else{
            return schoolRepository.findAllByRegion(region);
        }
    }
/*
    public School addSchool(SchoolRequest schoolRequest){
        return schoolRepository.save(new School(schoolRequest));
    }

    public School updateSchool(long schoolId, SchoolRequest schoolRequest){
        return schoolRepository.findById(schoolId).map(school -> {
            School schoolToBeUpdated = new School(schoolRequest);
            schoolToBeUpdated.setSchoolid(school.getSchoolid());
            return schoolRepository.save(schoolToBeUpdated);
        }).orElseThrow(()->new ResourceNotFound("School Not Found"));
    }

    public void deleteSchool(long schoolId){
        schoolRepository.findById(schoolId).orElseThrow(()->new ResourceNotFound("School Not Found"));
        schoolRepository.deleteById(schoolId);
    }

    public Course addCourseToSchool(long schoolId, CourseRequest courseRequest){
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(()->new ResourceNotFound("School Not Found"));
        Course courseToBeAdded = new Course(courseRequest);
        courseToBeAdded.setSchool(school);
        return courseRepository.save(courseToBeAdded);
    }
    */


}