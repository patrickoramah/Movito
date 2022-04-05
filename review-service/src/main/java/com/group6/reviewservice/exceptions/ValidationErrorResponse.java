package com.group6.reviewservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ValidationErrorResponse {
    private String field;
    private String message;
}