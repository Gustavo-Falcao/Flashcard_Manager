package org.flashCardManager.exceptions;

import org.flashCardManager.controller.common.ErrorType;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.NOT_FOUND;
    }
}
