package validations;

import com.investec.assessment.models.UserModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserModelValidator implements Validator {

  private static final String SA_ID_REGEX = "/^(((\\d{2}((0[13578]|1[02])(0[1-9]|[12]\\d|3[01])|(0[13456789]|1[012])(0[1-9]|[12]\\d|30)|02(0[1-9]|1\\d|2[0-8])))|([02468][048]|[13579][26])0229))(( |-)(\\d{4})( |-)(\\d{3})|(\\d{7}))/";
  @Override
  public boolean supports(Class<?> clazz) {
    return UserModel.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idNumber", "field.required" );
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber", "field.required" );

    UserModel userModel = (UserModel) target;
    Pattern pattern = Pattern.compile(SA_ID_REGEX);

    Matcher matcher = pattern.matcher(userModel.getIdNumber());
    if (!matcher.matches()){
      errors.rejectValue("idNumber","invalid.sa.id");
    }
  }
}
