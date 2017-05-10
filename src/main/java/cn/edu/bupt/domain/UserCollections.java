package cn.edu.bupt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hadoop on 17-5-10.
 */

@Entity
@Table(name = "collection")
public class UserCollections {

    @Id
    @Column(name = "userId")
    private long userId;

    @Id
    @Column(name = "articleId")
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
