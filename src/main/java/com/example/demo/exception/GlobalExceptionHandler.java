package com.example.demo.exception;

import com.example.demo.config.ApiResponse;
import com.example.demo.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler  {
    @ExceptionHandler(Exception.class)
    public ApiResponse<Object> handleGeneralException(Exception ex, HttpServletRequest request) {
        return ResponseUtil.error(Arrays.asList(ex.getMessage()), "An unexpected error occurred", 1001, request.getRequestURI());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<Object> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        return ResponseUtil.error(Arrays.asList(ex.getMessage()), "Resource not found", 404, request.getRequestURI());
    }

    @ExceptionHandler(ResponseNotFoundException.class)
    public ApiResponse<Object> handleResponseNotFoundException(ResponseNotFoundException ex, HttpServletRequest request) {
        return ResponseUtil.error(Arrays.asList(ex.getMessage()), "Response data not found", 204, request.getRequestURI());
    }

    @ExceptionHandler(CustomException.class)
    public ApiResponse<Object> handleCustomException(CustomException ex, HttpServletRequest request) {
        return ResponseUtil.error(Arrays.asList(ex.getMessage()), "An unexpected error occurred", 500, request.getRequestURI());
    }
}
