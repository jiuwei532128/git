package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/6.
 */
public class Album implements Serializable {
    private String id;
    private String thumbnail;
    private String title;
    private Integer set_count;
    private Double score;
    private String author;
    private String broadcast;
    private String brlef;

    public Album() {
    }

    public Album(String id, String thumbnail, String title, Integer set_count, Double score, String author, String broadcast, String brlef) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.set_count = set_count;
        this.score = score;
        this.author = author;
        this.broadcast = broadcast;
        this.brlef = brlef;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSet_count() {
        return set_count;
    }

    public void setSet_count(Integer set_count) {
        this.set_count = set_count;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getBrlef() {
        return brlef;
    }

    public void setBrlef(String brlef) {
        this.brlef = brlef;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (!id.equals(album.id)) return false;
        if (!thumbnail.equals(album.thumbnail)) return false;
        if (!title.equals(album.title)) return false;
        if (!set_count.equals(album.set_count)) return false;
        if (!score.equals(album.score)) return false;
        if (!author.equals(album.author)) return false;
        if (!broadcast.equals(album.broadcast)) return false;
        return brlef.equals(album.brlef);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + thumbnail.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + set_count.hashCode();
        result = 31 * result + score.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + broadcast.hashCode();
        result = 31 * result + brlef.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", set_count=" + set_count +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadcast='" + broadcast + '\'' +
                ", brlef='" + brlef + '\'' +
                '}';
    }
}
