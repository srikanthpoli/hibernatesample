package com.srikanth.hibernatetutorial.entities.onetomanyuni;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.srikanth.hibernatetutorial.entities.onetomany.InstructorEntity;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course", schema = "", catalog = "`hb-04-one-to-many-uni`")
public class OneToManyUni_CourseEntity {
    private int id;
    private String title;
    private Integer instructorId;



    private OneToManyUni_InstructorEntity instructorEntity;
    public OneToManyUni_CourseEntity() {
    }

    public OneToManyUni_CourseEntity( String title) {
             this.title=title;
          }

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        @JoinColumn(name="course_id")
    public List<OneToManyUni_ReviewEntity> getReviewEntityList() {
        return reviewEntityList;
    }

    public void setReviewEntityList(List<OneToManyUni_ReviewEntity> reviewEntityList) {
        this.reviewEntityList = reviewEntityList;
    }


    private List<OneToManyUni_ReviewEntity> reviewEntityList;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(insertable = false,updatable = false,name="instructor_id")
    @JsonManagedReference
    public OneToManyUni_InstructorEntity getInstructorEntity() {
        return instructorEntity;
    }

    public void setInstructorEntity(OneToManyUni_InstructorEntity instructorEntity) {
        this.instructorEntity = instructorEntity;
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

    public void addReview(OneToManyUni_ReviewEntity reviewEntity){
        if(this.reviewEntityList==null)
            reviewEntityList= new ArrayList<>();
        reviewEntityList.add(reviewEntity);
    }
}
