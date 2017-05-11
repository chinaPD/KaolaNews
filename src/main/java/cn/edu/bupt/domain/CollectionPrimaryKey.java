package cn.edu.bupt.domain;

import java.io.Serializable;

/**
 * Created by hadoop on 17-5-10.
 */

public class CollectionPrimaryKey implements Serializable {

    protected long userId;
    protected long articleId;

    public CollectionPrimaryKey() {
    }

    public CollectionPrimaryKey(long userId, long articleId) {
        this.userId = userId;
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (!(obj instanceof CollectionPrimaryKey)) return false;

        CollectionPrimaryKey primaryKey = (CollectionPrimaryKey) obj;

        if (primaryKey.userId == this.userId
                && primaryKey.articleId == this.articleId)
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + (int)(this.userId ^ (this.userId >>> 32));
        result = result * 37 + (int)(this.articleId ^ (this.articleId >>> 32));
        return result;
    }
}
