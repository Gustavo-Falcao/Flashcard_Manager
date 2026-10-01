package org.flashCardManager.exceptions;

import org.flashCardManager.controller.common.ErrorType;

public abstract class ApplicationException extends RuntimeException {

    protected ApplicationException(String message) {
        super(message);
    }

    public abstract ErrorType getErrorType();
}
