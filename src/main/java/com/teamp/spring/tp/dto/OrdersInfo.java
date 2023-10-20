package com.teamp.spring.tp.dto;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrdersInfo {
	private int O_ID; // 주문번호
	private int P_NO; 
    private int QUANTITY;
    private int PAYMENT_AMOUNT;
    private String O_NAME;
    private String O_PHONE;
    private String O_ADDRESS;
}
