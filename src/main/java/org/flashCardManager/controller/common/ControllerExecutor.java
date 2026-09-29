package org.flashCardManager.controller.common;

import java.util.function.Supplier;

public class ControllerExecutor {
    private ControllerExecutor(){}

    public static <T> Result<T> execute(Supplier<T> action) {
        try {
            return Result.success(action.get());
        } catch (RuntimeException e) {
            return Result.failure(e.getMessage());
        }
    }

    public static Result<Void> execute(Runnable action) {
        try {
            action.run();
            return Result.success(null);
        } catch (RuntimeException e) {
            return Result.failure(e.getMessage());
        }
    }
}
