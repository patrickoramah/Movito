package com.group6.reviewservice;

import com.group6.reviewservice.exceptions.MovieNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final RestTemplate restTemplate;

    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO request) {
        Review review = new ModelMapper().map(request, Review.class);

        try {
            restTemplate.patchForObject("http://MOVIE-SERVICE/movies/" + request.getMovieId() + "/rate", new UpdateRatingDTO(request.getRating()), HashMap.class);
            review = reviewRepository.save(review);
        } catch (HttpClientErrorException ex) {
            throw new MovieNotFoundException("Movie not found");
        }
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
