package com.portfolio.back.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.back.dto.PortfolioDto.CreatePortfolio;
import com.portfolio.back.dto.PortfolioDto.UpdatePortfolio;
import com.portfolio.back.repository.PortfolioRepository;

import lombok.SneakyThrows;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createPortfolio(CreatePortfolio dto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> updatePortfolio(UpdatePortfolio dto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getPortfolio(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> delPortfolio(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

}
