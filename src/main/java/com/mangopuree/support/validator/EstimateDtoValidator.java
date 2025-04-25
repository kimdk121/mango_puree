package com.mangopuree.support.validator;

import com.mangopuree.estimate.dto.EstimateInsertDto;
import jakarta.validation.ConstraintViolation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

/**
 * 견적서 Bean Validation 수동 검증
 */
@Component
public class EstimateDtoValidator implements Validator {

    private final jakarta.validation.Validator validator;

    public EstimateDtoValidator(jakarta.validation.Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return EstimateInsertDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        EstimateInsertDto estimateInsertDto = (EstimateInsertDto) target;

        Set<ConstraintViolation<Object>> violations = validator.validate(target);

        for (ConstraintViolation<Object> violation : violations) {
            String fieldName = violation.getPropertyPath().toString();
            String messageCode = violation.getMessageTemplate().replaceAll("[{}]", "").split("\\.")[3];
            errors.rejectValue(fieldName, messageCode);
        }

    }
}
