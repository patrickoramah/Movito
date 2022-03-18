package com.group6.reviewservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class ReviewRequestDTO {
    private UUID userId;
    private UUID movieId;
    private double rating = 0.0;
    private String body;
}
