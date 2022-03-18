package com.group6.movieservice.serializers;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class CastDTO {
    private String screenName;
    private String playedBy;
}
