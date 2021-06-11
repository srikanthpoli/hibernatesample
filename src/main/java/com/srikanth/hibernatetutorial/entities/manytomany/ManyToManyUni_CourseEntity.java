package com.srikanth.hibernatetutorial.entities.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course", schema = "", catalog = "`hb-05-many-to-many`")
public class ManyToManyUni_CourseEntity {
    private int id;
    private String title;
    private Integer instructorId;
    private List<ManyToManyUni_StudentEntity> studentEntities;

    public ManyToManyUni_CourseEntity(String title) {
        this.title=title;
    }

    public ManyToManyUni_CourseEntity() {
    }

    @ManyToMany (fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",catalog = "`hb-05-many-to-many`",
            joinColumns = @JoinColumn(name = "course_id")
            , inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    public List<ManyToManyUni_StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(List<ManyToManyUni_StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "instructor_id")
    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }


    public void addStudent(ManyToManyUni_StudentEntity studentEntity){
        if(studentEntities==null)
            studentEntities= new ArrayList<>();
        studentEntities.add(studentEntity);
    }
}
