package org.flashCardManager.exceptions;

import org.flashCardManager.controller.common.ErrorType;

public class PersistenceException extends ApplicationException {

    public PersistenceException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.PERSISTENCE;
    }
}
