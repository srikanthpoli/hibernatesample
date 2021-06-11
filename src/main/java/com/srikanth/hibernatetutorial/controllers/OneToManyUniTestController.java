package com.srikanth.hibernatetutorial.controllers;

import com.srikanth.hibernatetutorial.entities.onetomanyuni.OneToManyUni_CourseEntity;
import com.srikanth.hibernatetutorial.services.OneToManyService;
import com.srikanth.hibernatetutorial.services.OneToManyUni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/onetomanyuni")
public class OneToManyUniTestController {
    @Autowired
    OneToManyUni oneToManyUni;

    @RequestMapping(value = "/course",method = RequestMethod.POST)
    public void insertCourse()
    {
        oneToManyUni.createCourse();
    }

    @RequestMapping(value = "/course",method = RequestMethod.GET)
    public OneToManyUni_CourseEntity getCourse()
    {
       return oneToManyUni.getCourse();
    }
    @RequestMapping(value = "/course",method = RequestMethod.DELETE)
    public void deletCourse()
    {
         oneToManyUni.deleteCourse();
    }

}

