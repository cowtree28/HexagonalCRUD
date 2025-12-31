package com.example.hexagonal.core.common.exception;

public interface ErrorCode {
    String getMessage();
    int getHttpStatus();
}
