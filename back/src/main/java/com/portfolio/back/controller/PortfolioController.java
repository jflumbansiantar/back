package com.portfolio.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.portfolio.back.dto.PortfolioDto.CreatePortfolio;
import com.portfolio.back.dto.PortfolioDto.UpdatePortfolio;
import com.portfolio.back.service.PortfolioService;

import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;

@RestController
@RequestMapping(value = "/api/portfolio")
@CrossOrigin
@Slf4j
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;

    @SneakyThrows(Exception.class)
    @PostMapping(path = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<Object> createPortfolio(@RequestBody CreatePortfolio dto) {
        log.info("POST /api/portfolio/new is called");
        return portfolioService.createPortfolio(dto);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<Object> updatePortfolio(@RequestBody UpdatePortfolio dto, @PathVariable(name = "id") String id) {
        log.info("PUT /api/portfolio/update is called");
        return portfolioService.updatePortfolio(dto, id);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<Object> getPortfolio(@RequestParam String id) {
        log.info("GET /api/portfolio/list is called");
        return portfolioService.getPortfolio(id);
    }

    @SneakyThrows(Exception.class)
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<Object> createPortfolio(@PathVariable(name = "id") String id) {
        log.info("DELETE /api/portfolio/delete is called");
        return portfolioService.delPortfolio(id);
    }
}
