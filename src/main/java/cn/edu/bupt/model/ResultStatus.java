package cn.edu.bupt.model;

/**
 * Created by hadoop on 17-5-3.
 */
public enum ResultStatus {
    SUCCESS(100, "成功"),
    USERNAME_OR_PASSWORD_ERROR(-1001, "用户名或密码错误"),
    USER_NOT_FOUND(-1002, "用户不存在"),
    USER_NOT_LOGIN(-1003, "用户未登录"),
    ADD_COLLECTION_FAILED(-1004, "收藏失败"),
    ADD_COLLECTION_SUCCESS(-1005, "收藏成功"),
    CONTENT_NOT_OK(-1006, "内容过短");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
