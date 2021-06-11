package com.srikanth.hibernatetutorial.entities.onetomany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "course", schema = "", catalog = "`hb-03-one-to-many`")
public class CourseEntity {
    private int id;
    private String title;


    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name="instructor_id")
    @JsonManagedReference
    public InstructorEntity getInstructorEntity() {
        return instructorEntity;
    }

    public void setInstructorEntity(InstructorEntity instructorEntity) {
        this.instructorEntity = instructorEntity;
    }

    public CourseEntity() {
    }

    public CourseEntity(String title) {
        this.title=title;
    }

    private InstructorEntity instructorEntity;

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




}
