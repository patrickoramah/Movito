/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group6.reviewservice.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(Include.NON_NULL)
public class ErrorResponse
{
 private String code;
 private String message;
 private List<ValidationErrorResponse> errors;

 public ErrorResponse(String code, String message) {
  this.code = code;
  this.message = message;
 }

 public ErrorResponse(String code, String message, List<ValidationErrorResponse> errors) {
  this.code = code;
  this.message = message;
  this.errors = errors;
 }
}