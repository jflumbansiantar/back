package com.portfolio.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class PortfolioDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreatePortfolio{
        private String projectName;
        private String description;
        private String url;
        private String image;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UpdatePortfolio{
        private String projectName;
        private String description;
        private String url;
        private String image;
        private LocalDateTime updatedAt;
    }
}
