package com.josiaslgomes.unit.test.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.josiaslgomes.unit.test.model.Users;

import java.util.List;

public interface UsersRepository extends PagingAndSortingRepository<Users, Integer> {
    List<Users> findAll();

    Users findAllById(int id);

    @Transactional
    void deleteById(int id);
}
