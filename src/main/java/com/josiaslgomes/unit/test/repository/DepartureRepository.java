package com.josiaslgomes.unit.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.josiaslgomes.unit.test.model.Departure;

import java.util.List;

public interface DepartureRepository extends PagingAndSortingRepository<Departure, Integer> {
    List<Departure> findAll();

    Departure findAllById(int id);
}
