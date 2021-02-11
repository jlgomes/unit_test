package com.josiaslgomes.unit.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.josiaslgomes.unit.test.model.Arrival;

import java.util.List;

public interface ArrivalRepository extends PagingAndSortingRepository<Arrival, Integer> {
    List<Arrival> findAll();

    Arrival findAllById(int id);
}
