package com.srikanth.hibernatetutorial.config;


import com.srikanth.hibernatetutorial.entities.onetoone.EmployeeEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import  com.srikanth.hibernatetutorial.services.*;
@Component
@Aspect
@Slf4j
@Order(1)
public class MyLoggingAspect {

    @Pointcut("execution(*  com.srikanth.hibernatetutorial.services.EmployeeService.*(..))")
    public void forEmployeeServiceALL(){}

    @Pointcut("execution(*  com.srikanth.hibernatetutorial.services.EmployeeService.get*(..))")
    public void forEmployeeServiceGet(){}

    @Pointcut("forEmployeeServiceALL() && !forEmployeeServiceGet()")
    public void forEmployeeServiceALLExceptGet(){

    }
    @Pointcut("execution(*  com.srikanth.hibernatetutorial.services.EmployeeService.getEmployeesByCompany(..))")
    public void forGetEmployeeByCompany(){

    }

    @AfterReturning(pointcut = "(forEmployeeServiceGet())",returning = "result")
    public void afterReturnCall(EmployeeEntity result){
        result.setFirstName("Modified Name");
        log.info("Method Result- "+ result.getFirstName());
    }



    @Around( "(forGetEmployeeByCompany())")
    public Object aroundAsepect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Object result=proceedingJoinPoint.proceed();
        log.info("Around Result- ");
        return result;

    }

    @AfterThrowing(pointcut = "(forEmployeeServiceGet())",throwing = "excep")
    public void afterThrowReturnCall(Exception excep){

        log.info("Method Result- "+ excep);
    }

    @Before("forEmployeeServiceALLExceptGet()")
    public void beforeAddEmployee(JoinPoint joinPoint){
        log.info("Employee Services called for both update amc create");
        log.info("Method Signature- "+ (MethodSignature)joinPoint.getSignature());
        log.info("Method Args- "+((EmployeeEntity)joinPoint.getArgs()[0]).getDoj());
    }
}
