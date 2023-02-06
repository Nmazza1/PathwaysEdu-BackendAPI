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
            "SELECT railway.course.course_name, school.id as idschool, course.id,\n" +
                    "                   prerequisite, course_link, school.school_name,\n" +
                    "                   school.region, school.college, school.country," +
                    "school.district\n" +
                    "            FROM railway.course\n" +
                    "         INNER JOIN school ON railway.course.idschool = school.id\n" +
                    "WHERE prerequisite = ~ (:prereq ^ course.prerequisite) & :prereq\n" +
                    "AND school.region = :region\n" +
                    "AND school.college = :college\n" +
                    "AND school.country = :country\n" +
                    "AND school.district = :district"
            , nativeQuery = true)


    List<Course> findAllByPrerequisiteAndSchool_CollegeAndSchool_CountryAndSchool_RegionAndSchool_District
            (@Param("prereq") Integer prereq, @Param("college") Integer college,
             @Param("country") String country,@Param("region") String region,
             @Param("district") String District);


    @Query(value = "SELECT railway.course.course_name, school.id as idschool, course.id,\n" +
            "                   prerequisite, course_link, school.school_name,\n" +
            "                   school.region\n" +
            "            FROM railway.course\n" +
            "                     INNER JOIN school ON railway.course.idschool = school.id\n" +
            "            WHERE prerequisite = ~ (:prereq ^ course.prerequisite) & :prereq\n" +
            "              AND school.region = :region\n" +
            "            AND railway.course.idschool = :id", nativeQuery = true)
    List<Course> findAllBySchool_IdAndPrerequisiteAndSchool_Region(@Param("id")long id,
                                                                   @Param("prereq") Integer prereq,
                                                                   @Param("region") String region);





}