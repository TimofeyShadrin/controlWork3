package ru.tshadrin.controlwork.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameAllowedValidator implements ConstraintValidator<NameAllowed, String> {
    private Set<String> names;
    @Override
    public void initialize(NameAllowed constraintAnnotation) {
        names = Stream.of(constraintAnnotation.names())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return names.contains(value);
    }
}
