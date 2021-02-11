package com.josiaslgomes.unit.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.josiaslgomes.unit.test.model.Flight;

import java.util.List;

public interface FlightRepository extends PagingAndSortingRepository<Flight, Integer> {
    List<Flight> findAll();

    Flight findAllById(int id);
}
