package com.hong.pet.model;

import java.util.ArrayList;
import java.util.List;

public class Jx {
    private Integer imgUrl;
    private Object content;
    private List<Integer> imgUrls;
    private int type;
    public Jx() {
    }

    public Jx(Integer imgUrl, Object content) {
        this.imgUrl = imgUrl;
        this.content = content;
    }

    public List<Integer> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<Integer> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Integer getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Integer imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
