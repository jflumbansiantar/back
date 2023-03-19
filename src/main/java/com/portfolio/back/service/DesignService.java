package com.portfolio.back.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.back.repository.DesignRepository;

@Service
public class DesignService {
    @Autowired
    private DesignRepository designRepository;
}
