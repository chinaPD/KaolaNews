package cn.edu.bupt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hadoop on 17-5-5.
 */
@Entity
@Table(name = "articles_")
public class Article {


    @Column(name = "id")
    private long id;

    @Column(name = "author")
    private String author;

    @Column(name = "titile")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "add_time")
    private String add_time;

    @Column(name = "update_time")
    private String update_time;

    @Column(name = "uri")
    private String uri;


    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getAdd_time() {
        return add_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public String getUri() {
        return uri;
    }
}
