package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Created by PD on 2017/5/3.
 */

@Entity
public class User {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @NotNull
    @Size(max = 64)
    private String id;

    @Column(name = "password", nullable = false)
    @NotNull
    @Size(max = 64)
    private String password;

    private long userId;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User() {
    }

    public User(final String id, final String password) {
        this.id = id;
        this.password = password;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString() + "id: " + id + " password: " + password;
    }
}
