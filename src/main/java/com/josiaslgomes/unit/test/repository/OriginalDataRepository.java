package com.josiaslgomes.unit.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.josiaslgomes.unit.test.model.OriginalData;

public interface OriginalDataRepository extends PagingAndSortingRepository<OriginalData, Integer> {
}
