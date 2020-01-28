package edu.uph.ii.platformy.validators.annotations;

import edu.uph.ii.platformy.services.UserService;
import edu.uph.ii.platformy.services.WizytaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class UniqueDateValidator implements ConstraintValidator<UniqueDate, Date> {

    @Autowired(required = false)
    private WizytaService wizytaService;

    public void initialize(UniqueUsername constraint) {
    }

    public boolean isValid(Date date, ConstraintValidatorContext context) {
        return wizytaService == null || (date != null && wizytaService.isUniqueDate(date));
    }

}