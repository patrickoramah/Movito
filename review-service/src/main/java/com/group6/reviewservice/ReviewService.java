package com.group6.reviewservice;

import org.springframework.data.domain.Page;
import java.util.UUID;

public interface ReviewService {
    ReviewResponseDTO createReview(ReviewRequestDTO request);
    Page<ReviewResponseDTO> getReviews(int page, int size, UUID movieId);
}
