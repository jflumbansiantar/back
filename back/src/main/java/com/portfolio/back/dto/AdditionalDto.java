package com.portfolio.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class AdditionalDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateAdditional{
        private String about;
        private String emailContact;
        private String phone;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdateAdditional{
        private String id;
        private String about;
        private String emailContact;
        private String phone;
        private LocalDateTime updatedAt;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IsUsedAdditional{
        private String id;
        private Boolean isUsed;
    }
}
