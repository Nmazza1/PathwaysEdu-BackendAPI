package com.pathwaysedu.ap.rest.Entity;

import com.pathwaysedu.ap.rest.Request.SchoolRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "school_name", nullable = false)
    private String schoolName;

    @Column(name = "school_img_url", nullable = false)
    private String schoolImgUrl;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "college", nullable = false)
    private long college;

    public School(SchoolRequest schoolRequest){
        schoolName = schoolRequest.getSchoolName();
        schoolImgUrl = schoolRequest.getSchoolImgUrl();
        region = schoolRequest.getRegion();
        district = schoolRequest.getDistrict();
        country = schoolRequest.getCountry();
        college = schoolRequest.getCollege();
    }


}