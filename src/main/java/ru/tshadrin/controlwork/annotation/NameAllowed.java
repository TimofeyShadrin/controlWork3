package ru.tshadrin.controlwork.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameAllowedValidator.class)
public @interface NameAllowed {
    String[] names();
    String message() default "The entered name is not allowed. You can use them: {names}.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
