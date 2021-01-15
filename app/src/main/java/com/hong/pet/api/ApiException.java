package com.hong.pet.api;

public class ApiException extends RuntimeException {
    private int mErrorCode;
    public ApiException(int errorCode, String errorMessage) {
        super(errorMessage);
        mErrorCode = errorCode;
    }
}