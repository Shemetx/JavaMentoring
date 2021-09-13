package com.epam.homework.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
public class EntityValidation {

    private final  ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    private final  Validator validator = vf.getValidator();

    public EntityValidation() {
    }

    public  void validate(Object object) {
        Set<ConstraintViolation<Object>> constraintViolations = validator
                .validate(object);

        System.out.printf("Number of mistakes: %d%n",
                constraintViolations.size());

        for (ConstraintViolation<Object> cv : constraintViolations)
            System.out.printf(
                    "Warning, mistake! property: [%s], value: [%s], message: [%s]%n",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage());
    }
}
