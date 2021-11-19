package br.com.bldapigateway.validator;

import br.com.bldapigateway.exceptions.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Utility class to validate generic operations.
 */
@Slf4j
public class ValidatorException {

	private ValidatorException() {
	}

	/**
	 * Validates if the login is being used.
	 *
	 * @return {@link ValidationException} if the field is duplicated
	 */
	public static ValidationException newException(final String objectName, final String field, final String defaultMessage) {
		final List<FieldError> errors = new ArrayList<>();
		final FieldError error = new FieldError(objectName, field, defaultMessage);
		errors.add(error);
		final ValidationException ex = new ValidationException(defaultMessage, errors);
		log.warn("Validation failed: {} field {}", defaultMessage, field);
		return ex;
	}
	
	/**
	 * Validates if the login is being used.
	 *
	 * @return {@link ValidationException} if the field is duplicated
	 */
	public static ValidationException newException(final String defaultMessage) {
		final ValidationException ex = new ValidationException(
				defaultMessage,
				Collections.singletonList(new FieldError(StringUtils.EMPTY, StringUtils.EMPTY, defaultMessage))
		);
		log.warn("Validation failed: {}", defaultMessage);
		return ex;
	}
	
	/**
	 * Validates if the login is being used.
	 *
	 * @return {@link ValidationException} if the field is duplicated
	 */
	public static ValidationException newException(final List<FieldError> errors, final String defaultMessage) {
		final ValidationException ex = new ValidationException(defaultMessage, errors);
//		log.warn("Validation failed: {}", defaultMessage);
		return ex;
	}
	
	/**
	 * Validates if the login is being used.
	 *
	 * @return {@link ValidationException} if the field is duplicated
	 */
	public static ValidationException duplicatedNameException() {
		final List<FieldError> errors = new ArrayList<>();
		final FieldError error = new FieldError("vo", "Nome", "Registro já existe");
		errors.add(error);
		return new ValidationException("Nome não é válido", errors);
	}
	
	/**
	 * Validates .
	 *
	 * @return {@link ValidationException} 
	 */
	public static ValidationException newException(final List<ObjectError> objectErrors) {
		final List<FieldError> errors = new ArrayList<>();
		
		for (ObjectError objectError : objectErrors) {
			if (objectError instanceof FieldError) {
				errors.add((FieldError) objectError);
			} else {
				final FieldError error = new FieldError(objectError.getObjectName(),
						StringUtils.EMPTY,
						Optional.ofNullable(objectError.getDefaultMessage()).orElse(StringUtils.EMPTY));
				errors.add(error);
			}
		}
		
		final ValidationException ex = new ValidationException("default", errors);
//		log.warn("ERROR while validating: ", ex);
		return ex;
	}

}
