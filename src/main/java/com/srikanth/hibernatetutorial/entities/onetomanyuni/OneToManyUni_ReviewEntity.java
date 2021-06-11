package com.srikanth.hibernatetutorial.entities.onetomanyuni;

import javax.persistence.*;

@Entity
@Table(name = "review", schema = "", catalog = "`hb-04-one-to-many-uni`")
public class OneToManyUni_ReviewEntity {
    private int id;
    private String comment;
    private Integer courseId;

    public OneToManyUni_ReviewEntity() {
    }

    public OneToManyUni_ReviewEntity( String comment) {
        this.comment=comment;
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
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "course_id")
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OneToManyUni_ReviewEntity that = (OneToManyUni_ReviewEntity) o;

        if (id != that.id) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        return result;
    }
}
