package com.teamp.spring.tp.service;

import com.teamp.spring.tp.dto.ReservationDto;
import com.teamp.spring.tp.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationServiceImpl(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    @Override
    public void del(String ex_book_number) {
        reservationMapper.del(ex_book_number);
    }

    @Override
    public void add(ReservationDto ReservationDto) {
        reservationMapper.add(ReservationDto);
    }

    @Override
    public void modify(ReservationDto ReservationDto) {
        reservationMapper.modify(ReservationDto);
    }

}