package com.portfolio.back.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.back.dto.AdditionalDto.CreateAdditional;
import com.portfolio.back.dto.AdditionalDto.IsUsedAdditional;
import com.portfolio.back.dto.AdditionalDto.UpdateAdditional;
import com.portfolio.back.model.Additional;
import com.portfolio.back.repository.AdditionalRepository;

import lombok.SneakyThrows;

@Service
public class AdditionalService {
    @Autowired
    private AdditionalRepository additionalRepository;

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> createAdditional(CreateAdditional dto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();

        Additional additional = new Additional();
        additional.setAbout(dto.getAbout());
        additional.setEmailContact(dto.getEmailContact());
        additional.setPhone(dto.getPhone());
        additionalRepository.save(additional);

        res.put("code", HttpStatus.CREATED.value());
        res.put("success", true);
        res.put("data", additional);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> updateAdditional(UpdateAdditional dto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();

        Optional<Additional> found = additionalRepository.findById(dto.getId());

        if(found.isPresent()){
            Additional data = found.get();
            data.setAbout(dto.getAbout());
            data.setUpdatedAt(LocalDateTime.now());
            data.setEmailContact(dto.getEmailContact());
            data.setPhone(dto.getPhone());
            additionalRepository.save(data);

            res.put("code", HttpStatus.OK.value());
            res.put("success", true);
            res.put("data", data);
        } else {
            res.put("code", HttpStatus.NOT_FOUND.value());
            res.put("success", false);
            res.put("data", null);
        }

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getAdditional(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();
        
        if (id == null){
            List<Additional> getAll = additionalRepository.findAll();

            res.put("code", HttpStatus.OK.value());
            res.put("success", true);
            res.put("data", getAll);
        
        } else {
            Optional<Additional> found = additionalRepository.findById(id);
    
            if(found.isPresent()){
                res.put("code", HttpStatus.OK.value());
                res.put("success", true);
                res.put("data", found);
            } else {
                res.put("code", HttpStatus.NOT_FOUND.value());
                res.put("success", false);
                res.put("data", null);
            }
        }

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> delAdditional(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();

        try {
            Optional<Additional> found = additionalRepository.findById(id);

            if(found.isPresent()){
            
                additionalRepository.deleteById(id);
            
                res.put("code", HttpStatus.OK.value());
                res.put("success", true);
                res.put("message", ("Data is deleted"));
            
            } else {
            
                res.put("code", HttpStatus.NOT_FOUND.value());
                res.put("success", false);
                res.put("data", null);
            }
          } catch (Exception e) {
            
            res.put("code", HttpStatus.NOT_FOUND.value());
                res.put("success", e);
                res.put("data", null);
          }
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> isUsedAdditional(IsUsedAdditional dto){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> res = new HashMap<>();

        Optional<Additional> found = additionalRepository.findById(dto.getId());

        if(found.isPresent()){
            Additional data = found.get();
            data.setUpdatedAt(LocalDateTime.now());
            data.setIsUsed(dto.getIsUsed());
            additionalRepository.save(data);

            res.put("code", HttpStatus.OK.value());
            res.put("success", true);
            res.put("data", data);
        } else {
            res.put("code", HttpStatus.NOT_FOUND.value());
            res.put("success", false);
            res.put("data", null);
        }

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res);
    }
}
