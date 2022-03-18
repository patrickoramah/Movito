package com.group6.reviewservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO request) {
        Review review = new ModelMapper().map(request, Review.class);
        review = reviewRepository.save(review);
        return new ModelMapper().map(review, ReviewResponseDTO.class);
    }

    @Override
    public Page<ReviewResponseDTO> getReviews(int page, int size, UUID movieId) {
        if (page < 1)
            page = 1;
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("dateCreated").descending());
        return reviewRepository.findAllByMovieId(pageable, movieId).map(entity -> new ModelMapper().map(entity, ReviewResponseDTO.class));
    }
}
