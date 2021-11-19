package br.com.bldapigateway.validator;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.ValidationException;

@Slf4j
public class EntityValidator {

    /**
     * Validates if the object's is registered.
     *
     * @return {@link javax.validation.ValidationException} if the object does not exists
     */

    public static ValidationException customException(String message){
        return new ValidationException(message);
    }

}
