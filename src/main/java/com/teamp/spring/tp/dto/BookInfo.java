package com.teamp.spring.tp.dto;

public class BookInfo {
    private String bookNumber; // 예약 번호 추가
    private String bookDate;
    private String doctorName;
    private int totalBookCount;

    // 기본 생성자
    public BookInfo() {
    }

    // Getter와 Setter 메서드

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(int totalBookCount) {
        this.totalBookCount = totalBookCount;
    }
}
