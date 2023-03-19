package com.portfolio.back.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators.Or;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.back.dto.PortfolioDto.CreatePortfolio;
import com.portfolio.back.dto.PortfolioDto.UpdatePortfolio;
import com.portfolio.back.model.Portfolio;
import com.portfolio.back.repository.PortfolioRepository;

import lombok.SneakyThrows;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    private static final String SUCCESS = "success";

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createPortfolio(CreatePortfolio dto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();

        Portfolio portfolio = new Portfolio();
        portfolio.setCreatedAt(LocalDateTime.now());
        portfolio.setProjectName(dto.getProjectName());
        portfolio.setDescription(dto.getDescription());
        portfolio.setUrl(dto.getUrl());
        portfolio.setImage(dto.getImage());
        portfolioRepository.save(portfolio);

        res.put(SUCCESS, true);
        res.put("code", HttpStatus.CREATED.value());
        res.put("data", portfolio);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> updatePortfolio(UpdatePortfolio dto, String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();

        Optional<Portfolio> found = portfolioRepository.findById(id);

        if(found.isPresent()){
            Portfolio data = found.get();
            data.setUpdatedAt(LocalDateTime.now());
            data.setDescription(dto.getDescription());
            data.setUrl(dto.getUrl());
            data.setImage(dto.getImage());
            portfolioRepository.save(data);

            res.put("code", HttpStatus.OK.value());
            res.put(SUCCESS, true);
            res.put("data", data);
        } else {
            res.put("code", HttpStatus.NOT_FOUND.value());
            res.put(SUCCESS, false);
            res.put("data", null);
        }

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getPortfolio(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();
        System.out.println(id + "ini string id");
        if ("".equals(id)){
            List<Portfolio> getAll = portfolioRepository.findAll();

            res.put("code", HttpStatus.OK.value());
            res.put(SUCCESS, true);
            res.put("data", getAll);
        
        } else {
            Optional<Portfolio> found = portfolioRepository.findById(id);
    
            if(found.isPresent()){
                res.put("code", HttpStatus.OK.value());
                res.put(SUCCESS, true);
                res.put("data", found);
            } else {
                res.put("code", HttpStatus.NOT_FOUND.value());
                res.put(SUCCESS, false);
                res.put("data", null);
            }
        }
        
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> delPortfolio(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();
        
        try {
            Optional<Portfolio> found = portfolioRepository.findById(id);

            if(found.isPresent()){
            
                portfolioRepository.deleteById(id);
            
                res.put("code", HttpStatus.OK.value());
                res.put(SUCCESS, true);
                res.put("message", ("Data is deleted"));
            
            } else {
            
                res.put("code", HttpStatus.NOT_FOUND.value());
                res.put(SUCCESS, false);
                res.put("data", null);
            }
        } catch (Exception e) {
            
            res.put("code", HttpStatus.NOT_FOUND.value());
                res.put(SUCCESS, e);
                res.put("data", null);
        }
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

}
