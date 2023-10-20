package com.teamp.spring.tp.service;

import com.teamp.spring.tp.dto.ReservationVo;
import com.teamp.spring.tp.mapper.ReservationMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;

@Log4j
@Service
public class ReservationServiceImpl implements ReservationService {
    @Setter(onMethod_ = @Autowired)
    private ReservationMapper reservationMapper;

    @Override
    public ArrayList<ReservationVo> booklist() {
        return reservationMapper.booklist();
    }

    @Override
    public void bookadd(Date R_date, String R_name, String R_hospital_name) {
        reservationMapper.bookadd(R_date, R_name, R_hospital_name);
    }

    @Override
    public void bookdelete(String R_name) {
        reservationMapper.bookdelete(R_name);
    }

    @Override
    public void bookmodify(Date R_date, String R_name, String R_hospital_name) {
        ReservationVo reservationDto = new ReservationVo();
        reservationDto.setR_date(R_date);
        reservationDto.setR_name(R_name);
        reservationDto.setR_hospital_name(R_hospital_name);

        reservationMapper.bookmodify(reservationDto);
    }
}
