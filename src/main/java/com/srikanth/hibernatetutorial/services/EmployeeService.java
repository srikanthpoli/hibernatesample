package com.srikanth.hibernatetutorial.services;

import com.srikanth.hibernatetutorial.entities.onetoone.EmployeeEntity;
import com.srikanth.hibernatetutorial.untils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
@Slf4j
@Service("employeeService")
@Transactional
public class EmployeeService {

    @Autowired
    @Qualifier("sessionFactory")
    private LocalSessionFactoryBean localSessionFactoryBean;

    public EmployeeEntity getEmployeeByID(int id) {
        EmployeeEntity employeeEntity= localSessionFactoryBean.getObject().getCurrentSession()
                .get(EmployeeEntity.class, id);
       if(id==2) {
           throw new RuntimeException();
       }
        return  employeeEntity;
    }

    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) throws ParseException {
        Date date= DateUtils.parseDate("31/12/2020");
        employeeEntity.setDoj( new java.sql.Date(date.getTime()) );
        localSessionFactoryBean.getObject().getCurrentSession().save(employeeEntity);
        return employeeEntity;
    }

    public EmployeeEntity deleteEmployeeByID(int id) {
        EmployeeEntity employeeEntity= localSessionFactoryBean.getObject().getCurrentSession().get(EmployeeEntity.class,id);
        localSessionFactoryBean.getObject().getCurrentSession().delete(employeeEntity);
        return employeeEntity;
    }

    public List<EmployeeEntity>     getEmployeesByCompany(String company) {

        return localSessionFactoryBean.getObject().getCurrentSession()
                .createQuery("from EmployeeEntity s where s.company=" + "'"+company+"'").getResultList();

    }
}
