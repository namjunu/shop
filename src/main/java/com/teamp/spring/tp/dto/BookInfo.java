package com.teamp.spring.tp.dto;

public class BookInfo {
    private String bookDate;
    private String doctorName;
    private int totalbookCount;

    // Getter와 Setter 메서드

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String reservationDate) {
        this.bookDate = reservationDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getTotalBookCount() {
        return totalbookCount;
    }

    public void setTotalBookCount(int totalReservationCount) {
        this.totalbookCount = totalReservationCount;
    }
}
