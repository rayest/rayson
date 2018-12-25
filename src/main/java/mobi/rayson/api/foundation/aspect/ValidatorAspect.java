package mobi.rayson.api.foundation.aspect;

import mobi.rayson.api.foundation.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Aspect
@Component
public class ValidatorAspect {
  @Before("execution(* *(@org.springframework.web.bind.annotation.RequestBody *,..))||execution(* *(@org.springframework.web.bind.annotation.RequestBody (*),..,..))")
  public void validateBodyParams(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    for (Object arg : args) {
      if (arg != null && !(arg instanceof String) && !(arg instanceof Integer)) {
        Set<ConstraintViolation<Object>> constraintViolations = getValidator().validate(arg);
        if (constraintViolations.size() > 0) {
          throw new BusinessException(constraintViolations.iterator().next().getMessage());
        }
      }
    }
  }

  private Validator getValidator() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    return factory.getValidator();
  }
}
