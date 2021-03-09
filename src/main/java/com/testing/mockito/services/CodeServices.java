package com.testing.mockito.services;

import com.testing.mockito.exceptions.CustomException;
import org.springframework.stereotype.Service;

@Service
public class CodeServices {

    public boolean checkCode(String code) throws CustomException {

        if(!stringHaveOnlyDigits(code)){
            throw new CustomException("Exception name");
        }

        if(stringNotHave0Number(code)){
            throw new CustomException("Exception name");
        }

        return true;
    }

    private boolean stringNotHave0Number(String code) {
        return code.contains("0");
    }

    private boolean stringHaveOnlyDigits(String string) {
        return string.chars().allMatch(Character::isDigit);
    }

}
