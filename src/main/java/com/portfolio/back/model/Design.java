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
@Document(collection = "designs")
@Setter
@Getter
public class Design {
    @Id
    private String id;

    @NotBlank
    @Size(max = 255)
    private String designName;
    
    @NotBlank
    private String description;

    private String image;

    @NotBlank
    protected LocalDateTime createdAt = LocalDateTime.now();

    protected LocalDateTime updatedAt;

    public Design(){

    }

    public Design(String designName, String description, String image){
        this.designName = designName;
        this.description = description;
        this.image = image;
    }
}
