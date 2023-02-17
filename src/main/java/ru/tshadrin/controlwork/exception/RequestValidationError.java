package ru.tshadrin.controlwork.exception;

import java.util.List;

public class RequestValidationError {
    private List<FieldValidationError> errors;

    public RequestValidationError(List<FieldValidationError> errorDTOList) {
        this.errors = errorDTOList;
    }

    public List<FieldValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldValidationError> errors) {
        this.errors = errors;
    }
}
