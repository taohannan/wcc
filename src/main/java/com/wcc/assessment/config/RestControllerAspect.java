package com.wcc.assessment.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

    private static final Logger log = LoggerFactory.getLogger(RestControllerAspect.class);

//    @Before("execution(* com.wcc.assessment.web.rest.*(..))")
    @Before(" within(@org.springframework.web.bind.annotation.RestController *)")
    public void executeRestRequestLogging(JoinPoint joinPoint) {
        log.info(" Request for {} with argument {}", joinPoint.toString(), joinPoint.getArgs());
    }

    @AfterReturning(value = " within(@org.springframework.web.bind.annotation.RestController *)",returning = "result")
    public void responseObject(JoinPoint joinPoint, Object result) {
        ObjectMapper mapper = new ObjectMapper();
        log.info(" Response for {} with argument {}", joinPoint.toString(), result.toString());
    }
}
