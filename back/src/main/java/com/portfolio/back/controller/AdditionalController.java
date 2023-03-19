package com.portfolio.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.portfolio.back.dto.AdditionalDto.CreateAdditional;
import com.portfolio.back.dto.AdditionalDto.IsUsedAdditional;
import com.portfolio.back.dto.AdditionalDto.UpdateAdditional;
import com.portfolio.back.service.AdditionalService;

import lombok.extern.slf4j.Slf4j;
import lombok.SneakyThrows;

@RestController
@RequestMapping(value = "/api/additional")
@CrossOrigin
@Slf4j
public class AdditionalController {
    @Autowired
    private AdditionalService additionalService;

    @SneakyThrows(Exception.class)
    @PostMapping(value = "/new", produces = MediaType.APPLICATION_JSON_VALUE)
    // @PreAuthorize("hasRole('USER') or hasRole('MODERATOR')")
    public ResponseEntity<Object> createAdditional(@RequestBody CreateAdditional dto) {
        log.info("POST /api/additional/new is called");
        return additionalService.createAdditional(dto);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(value = "/list/{id}")
    // @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> getAdditional(@PathVariable String id) {
        log.info("GET /api/additional/list is called");
        return additionalService.getAdditional(id);
    }

    @SneakyThrows(Exception.class)
    @DeleteMapping(value = "/{id}")
    // @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Object> deleteAdditional(@PathVariable String id) {
        log.info("DELETE /api/{id} is called");
        return additionalService.delAdditional(id);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(value = "/update")
    // @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<Object> updateAdditional(@RequestBody UpdateAdditional dto) {
        log.info("PUT /api/additional/update is called");
        return additionalService.updateAdditional(dto);
    }

    @SneakyThrows(Exception.class)
    @PatchMapping(value = "/update")
    // @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<Object> isUsedAdditional(@RequestBody IsUsedAdditional dto) {
        log.info("PATCH /api/additional/update is called");
        return additionalService.isUsedAdditional(dto);
    }
}
