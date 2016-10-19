package com.github.wuhulala.model;

/**
 *
 * @author wuhulala
 * @date 2016-10-19
 * @description Product bean; note that it must be a public class!
 */

public class Product {

    private String url;
    private String name;

    public Product() {
    }

    public Product(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // As per the JavaBeans spec., this defines the "url" bean property
    // It must be public!
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // As per the JavaBean spec., this defines the "name" bean property
    // It must be public!
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}