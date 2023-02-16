package com.article.basicarticle.library.rest;

public class MetaResponse {

    public static final String CODE_SUCCESS = "200";
    public static final String DESC_SUCCESS = "SUCCESS";
    private String code;
    private String description;

    public MetaResponse() {
    }

    private MetaResponse(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static MetaResponse of(String code, String description){
        return new MetaResponse(code, description);
    }

    public static MetaResponse ofSuccess(){
        return new MetaResponse(CODE_SUCCESS, DESC_SUCCESS);
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
