package hibernatevaild;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;




@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
//@Repeatable(javax.validation.constraints.NotNull.List.class)
@Documented
@Constraint(validatedBy = { })
public @interface ValidPart {

    String message() default "{javax.validation.constraints.NotNull.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    /**
     * Defines several {@link javax.validation.constraints.NotNull} annotations on the same element.
     *
     * @see javax.validation.constraints.NotNull
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        javax.validation.constraints.NotNull[] value();
    }
}



