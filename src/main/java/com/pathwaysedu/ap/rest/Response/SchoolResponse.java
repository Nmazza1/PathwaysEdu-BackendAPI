package com.pathwaysedu.ap.rest.Response;

import com.pathwaysedu.ap.rest.Entity.School;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolResponse {
    private long id;
    private String schoolName;
    private String schoolImgUrl;
    private String region;

    private String district;

    private String country;

    private Integer college;

    public SchoolResponse(School school){
        id = school.getId();
        schoolName = school.getSchoolName();
        schoolImgUrl = school.getSchoolImgUrl();
        region = school.getRegion();
        district = school.getDistrict();
        country = school.getCountry();
        college = school.getCollege();
    }

}