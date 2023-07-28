package com.DEAiFISH.validator.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

/**
 * Spring校验器
 */
@Service
public class MyValidation2 {
    @Autowired
    private Validator validator;

    public boolean validatorByUser(User user) {
        BindException bindException = new BindException(user, user.getName());
        validator.validate(user, bindException);
        return bindException.hasErrors();
    }
}
