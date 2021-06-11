package com.srikanth.hibernatetutorial.services;

import com.srikanth.hibernatetutorial.config.Count;
import com.srikanth.hibernatetutorial.entities.onetomany.CourseEntity;
import com.srikanth.hibernatetutorial.entities.onetomanyuni.OneToManyUni_CourseEntity;
import com.srikanth.hibernatetutorial.entities.onetomanyuni.OneToManyUni_ReviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OneToManyUni {
    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;

    public void createCourse() {

        OneToManyUni_CourseEntity courseEntity=new OneToManyUni_CourseEntity("Java Couse"+ ++Count.count);

            courseEntity.addReview(new OneToManyUni_ReviewEntity("This is gReat"));
        courseEntity.addReview(new OneToManyUni_ReviewEntity("This is Awesone"));
        courseEntity.addReview(new OneToManyUni_ReviewEntity("GoodContent"));
        localSessionFactoryBean.getObject().getCurrentSession().save(courseEntity);

    }

    public OneToManyUni_CourseEntity getCourse() {
        OneToManyUni_CourseEntity courseEntity=

        localSessionFactoryBean.getObject().getCurrentSession().get(OneToManyUni_CourseEntity.class,10);
      System.out.println(  courseEntity.getReviewEntityList());
      return  courseEntity;


    }
    public void deleteCourse() {
        OneToManyUni_CourseEntity courseEntity=

                localSessionFactoryBean.getObject().getCurrentSession().get(OneToManyUni_CourseEntity.class,10);
       localSessionFactoryBean.getObject().getCurrentSession().delete(courseEntity);

    }
}
