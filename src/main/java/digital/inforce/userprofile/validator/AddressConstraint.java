package digital.inforce.userprofile.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = AddressValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AddressConstraint {
    String message() default "Please, enter valid address. Example: Svobody Ave, 28, Lviv, Lviv Oblast, 79000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
