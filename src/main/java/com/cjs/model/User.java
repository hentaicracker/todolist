package com.cjs.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 2016/5/8
 */
@Entity
@Table(name="user")
public class User implements Serializable {
    private Integer id;
    private String user_name;
    private String user_psd;
    private Integer user_type;
    private String nick_name;
    private String user_avatar;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id",length=22,nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="user_name",length=255)
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Column(name="user_psd",length=255)
    public String getUser_psd() {
        return user_psd;
    }

    public void setUser_psd(String user_psd) {
        this.user_psd = user_psd;
    }

    @Column(name="user_type",length=22)
    public Integer getUser_type() {
        return user_type;
    }

    public void setUser_type(Integer user_type) {
        this.user_type = user_type;
    }


    @Column(name="nick_name",length=255)
    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    @Column(name="user_avatar",length=255)
    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }
}
