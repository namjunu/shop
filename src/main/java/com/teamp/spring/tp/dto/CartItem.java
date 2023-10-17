package com.teamp.spring.tp.dto;

public class CartItem {

    private int productId; // 상품 ID
    private int quantity; // 상품 수량

    // 기본 생성자
    public CartItem() {
    }

    // 모든 필드를 매개변수로 받는 생성자
    public CartItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // 상품 ID에 대한 getter와 setter
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
