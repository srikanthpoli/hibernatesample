package com.srikanth.hibernatetutorial.controllers;

import com.srikanth.hibernatetutorial.services.OneToManyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/onetomany")
public class OneToManyTestController {
    @Autowired
    OneToManyService oneToManyService;

    @RequestMapping(value = "/instructor",method = RequestMethod.POST)
    public void insertInstructor()
    {
        oneToManyService.insertInstructor();
    }
    @RequestMapping(value = "/course",method = RequestMethod.POST)
    public void addCourse()
    {
        oneToManyService.addCouruse();
    }

    @RequestMapping(value = "/instructor",method = RequestMethod.GET)
    public void getInstructor()
    {
        oneToManyService.getInstructor();
    }

    @RequestMapping(value = "/course",method = RequestMethod.DELETE)
    public void deleteCourse()
    {
         oneToManyService.deleteCourse();
    }
    @RequestMapping(value = "/course",method = RequestMethod.GET)
    public void getCourse()
    {
        oneToManyService.getCourse();
    }

}

