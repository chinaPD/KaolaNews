package cn.edu.bupt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 17-5-5.
 */
@Entity
@Table(name = "articles_")
public class Article {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "author")
    private String author;

    @Column(name = "titile")
    private String title;

    @Column(name = "summary")
    private String summary;

    @Column(name = "typelabel")
    private String typelabel;

    @Column(name = "addtime")
    private String addtime;

    @Column(name = "updatetime")
    private String updatetime;

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

    public void setTypelabel(String typelabel) {
        this.typelabel = typelabel;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
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

    public String getTypelabel() {
        return typelabel;
    }

    public String getAddtime() {
        return addtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public String getUri() {
        return uri;
    }
}
