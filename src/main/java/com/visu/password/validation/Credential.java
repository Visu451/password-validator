package com.visu.password.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = CredentialValidator.class)
public @interface Credential {
    String message() default "The passowrd must not contain any sequence of characters immediately followed by the same sequence";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
