package com.compass.avaliacao3.config.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RegionValidation.class)
public @interface Region {
    static List<String> allowedStates = List.of("Norte", "Nordeste", "Centro-Oeste", "Sudeste", "Sul");

    String message() default "Região inválida, as válidas são: Norte, Nordeste, Centro-Oeste, Sudeste e Sul)";

    Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default {};
}
