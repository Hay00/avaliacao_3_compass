package com.compass.avaliacao3.repository;

import com.compass.avaliacao3.model.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

    Page<State> findByRegion(String region, Pageable pageable);

    Page<State> findByPopulation(Long population, Pageable pageable);

    Page<State> findByArea(Float area, Pageable pageable);

    Page<State> findByRegionContains(String region, Pageable pageable);
}
