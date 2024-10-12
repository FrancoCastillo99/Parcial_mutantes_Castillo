package com.example.mutantes_castillo.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

public class DnaValidator implements ConstraintValidator<ValidDna, List<String>> {

    @Override
    public void initialize(ValidDna constraintAnnotation) {
        // No se necesita inicialización especial
    }

    @Override
    public boolean isValid(List<String> dna, ConstraintValidatorContext context) {
        // Verificar que la lista no sea nula
        if (dna == null) {
            context.buildConstraintViolationWithTemplate("La matriz de ADN no puede ser nula.")
                    .addConstraintViolation();
            return false;
        }

        // Verificar que la lista no esté vacía
        if (dna.isEmpty()) {
            context.buildConstraintViolationWithTemplate("La matriz de ADN no puede estar vacía.")
                    .addConstraintViolation();
            return false;
        }

        int n = dna.size();  // Número de filas

        // Verificar que cada secuencia de ADN no sea nula y que tenga la longitud correcta
        for (String sequence : dna) {
            if (sequence == null) {
                context.buildConstraintViolationWithTemplate("Una de las secuencias de ADN es nula.")
                        .addConstraintViolation();
                return false;
            }

            if (sequence.isEmpty()) {
                context.buildConstraintViolationWithTemplate("Una de las secuencias de ADN está vacía.")
                        .addConstraintViolation();
                return false;
            }

            if (sequence.length() != n) {
                context.buildConstraintViolationWithTemplate("La matriz de ADN debe ser cuadrada. Fila " + sequence + " tiene longitud " + sequence.length() + ", pero se esperaban " + n + ".")
                        .addConstraintViolation();
                return false;
            }

            if (!sequence.matches("[ATCG]+")) {
                context.buildConstraintViolationWithTemplate("La secuencia '" + sequence + "' contiene caracteres no válidos.")
                        .addConstraintViolation();
                return false;
            }
        }
        return true;
    }
}
