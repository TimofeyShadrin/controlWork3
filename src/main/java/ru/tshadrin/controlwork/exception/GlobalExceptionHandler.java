package ru.tshadrin.controlwork.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RequestValidationError> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<FieldValidationError> errors = exception.getFieldErrors().stream()
                .map(fieldError -> new FieldValidationError(
                        fieldError.getField(), fieldError.getDefaultMessage()
                )).toList();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RequestValidationError(errors));
    }

    @ExceptionHandler
    public ResponseEntity<ToyIncorrectData> handleException (
            NoSuchToyException exception) {
        ToyIncorrectData data = new ToyIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
