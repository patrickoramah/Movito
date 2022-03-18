package com.group6.reviewservice;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


@RestController
@RequestMapping(value="reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping(value="")
//    @ApiOperation(value="Create review")
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReview(request));
    }

    @PostMapping(value="{movieId}")
//    @ApiOperation(value="Get reviews")
    public ResponseEntity<Page<ReviewResponseDTO>> getReviews(@RequestParam(value="page") int page,
                                                              @RequestParam(value="size") int size,
                                                              @PathVariable(value="movieId") UUID movieId) {
        return ResponseEntity.ok(reviewService.getReviews(page, size, movieId));
    }
}
