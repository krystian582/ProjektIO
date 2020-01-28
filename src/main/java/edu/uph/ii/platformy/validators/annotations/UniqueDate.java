package edu.uph.ii.platformy.validators.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueDateValidator.class)
public @interface UniqueDate {
    String message() default "username not unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
