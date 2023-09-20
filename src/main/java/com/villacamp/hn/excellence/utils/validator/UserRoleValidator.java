package com.villacamp.hn.excellence.utils.validator;

import com.villacamp.hn.excellence.utils.annotation.ExcludeAdmin;
import com.villacamp.hn.excellence.utils.enums.Role;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserRoleValidator implements ConstraintValidator<ExcludeAdmin, Role> {
    @Override
    public void initialize(ExcludeAdmin constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Role role, ConstraintValidatorContext constraintValidatorContext) {
        return role != Role.ADM;
    }
}
