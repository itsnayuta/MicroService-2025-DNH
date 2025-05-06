package com.example.result_service.repository;

import com.example.result_service.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer> {
    List<Result> findByUserId(Integer userId);
}
