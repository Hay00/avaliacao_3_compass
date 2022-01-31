package com.compass.avaliacao3.config.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class RegionValidation implements ConstraintValidator<Region, String> {

    List<String> allowedStates = List.of("Norte", "Nordeste", "Centro-Oeste", "Sudeste", "Sul");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        return allowedStates.contains(s);
    }

    @Override
    public void initialize(Region constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
