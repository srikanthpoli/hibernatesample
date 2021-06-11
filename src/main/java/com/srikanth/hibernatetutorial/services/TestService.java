//package com.srikanth.hibernatetutorial.services;
//
//import com.srikanth.hibernatetutorial.entities.entities.onetoone.InstructorDetailEntity;
//import com.srikanth.hibernatetutorial.entities.entities.onetoone.InstructorEntity;
//import com.srikanth.hibernatetutorial.entities.entities.onetoone.StudentEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Component
//
//
//public class TestService {
//    @Autowired
//    @Qualifier("sessionFactory")
//    private LocalSessionFactoryBean localSessionFactoryBean;
//
//    @Transactional
//    public void createStudent() {
//        StudentEntity studentEntity = new StudentEntity("Srikanth", "Polise", "sri.as@gmail.com");
//        localSessionFactoryBean.getObject().getCurrentSession().save(studentEntity);
//        System.out.println("Generated Key--" + studentEntity.getId());
//
//    }
//
//    @Transactional
//    public List<StudentEntity> getStudentList() {
//        return localSessionFactoryBean.getObject().getCurrentSession().createQuery("from StudentEntity ").list();
//    }
//
//    @Transactional
//    public void updateStudentQuery() {
//        localSessionFactoryBean.getObject().getCurrentSession().
//                createQuery("update StudentEntity s set s.firstName='Srikanth Poli' ").executeUpdate();
//    }
//
//    @Transactional
//    public StudentEntity getStudentLByID(int id) {
////        StudentEntity studentEntity = localSessionFactoryBean.getObject().getCurrentSession().get(StudentEntity.class, id);
////        studentEntity.setEmail("Test");
////        localSessionFactoryBean.getObject().getCurrentSession().save(studentEntity);
//        return localSessionFactoryBean.getObject().getCurrentSession().get(StudentEntity.class, id);
//    }
//
//    @Transactional
//    public List<StudentEntity> getStudentLByName() {
//        return localSessionFactoryBean.getObject().getCurrentSession()
//                .createQuery("from StudentEntity s where s.firstName like '%sri%'").getResultList();
//    }
//
//    @Transactional
//    public void deleteStudentLByID(int id) {
//        StudentEntity studentEntity = localSessionFactoryBean.getObject().getCurrentSession().get(StudentEntity.class, id);
//        localSessionFactoryBean.getObject().getCurrentSession().delete(studentEntity);
//    }
//    @Transactional
//    public void insertInstructor(InstructorEntity instructorEntity) {
////        InstructorDetailEntity instructorDetailEntity= new InstructorDetailEntity("Indu Channel",
////                "Chess"
////        );
////        instructorEntity.setInstructorDetailEntity(instructorDetailEntity);
//
//        localSessionFactoryBean.getObject().getCurrentSession().save(instructorEntity);
//        System.out.println(instructorEntity);
//    }
//
//    @Transactional
//    public InstructorEntity getInstructorByID(int instructorID) {
//      return localSessionFactoryBean.getObject().getCurrentSession()
//                .get(InstructorEntity.class,instructorID);
//
//    }
//    @Transactional
//    public void deleteInstrctorByID(int instructorID) {
//        InstructorEntity instructorEntity=localSessionFactoryBean.getObject().getCurrentSession()
//                .get(InstructorEntity.class,instructorID);
//     localSessionFactoryBean.getObject().getCurrentSession().delete(instructorEntity);
//    }
//    @Transactional
//    public InstructorDetailEntity getInstructorDetailID(int id) {
//        InstructorDetailEntity instructorDetailEntity=localSessionFactoryBean.getObject().getCurrentSession()
//                .get(InstructorDetailEntity.class,id);
////        System.out.println(instructorDetailEntity);
////        System.out.println(instructorDetailEntity.getInstructorEntity());
//        return  instructorDetailEntity;
//    }
//
//    @Transactional
//    public void deleteInstructorDetailID(int id) {
//        InstructorDetailEntity instructorDetailEntity=localSessionFactoryBean.getObject().getCurrentSession()
//                .get(InstructorDetailEntity.class,id);
//        instructorDetailEntity.getInstructorEntity().setInstructorDetailEntity(null);
//        localSessionFactoryBean.getObject().getCurrentSession().delete(instructorDetailEntity);
//
//    }
//
//}
