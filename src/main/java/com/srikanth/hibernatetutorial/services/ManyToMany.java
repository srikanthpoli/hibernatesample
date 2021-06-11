package com.srikanth.hibernatetutorial.services;

import com.srikanth.hibernatetutorial.config.Count;
import com.srikanth.hibernatetutorial.entities.manytomany.ManyToManyUni_CourseEntity;
import com.srikanth.hibernatetutorial.entities.manytomany.ManyToManyUni_StudentEntity;
import com.srikanth.hibernatetutorial.entities.onetomanyuni.OneToManyUni_CourseEntity;
import com.srikanth.hibernatetutorial.entities.onetomanyuni.OneToManyUni_ReviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ManyToMany {
    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;

    public void createCourseStudent() {

        ManyToManyUni_StudentEntity manyToManyUni_studentEntity
                = new ManyToManyUni_StudentEntity("Srikanth","Polisetty","sri.poli");
        ManyToManyUni_StudentEntity manyToManyUni_studentEntity2
                = new ManyToManyUni_StudentEntity("Imdu","Polisetty","Indu");


        ManyToManyUni_CourseEntity manyToManyUni_courseEntity= new ManyToManyUni_CourseEntity("Java");
        ManyToManyUni_CourseEntity manyToManyUni_courseEntity2= new ManyToManyUni_CourseEntity("SalesForce");
        localSessionFactoryBean.getObject().getCurrentSession().save(manyToManyUni_courseEntity);
        localSessionFactoryBean.getObject().getCurrentSession().save(manyToManyUni_courseEntity2);
        manyToManyUni_studentEntity.addCourse(manyToManyUni_courseEntity);
        manyToManyUni_studentEntity.addCourse(manyToManyUni_courseEntity2);
        manyToManyUni_studentEntity2.addCourse(manyToManyUni_courseEntity);
        manyToManyUni_studentEntity2.addCourse(manyToManyUni_courseEntity2);
        localSessionFactoryBean.getObject().getCurrentSession().save(manyToManyUni_studentEntity);
        localSessionFactoryBean.getObject().getCurrentSession().save(manyToManyUni_studentEntity2);
    }

    public void getStudents() {
       ManyToManyUni_StudentEntity manyToManyUni_studentEntity= localSessionFactoryBean.getObject().getCurrentSession().get(ManyToManyUni_StudentEntity.class,15);
       System.out.println( manyToManyUni_studentEntity.getCourseEntityList());

    }

    public void deleteCourse(){
        ManyToManyUni_CourseEntity courseEntity=
                localSessionFactoryBean
                .getObject()
                .getCurrentSession()
                .get(ManyToManyUni_CourseEntity.class,18);
        localSessionFactoryBean
                .getObject()
                .getCurrentSession()
                .delete(courseEntity);

    }

    public void deleteStudent() {

        ManyToManyUni_StudentEntity studentEntity=
                localSessionFactoryBean
                        .getObject()
                        .getCurrentSession()
                        .get(ManyToManyUni_StudentEntity.class,15);
        localSessionFactoryBean
                .getObject()
                .getCurrentSession()
                .delete(studentEntity);
    }
}
