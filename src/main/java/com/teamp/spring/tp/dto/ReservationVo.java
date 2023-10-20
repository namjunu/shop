package com.teamp.spring.tp.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ReservationVo {
    private Date R_date;
    private String R_name;
    private String R_hospital_name;
}
