package com.pathwaysedu.ap.rest.Repository;

import com.pathwaysedu.ap.rest.Entity.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    List<School> findAllByRegion(String region);
}