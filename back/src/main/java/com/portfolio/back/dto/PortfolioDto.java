package com.portfolio.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PortfolioDto {
    public static class CreatePortfolio{
        private String projectName;
        private String description;
        private String url;
        private String image;
    }

    public static class UpdatePortfolio{
        private String projectName;
        private String description;
        private String url;
        private String image;
        private LocalDateTime updatedAt;
    }
}
