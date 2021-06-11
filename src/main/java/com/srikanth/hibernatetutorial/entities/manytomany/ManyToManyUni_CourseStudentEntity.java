package com.srikanth.hibernatetutorial.entities.manytomany;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course_student", schema = "", catalog = "`hb-05-many-to-many`")
public class ManyToManyUni_CourseStudentEntity implements Serializable {
    private int courseId;
    private int studentId;

    @Id
    @Column(name = "course_id")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Id
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

}
