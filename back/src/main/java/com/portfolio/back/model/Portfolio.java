package com.portfolio.back.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@Document(collection = "portfolio")
@Setter
@Getter
public class Portfolio {
    @Id
    private String id;

    @NotBlank
    @Size(max = 255)
    private String projectName;
    
    @NotBlank
    private String description;

    private String url;

    private String image;

    @NotBlank
    protected LocalDateTime createdAt = LocalDateTime.now();

    protected LocalDateTime updatedAt;

    public Portfolio(){

    }

    public Portfolio(String projectName, String description, String url, String image){
        this.projectName = projectName;
        this.description = description;
        this.url = url;
        this.image = image;
    }
}
