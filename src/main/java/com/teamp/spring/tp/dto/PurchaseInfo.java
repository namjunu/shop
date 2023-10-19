package com.teamp.spring.tp.dto;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class PurchaseInfo {
	private int O_ID; // 주문번호
    private String U_ID;
    private Timestamp O_DATE;
}
