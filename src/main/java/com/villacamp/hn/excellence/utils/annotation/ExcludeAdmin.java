package com.villacamp.hn.excellence.utils.annotation;

import com.villacamp.hn.excellence.utils.validator.UserRoleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UserRoleValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcludeAdmin {
    String message() default "Role cannot be ADM";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
