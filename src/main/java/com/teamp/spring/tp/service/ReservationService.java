package com.teamp.spring.tp.service;

import com.teamp.spring.tp.dto.ReservationVo;

import java.util.ArrayList;
import java.util.Date;

public interface ReservationService {
    ArrayList<ReservationVo> booklist();

    void bookadd(Date R_date, String R_name, String R_hospital_name);

    void bookdelete(String R_name);

    void bookmodify(Date R_date, String R_name, String R_hospital_name);
}
