package com.portfolio.back.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.back.model.Portfolio;

@Repository
public interface PortfolioRepository extends MongoRepository<Portfolio, String>{
    Optional<Portfolio> findById(String id);
}
