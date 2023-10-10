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
}
