package com.business.rrhh.module.employee.controller.validations;

import com.business.rrhh.module.employee.SystemPensionType;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(NotNullDependsOn.List.class)
@Constraint(validatedBy = NotNullDependsOnValidator.class)
public @interface NotNullDependsOn {

    String fieldName();

    String fieldValue();

    String dependFieldName();

    String message() default "{NotNullDependsOn.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        NotNullDependsOn[] value();
    }
}
