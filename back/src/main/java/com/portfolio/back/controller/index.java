package com.portfolio.back.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;

@RestController
@RequestMapping(value = "/api/test-api")
@CrossOrigin
@Slf4j
public class index {
    @SneakyThrows(Exception.class)
    @GetMapping(value = "/")
    // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<Object> startIndex() {
        log.info("POST /api/additional/new is called");

        Map<String, Object> res = new HashMap<>();

        res.put("code", HttpStatus.CREATED.value());
        res.put("success", true);
        res.put("message", "Connection success");

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
