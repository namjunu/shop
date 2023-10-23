package com.teamp.spring.tp.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProductInfo {
    private int P_NO; // 필드 이름을 다시 P_NO로 수정
    private String P_NAME;
    private int P_PRICE;
    private String P_BRAND;
    private String P_DESCRIPTION;
    private String P_CATEGORY;
    private int P_STOCK;
    private String P_IMAGE;
    private Timestamp P_CREATED_DATE;
    private Timestamp P_UPDATED_DATE;
    private String P_TAGS;
    
    public int getP_NO() {
        return P_NO;
    }

    public void setP_NO(int p_NO) {
        this.P_NO = p_NO;
    }

    public String getP_NAME() {
        return P_NAME;
    }

    public void setP_NAME(String p_NAME) {
        this.P_NAME = p_NAME;
    }

    public int getP_PRICE() {
        return P_PRICE;
    }

    public void setP_PRICE(int p_PRICE) {
        this.P_PRICE = p_PRICE;
    }

    public String getP_BRAND() {
        return P_BRAND;
    }

    public void setP_BRAND(String p_BRAND) {
        this.P_BRAND = p_BRAND;
    }

    public String getP_DESCRIPTION() {
        return P_DESCRIPTION;
    }

    public void setP_DESCRIPTION(String p_DESCRIPTION) {
        this.P_DESCRIPTION = p_DESCRIPTION;
    }

    public String getP_CATEGORY() {
        return P_CATEGORY;
    }

    public void setP_CATEGORY(String p_CATEGORY) {
        this.P_CATEGORY = p_CATEGORY;
    }

    public int getP_STOCK() {
        return P_STOCK;
    }

    public void setP_STOCK(int p_STOCK) {
        this.P_STOCK = p_STOCK;
    }

    public String getP_IMAGE() {
        return P_IMAGE;
    }

    public void setP_IMAGE(String p_IMAGE) {
        this.P_IMAGE = p_IMAGE;
    }

    public Timestamp getP_CREATED_DATE() {
        return P_CREATED_DATE;
    }

    public void setP_CREATED_DATE(Timestamp p_CREATED_DATE) {
        this.P_CREATED_DATE = p_CREATED_DATE;
    }

    public Timestamp getP_UPDATED_DATE() {
        return P_UPDATED_DATE;
    }

    public void setP_UPDATED_DATE(Timestamp p_UPDATED_DATE) {
        this.P_UPDATED_DATE = p_UPDATED_DATE;
    }

    public String getP_TAGS() {
        return P_TAGS;
    }

    public void setP_TAGS(String p_TAGS) {
        this.P_TAGS = p_TAGS;
    }
}
