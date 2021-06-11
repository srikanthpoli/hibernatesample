package com.srikanth.hibernatetutorial.entities.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student", schema = "", catalog = "`hb-05-many-to-many`")
public class ManyToManyUni_StudentEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public ManyToManyUni_StudentEntity( String firstName,String lastName,String email) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    public ManyToManyUni_StudentEntity() {
    }

    private List<ManyToManyUni_CourseEntity> courseEntityList;
    @ManyToMany (fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",catalog = "`hb-05-many-to-many`",
            joinColumns = @JoinColumn(name = "student_id")
            , inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    public List<ManyToManyUni_CourseEntity> getCourseEntityList() {

        return courseEntityList;
    }

    public void setCourseEntityList(List<ManyToManyUni_CourseEntity> courseEntityList) {
        this.courseEntityList = courseEntityList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    public void addCourse(ManyToManyUni_CourseEntity courseEntity)
    {
        if (this.courseEntityList==null)
            courseEntityList= new ArrayList<>();
        courseEntityList.add(courseEntity);
    }
}
