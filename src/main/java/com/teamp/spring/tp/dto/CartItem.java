package com.teamp.spring.tp.dto;

import lombok.Data;

@Data
public class CartItem {
	
	private int cartId; //Cart 번호
	private String U_ID; //유저 No
    private int p_NO; // 상품 ID
    private int quantity; // 상품 수량

    // 기본 생성자
    public CartItem() {
    }

    // 모든 필드를 매개변수로 받는 생성자
    public CartItem(int p_NO, int quantity) {
        this.p_NO = p_NO;
        this.quantity = quantity;
    }

    public CartItem(String u_ID2, int p_NO2, int quantity2) {
		this.U_ID = u_ID2;
		this.p_NO = p_NO2;
		this.quantity = quantity2;
	}

	// 상품 ID에 대한 getter와 setter
    public int getp_NO() {
        return p_NO;
    }

    public void setp_NO(int p_NO) {
        this.p_NO = p_NO;
    }

    // 상품 수량에 대한 getter와 setter
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "CartItem{" +
                "P_NO=" + p_NO +
                ", quantity=" + quantity +
                '}';
    }
}
