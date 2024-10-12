package com.example.mutantes_castillo.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Definimos la anotación de validación
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DnaValidator.class)
public @interface ValidDna {

    // Mensaje por defecto si la validación falla
    String message() default "La secuencia de ADN es inválida. Debe ser cuadrada, contener solo A, T, C, G y no estar vacía.";

    // Grupos para aplicar la validación
    Class<?>[] groups() default {};

    // Para pasar información adicional sobre la validación
    Class<? extends Payload>[] payload() default {};
}
