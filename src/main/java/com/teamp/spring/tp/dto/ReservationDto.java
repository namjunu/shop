package com.teamp.spring.tp.dto;

import java.util.Date;

public class ReservationDto {
    private String exId;
    private String exPw;
    private String exBookNumber;
    private Date exBookDate;

    public String getExId() {
        return exId;
    }

    public void setExId(String exId) {
        this.exId = exId;
    }

    public String getExPw() {
        return exPw;
    }

    public void setExPw(String exPw) {
        this.exPw = exPw;
    }

    public String getExBookNumber() {
        return exBookNumber;
    }

    public void setExBookNumber(String exBookNumber) {
        this.exBookNumber = exBookNumber;
    }

    public Date getExBookDate() {
        return exBookDate;
    }

    public void setExBookDate(Date exBookDate) {
        this.exBookDate = exBookDate;
    }
}