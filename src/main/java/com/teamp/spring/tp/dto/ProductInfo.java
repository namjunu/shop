package com.teamp.spring.tp.dto;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class ProductInfo {
	private int pNo;
    private String pName;
    private int pPrice;
    private String pBrand;
    private String pDescription;
    private String pCategory;
    private int pStock;
    private String pImage;
    private Timestamp pCreatedDate;
    private Timestamp pUpdatedDate;
    private String pTags;
 // Getter 메서드 추가
    public int getpNo() {
        return pNo;
    }

    public String getpName() {
        return pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public String getpBrand() {
        return pBrand;
    }

    public String getpDescription() {
        return pDescription;
    }

    public String getpCategory() {
        return pCategory;
    }

    public int getpStock() {
        return pStock;
    }

    public String getpImage() {
        return pImage;
    }

    public Timestamp getpCreatedDate() {
        return pCreatedDate;
    }

    public Timestamp getpUpdatedDate() {
        return pUpdatedDate;
    }

    public String getpTags() {
        return pTags;
    }
}
