//package com.srikanth.hibernatetutorial.entities.entities.onetoone;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "instructor", schema = "", catalog = "`hb-01-one-to-one-uni`")
//public class InstructorEntity {
//    private int id;
//    private String firstName;
//    private String lastName;
//    private String email;
//
//    private InstructorDetailEntity instructorDetailEntity;
//
//    public InstructorEntity() {
//    }
//
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    @Basic
//    @Column(name = "first_name")
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    @Basic
//    @Column(name = "last_name")
//    public String getLastName() {
//        return lastName;
//    }
//
//    @ManyToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name="instructor_detail_id")
//   @JsonBackReference
//    public InstructorDetailEntity getInstructorDetailEntity() {
//        return instructorDetailEntity;
//    }
//
//    public void setInstructorDetailEntity(InstructorDetailEntity instructorDetailEntity) {
//        this.instructorDetailEntity = instructorDetailEntity;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    @Basic
//    @Column(name = "email")
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public InstructorEntity(String firstName,String lastName,String email) {
//        this.firstName=firstName;
//        this.email=email;
//        this.lastName=email;
//    }
//
//    @Override
//    public String toString() {
//        return "InstructorEntity{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
//}
