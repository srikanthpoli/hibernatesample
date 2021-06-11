package com.srikanth.hibernatetutorial.services;

import com.srikanth.hibernatetutorial.entities.onetomany.CourseEntity;
import com.srikanth.hibernatetutorial.entities.onetomany.InstructorDetailEntity;
import com.srikanth.hibernatetutorial.entities.onetomany.InstructorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service

@Transactional
public class OneToManyService {

    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;

    public void insertInstructor() {
        InstructorEntity instructorEntity = new
                InstructorEntity("Srikanth", "Polisetty", "sri.polisettys@gmail.com");
        InstructorDetailEntity instructorDetailEntity =
                new InstructorDetailEntity("Study CHannel", "Reading");
        instructorEntity.setInstructorDetailEntity(instructorDetailEntity);
        CourseEntity courseEntity= new CourseEntity("SOcial");
        instructorEntity.add(courseEntity);
        courseEntity= new CourseEntity("JAVA");
        instructorEntity.add(courseEntity);


        localSessionFactoryBean.getObject().getCurrentSession().save(instructorEntity);
    }

    public void addCouruse() {
        InstructorEntity instructorEntity = localSessionFactoryBean.getObject().getCurrentSession().get(InstructorEntity.class,2);
        CourseEntity courseEntity= new CourseEntity("SOcial");
        instructorEntity.add(courseEntity);
        localSessionFactoryBean.getObject().getCurrentSession().save(courseEntity);
        courseEntity= new CourseEntity("JAVA");
        instructorEntity.add(courseEntity);
        localSessionFactoryBean.getObject().getCurrentSession().save(courseEntity);



    }

    public InstructorEntity getInstructor() {
       InstructorEntity instructorEntity=
                localSessionFactoryBean.getObject().getCurrentSession().get(InstructorEntity.class,2);
       instructorEntity.getInstructorDetailEntity();

        instructorEntity.getCourseEntity();
       return instructorEntity;


    }


    public void getCourse() {

        CourseEntity c= localSessionFactoryBean.getObject().getCurrentSession().get(CourseEntity.class,13);

    }

    public void deleteCourse() {

               CourseEntity c= localSessionFactoryBean.getObject().getCurrentSession().get(CourseEntity.class,13);
               localSessionFactoryBean.getObject().getCurrentSession().delete(c);


    }}
