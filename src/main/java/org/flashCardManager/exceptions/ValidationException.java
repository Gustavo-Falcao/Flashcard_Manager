package org.flashCardManager.exceptions;

import org.flashCardManager.controller.common.ErrorType;

public class ValidationException extends ApplicationException {

    public ValidationException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION;
    }
}
