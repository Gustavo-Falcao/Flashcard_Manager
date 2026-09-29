package org.flashCardManager.controller.common;

public record Result<T>(
        boolean success,
        T data,
        String errorMessage
) {

    public static <T> Result<T> success(T data) {
        return new Result<>(true, data, null);
    }

    public static <T> Result<T> failure(String errorMessage) {
        return new Result<>(false, null, errorMessage);
    }

}
