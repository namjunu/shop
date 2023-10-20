package com.teamp.spring.tp.service;

import java.util.List;

import com.teamp.spring.tp.dto.ReservationDto;

public interface ReservationService {

    void del(String ex_book_number);

    void add(ReservationDto ReservationDto);

    void modify(ReservationDto ReservationDto);
    
}
