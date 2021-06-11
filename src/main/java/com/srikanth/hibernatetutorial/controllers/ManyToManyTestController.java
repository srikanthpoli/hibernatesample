package com.srikanth.hibernatetutorial.controllers;

import com.srikanth.hibernatetutorial.entities.onetomanyuni.OneToManyUni_CourseEntity;
import com.srikanth.hibernatetutorial.services.ManyToMany;
import com.srikanth.hibernatetutorial.services.OneToManyUni;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manytomany")
public class ManyToManyTestController {
    @Autowired
    ManyToMany manyToMany;

    @RequestMapping(value = "/stuentcourse",method = RequestMethod.POST)
    public void insertStudent()
    {
        manyToMany.createCourseStudent();
    }
    @RequestMapping(value = "/stuentcourse",method = RequestMethod.GET)
    public void getStudentCourse()
    {
        manyToMany.getStudents();
    }

    @RequestMapping(value = "/stuentcourse",method = RequestMethod.DELETE)
    public void deleteStudentCourse()
    {
        manyToMany.deleteCourse();
    }

    @RequestMapping(value = "/stuent",method = RequestMethod.DELETE)
    public void deleteStudent()
    {
        manyToMany.deleteStudent();
    }



}

