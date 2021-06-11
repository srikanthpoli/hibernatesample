//package com.srikanth.hibernatetutorial.config;
//
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//@Configuration
//@Transactional
//public class Test {
//
//
//    @Autowired
//    @Qualifier("sessionFactory")
//    private LocalSessionFactoryBean localSessionFactoryBean;
//
//    @Bean("mySession")
//    public Session createSessiion(){
//       return localSessionFactoryBean.getObject().getCurrentSession();
//    }
//
//}
