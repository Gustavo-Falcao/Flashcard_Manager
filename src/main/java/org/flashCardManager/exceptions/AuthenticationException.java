package org.flashCardManager.exceptions;

import org.flashCardManager.controller.common.ErrorType;

public class AuthenticationException extends ApplicationException {
    public AuthenticationException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.AUTHENTICATION;
    }
}
