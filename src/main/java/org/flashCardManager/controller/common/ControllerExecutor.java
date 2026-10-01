package org.flashCardManager.controller.common;

import org.flashCardManager.exceptions.ApplicationException;

import java.util.function.Supplier;

public class ControllerExecutor {
    private ControllerExecutor(){}

    public static <T> Result<T> execute(Supplier<T> action) {
        try {
            return Result.success(action.get());
        } catch (ApplicationException e) {
            return handleException(e);
        } catch (RuntimeException e) {
            return handleUnexpectedException(e);
        }
    }

    public static Result<Void> execute(Runnable action) {
        try {
            action.run();
            return Result.success(null);
        } catch (ApplicationException e) {
            return handleException(e);
        } catch (RuntimeException e) {
            return handleUnexpectedException(e);
        }
    }

    private static <T> Result<T> handleException(ApplicationException exception) {
        return Result.failure(exception.getErrorType(), exception.getMessage());
    }

    private static <T> Result<T> handleUnexpectedException(RuntimeException exception) {
        return Result.failure(ErrorType.UNEXPECTED, "Um erro inesperado aconteceu");
    }
}
