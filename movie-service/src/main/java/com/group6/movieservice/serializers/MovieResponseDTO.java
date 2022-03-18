package com.group6.movieservice.serializers;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Set;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class MovieResponseDTO {
    private String title;
    private String summary;
    private String description;
    private String trailerUrl;
    private String posterUrl;
    private Date releaseDate;
    private double rating = 0.0;
    private Set<DirectorDTO> directors;
    private Set<CastDTO> casts;
}
