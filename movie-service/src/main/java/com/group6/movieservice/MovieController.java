package com.group6.movieservice;

import com.group6.movieservice.serializers.ResponseMessageDTO;
import com.group6.movieservice.serializers.MovieRequestDTO;
import com.group6.movieservice.serializers.MovieResponseDTO;
import com.group6.movieservice.serializers.UpdateRatingDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="movies")
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping(value="{movieId}/upload-poster", consumes = "multipart/form-data")
    public ResponseEntity<ResponseMessageDTO> uploadPoster(@PathVariable(value="movieId") UUID movieId, @RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok(movieService.uploadPoster(movieId, file));
    }

    @PostMapping("")
    public ResponseEntity<MovieResponseDTO> createMovie(@RequestBody MovieRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(request));
    }

    @PutMapping("{movieId}")
    public ResponseEntity<MovieResponseDTO> updateMovie(@PathVariable(value="movieId") UUID movieId, @RequestBody MovieRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.updateMovie(movieId, request));
    }

    @GetMapping("search")
    public ResponseEntity<Page<MovieResponseDTO>> searchMovies(@RequestParam(value="page") int page,
                                                               @RequestParam(value="size") int size,
                                                               @RequestParam(value="query") String query) {
        return ResponseEntity.ok(movieService.searchMovies(page, size, query));
    }


    @GetMapping("{movieId}")
    public ResponseEntity<MovieResponseDTO> getSingleMovie(@PathVariable(value="movieId") UUID movieId) {
        return ResponseEntity.ok(movieService.getSingleMovie(movieId));
    }

    @DeleteMapping("{movieId}")
    public ResponseEntity<ResponseMessageDTO> deleteMovie(@PathVariable(value="movieId") UUID movieId) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(movieService.deleteMovie(movieId));
    }

    @PatchMapping("{movieId}/rate")
    public ResponseEntity<ResponseMessageDTO> updateRating(@PathVariable(value="movieId") UUID movieId,
                                                           @RequestBody UpdateRatingDTO request) {
        return ResponseEntity.ok(movieService.updateRating(movieId, request));
    }

    @GetMapping("")
    public ResponseEntity<Page<MovieResponseDTO>> getSingleMovie(@RequestParam(value="page") int page, @RequestParam(value="size") int size) {
        return ResponseEntity.ok(movieService.getAllMovies(page, size));
    }

    @GetMapping("popular")
    public ResponseEntity<List<MovieResponseDTO>> getPopularMovies() {
        return ResponseEntity.ok(movieService.getPopularMovies());
    }

    @GetMapping("top-rated")
    public ResponseEntity<List<MovieResponseDTO>> topRatedMovies() {
        return ResponseEntity.ok(movieService.topRatedMovies());
    }
}
