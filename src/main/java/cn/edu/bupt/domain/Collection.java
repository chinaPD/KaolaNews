package cn.edu.bupt.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hadoop on 17-5-10.
 */

@Entity
@Table(name = "collection")
@IdClass(CollectionPrimaryKey.class)
public class Collection implements Serializable{

    @Id
    @Column(name = "userid")
    private long userId;

    @Id
    @Column(name = "articleid")
    private long articleId;

    @Column(name = "addtime")
    private String addtime;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public long getUserId() {
        return userId;
    }

    public long getArticleId() {
        return articleId;
    }

    public String getAddtime() {
        return addtime;
    }
}
