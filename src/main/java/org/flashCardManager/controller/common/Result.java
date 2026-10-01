package org.flashCardManager.controller.common;

public record Result<T>(
        boolean success,
        T data,
        ErrorType errorType,
        String errorMessage
) {

    public static <T> Result<T> success(T data) {
        return new Result<>(true, data, null, null);
    }

    public static <T> Result<T> failure(ErrorType errorType, String errorMessage) {
        return new Result<>(false, null, errorType, errorMessage);
    }

}
