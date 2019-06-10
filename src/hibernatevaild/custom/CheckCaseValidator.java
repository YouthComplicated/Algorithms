package hibernatevaild.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CheckCaseValidator implements ConstraintValidator<CheckCase,
        String> {

    private CaseMode caseMode;
    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.value();
    }
    @Override
    public boolean isValid(String object, ConstraintValidatorContext
            constraintContext) {
        if ( object == null ) {
            return true;
        }
        boolean isVaild;
        if ( caseMode == CaseMode.UPPER ) {
            isVaild =  object.equals( object.toUpperCase() );
        }
        else {
            isVaild =  object.equals( object.toLowerCase() );
        }

        if(!isVaild){
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("aa.template")
                    .addConstraintViolation();
        }

        return isVaild;

    }
}