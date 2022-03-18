package com.group6.reviewservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class ReviewResponseDTO {
    private UUID userId;
    private double rating = 0.0;
    private String body;
    private Date dateCreated;
}
