package com.pathwaysedu.ap.rest.Entity;

import com.pathwaysedu.ap.rest.Request.CourseRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "course_link")
    private String courseLink;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idschool")
    private School school;

    // Prerequisite is a binary representation of the requirements for the course
    @Column(name = "prerequisite")
    private Integer prerequisite;

    @Column(name="description")
    @Lob
    private String description;

    @Column(name = "program_length")

    private String programLength;

    public Course(CourseRequest courseRequest) {
        courseName = courseRequest.getCourseName();
        courseLink = courseRequest.getCourseLink();
        prerequisite = courseRequest.getPrerequisite();
        description = courseRequest.getDescription();
        programLength = courseRequest.getProgramLength();

    }
}
