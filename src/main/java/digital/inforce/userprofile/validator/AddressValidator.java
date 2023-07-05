package digital.inforce.userprofile.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddressValidator
    implements ConstraintValidator<AddressConstraint, String> {

    @Override
    public void initialize(AddressConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String addressField,
        ConstraintValidatorContext constraintValidatorContext) {
        return addressField.matches(
            "^([\\w\\s]+),\\s([\\w\\d-]+),\\s([\\w\\s]+),\\s([\\w\\s]+),\\s([A-Z\\d\\s-]{2,10})$");
    }
}
