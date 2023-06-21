package com.salary.salary.Stream;

import com.salary.salary.Stream.exceptions.incorrectNameException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    public String validateName(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new incorrectNameException();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }

    public String validateSurname(String surname) {
        String[] surnames = surname.split("-");
        for (int i = 0; i < surnames.length; i++) {
            if (!StringUtils.isAlpha(surnames[i])) {
                throw new incorrectNameException();
            }
            surnames[i] = StringUtils.capitalize(surname.toLowerCase());
        }
        return String.join("-", surnames);
    }
}
