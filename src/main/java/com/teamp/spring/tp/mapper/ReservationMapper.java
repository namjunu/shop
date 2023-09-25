package com.teamp.spring.tp.mapper;

import com.teamp.spring.tp.dto.ReservationDto;

public interface ReservationMapper {

	ReservationDto list(String userId);

    void del(String ex_book_number);

    void add(ReservationDto guestDto);

    void modify(ReservationDto guestDto);
}
