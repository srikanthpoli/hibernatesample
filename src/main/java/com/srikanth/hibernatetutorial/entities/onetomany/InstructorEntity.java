package com.srikanth.hibernatetutorial.entities.onetomany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor", schema = "", catalog = "`hb-03-one-to-many`")
public class InstructorEntity {
    private int id;

    public InstructorEntity(String firstName,String lastName,String email) {
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    private String firstName;
    private String lastName;
    private String email;
    private InstructorDetailEntity instructorDetailEntity;
    private List<CourseEntity> courseEntity;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    public InstructorDetailEntity getInstructorDetailEntity() {
        return instructorDetailEntity;
    }

    public void setInstructorDetailEntity(InstructorDetailEntity instructorDetailEntity) {
        this.instructorDetailEntity = instructorDetailEntity;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "instructorEntity",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH})
    @JsonBackReference
    public List<CourseEntity> getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(List<CourseEntity> courseEntity) {
        this.courseEntity = courseEntity;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public InstructorEntity() {
    }

    public void add(CourseEntity tempCourse){
        if (courseEntity==null){
            courseEntity= new ArrayList<>();
        }

        courseEntity.add(tempCourse);
        tempCourse.setInstructorEntity(this);
    }
}
