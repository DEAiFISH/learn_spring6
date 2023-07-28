package com.DEAiFISH.validator.two;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 原生校验器
 */
@Service
public class MyValidation1 {
    @Autowired
    private Validator validator;

    public boolean validatorByUser(User user){
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        return validate.isEmpty();
    }
}
