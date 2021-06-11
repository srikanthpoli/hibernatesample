//package com.srikanth.hibernatetutorial.entities.entities.onetoone;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "instructor_detail", schema = "", catalog = "`hb-01-one-to-one-uni`")
//public class InstructorDetailEntity {
//    private int id;
//    private String youtubeChannel;
//    private String hobby;
//    private InstructorEntity instructorEntity;
//
//    @OneToOne(mappedBy = "instructorDetailEntity",cascade ={ CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JsonManagedReference
//    public InstructorEntity getInstructorEntity() {
//        return instructorEntity;
//    }
//
//    public void setInstructorEntity(InstructorEntity instructorEntity) {
//        this.instructorEntity = instructorEntity;
//    }
//
//    public InstructorDetailEntity() {
//    }
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
//    @Column(name = "youtube_channel")
//    public String getYoutubeChannel() {
//        return youtubeChannel;
//    }
//
//    public void setYoutubeChannel(String youtubeChannel) {
//        this.youtubeChannel = youtubeChannel;
//    }
//
//    @Basic
//    @Column(name = "hobby")
//    public String getHobby() {
//        return hobby;
//    }
//
//    public void setHobby(String hobby) {
//        this.hobby = hobby;
//    }
//
//    @Override
//    public String toString() {
//        return "InstructorDetailEntity{" +
//                "id=" + id +
//                ", youtubeChannel='" + youtubeChannel + '\'' +
//                ", hobby='" + hobby + '\'' +
//                '}';
//    }
//
//    public InstructorDetailEntity(String youtubeChannel, String hobby) {
//        this.youtubeChannel=youtubeChannel;
//        this.hobby=hobby;
//    }
//}
