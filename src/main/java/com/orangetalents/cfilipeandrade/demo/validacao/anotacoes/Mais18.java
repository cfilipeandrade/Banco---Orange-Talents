package com.orangetalents.cfilipeandrade.demo.validacao.anotacoes;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.orangetalents.cfilipeandrade.demo.validacao.validadores.Mais18Validator;

@Documented
@Constraint(validatedBy = Mais18Validator.class)
@Target({ ElementType.FIELD })
@Retention (RetentionPolicy.RUNTIME)
public @interface Mais18 {

    String message() default "{com.orangetalents.cfilipeandrade.demo.validacao.anotacoes.Mais18}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}
