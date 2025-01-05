package com.tka.Advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class TimeAdvice {

    @Before("execution (* com.tka.controller.*.*(..))")
    public void stateDate(){
        //! The below code is good but doesn't give the data in ddmmyyyy format to do that we need simpleDateFormat class
//        System.err.println("Date : "+ new java.util.Date());

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String format1 = format.format(new Date());

        System.err.println("Executed at :"+format1);
    }
}
