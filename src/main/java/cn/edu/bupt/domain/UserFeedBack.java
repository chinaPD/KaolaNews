package cn.edu.bupt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 17-5-10.
 */

@Entity
@Table(name = "feedback")
public class UserFeedBack {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "userId")
    private long userId;

    @Column(name = "errorType")
    private String errorType;

    @Column(name = "content")
    private String content;

    @Column(name = "contact")
    private String contact;

    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public long getId() {

        return id;
    }

    public long getUserId() {
        return userId;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getContent() {
        return content;
    }

    public String getContact() {
        return contact;
    }
}
