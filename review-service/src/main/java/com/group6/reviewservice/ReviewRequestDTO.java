package com.group6.reviewservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewRequestDTO {
    private UUID userId;
    private UUID movieId;
    private double rating = 0.0;
    private String body;
}
