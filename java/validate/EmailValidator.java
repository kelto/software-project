/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author kelto
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private static String PATTERN = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    Pattern pattern;
    Matcher matcher;
    
    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        pattern = Pattern.compile(PATTERN,Pattern.CASE_INSENSITIVE);
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        matcher = pattern.matcher(value);
        return matcher.matches();
    }
}