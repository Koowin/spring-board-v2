package com.koowin.boardv2.exception;

public class BadRequestException extends RuntimeException{
    private static String ERROR_STRING = "Can't find post by postId = ";
    public BadRequestException(Long postId) {
        super(ERROR_STRING + postId);
    }
}
