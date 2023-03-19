package com.portfolio.back.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "additional")
@Setter
@Getter
public class Additional {
    @Id
    private String id;

    @NotBlank
    private String about;
    
    @NotBlank
    @Email
    private String emailContact;

    private String phone;

    private Boolean isUsed = true;

    @NotBlank
    protected LocalDateTime createdAt = LocalDateTime.now();

    protected LocalDateTime updatedAt;

    public Additional(){

    }
    public Additional(String about, String emailContact, String phone){
        this.about = about;
        this.emailContact = emailContact;
        this.phone = phone;
    }
}
