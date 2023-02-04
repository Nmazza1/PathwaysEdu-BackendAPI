package com.pathwaysedu.ap.rest.Repository;

import com.pathwaysedu.ap.rest.Entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>, QueryByExampleExecutor<Course> {
/*
    List<Course> findBySchool_Id(long id);
    void deleteBySchool_Id(long id);

 */

    @Query(value =
            "SELECT course_name, school.id as idschool, course.id,\n" +
                    "       prerequisite, course_link, school.school_name,\n" +
                    "       school.region\n" +
                    "FROM COURSE\n" +
                    "         INNER JOIN School ON pathwaysedu.course.idschool = School.id\n" +
                    "WHERE prerequisite = ~ (:prereq ^ course.prerequisite) & :prereq\n" +
                    "  AND school.region = :region"
            , nativeQuery = true)


    List<Course> findAllByPrerequisiteAndSchool_Region(@Param("prereq") Integer prereq, @Param("region") String region);


    @Query(value = "SELECT pathwaysedu.course.course_name, school.id as idschool, course.id,\n" +
            "       prerequisite, course_link, school.school_name,\n" +
            "       school.region\n" +
            "FROM COURSE\n" +
            "         INNER JOIN School ON pathwaysedu.course.idschool = School.id\n" +
            "WHERE prerequisite = ~ (:prereq ^ course.prerequisite) & :prereq\n" +
            "  AND school.region = :region \n" +
            "AND pathwaysedu.course.idschool = :id", nativeQuery = true)
    List<Course> findAllBySchool_IdAndPrerequisiteAndSchool_Region(@Param("id")long id,
                                                                   @Param("prereq") Integer prereq,
                                                                   @Param("region") String region);





}