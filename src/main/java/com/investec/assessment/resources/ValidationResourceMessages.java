package com.investec.assessment.resources;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import validations.FindUserModelValidator;
import validations.UserModelValidator;

public class ValidationResourceMessages<T> {

  private T objectTobeValidated;

  public ValidationResourceMessages(T objectTobeValidated) {
    this.objectTobeValidated = objectTobeValidated;
  }

  public List<ObjectError> loadMessages(Class validator) throws Exception {
    List<ObjectError> errorMessages = new ArrayList<ObjectError>();
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("validationMessages");


    BeanPropertyBindingResult result = new BeanPropertyBindingResult(objectTobeValidated,
        objectTobeValidated.toString());
    switch (objectTobeValidated.toString()) {
      case "FindUserModelValidator" ->
          ValidationUtils.invokeValidator(new FindUserModelValidator(), objectTobeValidated,
              result);
      case "UserModelValidator" ->
          ValidationUtils.invokeValidator(new UserModelValidator(), objectTobeValidated, result);
      default -> throw new Exception("Unknown Constructor");
    }

    List<ObjectError> allErrors = result.getAllErrors();
    if (!allErrors.isEmpty()) {
      errorMessages.addAll(allErrors);

    }

    return errorMessages;
  }

}
