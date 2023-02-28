package validations;

import com.investec.assessment.models.UserModel;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class FindUserModelValidator implements Validator {


  @Override
  public boolean supports(Class<?> clazz) {

      return UserModel.class.equals(clazz);

  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idNumber", "field.required" );
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "field.required" );
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required" );
  }
}
