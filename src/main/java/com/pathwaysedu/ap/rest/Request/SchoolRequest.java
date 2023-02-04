package com.pathwaysedu.ap.rest.Request;

//import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolRequest {
  //  @NotBlank
    private String schoolName;
    //@NotBlank
    private String schoolImgUrl;
    //@NotBlank
    private String region;

    private String district;

    private String country;

    private Boolean college;

}