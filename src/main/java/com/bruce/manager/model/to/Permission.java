package com.bruce.manager.model.to;

/**
 * Created by bruce on 19/5/23 -- 20:50
 */
public class Permission {
    private Integer id;
    private String p_name;
    private String url;

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
