package com.srikanth.hibernatetutorial.entities.onetomany;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail", schema = "", catalog = "`hb-03-one-to-many`")
public class InstructorDetailEntity {
    private int id;
    private String youtubeChannel;
    private String hobby;

    public InstructorDetailEntity(String youtubeChannel,String hobby) {
        this.hobby=hobby;
        this.youtubeChannel=youtubeChannel;
    }

    public InstructorDetailEntity() {
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
    @Column(name = "youtube_channel")
    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    @Basic
    @Column(name = "hobby")
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstructorDetailEntity that = (InstructorDetailEntity) o;

        if (id != that.id) return false;
        if (youtubeChannel != null ? !youtubeChannel.equals(that.youtubeChannel) : that.youtubeChannel != null)
            return false;
        if (hobby != null ? !hobby.equals(that.hobby) : that.hobby != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (youtubeChannel != null ? youtubeChannel.hashCode() : 0);
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        return result;
    }
}
