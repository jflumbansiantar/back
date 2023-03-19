package com.portfolio.back.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.back.model.Additional;

@Repository
public interface AdditionalRepository extends MongoRepository<Additional, String>{
    Optional<Additional> findById(String id);
}
