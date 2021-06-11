package com.srikanth.hibernatetutorial.entities.onetomanyuni;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "instructor", schema = "", catalog = "`hb-04-one-to-many-uni`")
public class OneToManyUni_InstructorEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private OneToManyUni_InstructorDetailEntity instructorDetailEntity;
    private List<OneToManyUni_CourseEntity> courseEntityList;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instructorEntity" ,cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH})
    @JsonBackReference
    public List<OneToManyUni_CourseEntity> getCourseEntityList() {
        return courseEntityList;
    }

    public void setCourseEntityList(List<OneToManyUni_CourseEntity> courseEntityList) {
        this.courseEntityList = courseEntityList;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    public OneToManyUni_InstructorDetailEntity getInstructorDetailEntity() {
            return instructorDetailEntity;
        }

    public void setInstructorDetailEntity(OneToManyUni_InstructorDetailEntity instructorDetailEntity) {
        this.instructorDetailEntity = instructorDetailEntity;
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


}
