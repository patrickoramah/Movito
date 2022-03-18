package com.group6.reviewservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewResponseDTO {
    private UUID userId;
    private double rating = 0.0;
    private String body;
    private Date dateCreated;
}
