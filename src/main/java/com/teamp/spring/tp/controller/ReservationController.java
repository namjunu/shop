package com.teamp.spring.tp.controller;

import com.teamp.spring.tp.dto.ReservationDto;
import com.teamp.spring.tp.service.ReservationService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j
@RequestMapping("/reservation/*")
@AllArgsConstructor
@Controller
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/del/{ex_book_number}")
    public String del(@PathVariable String ex_book_number) {
        reservationService.del(ex_book_number);
        // 수정: 리다이렉트 경로를 /reservation/list/{userId} 로 수정 (사용자 아이디 필요)
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(ReservationDto reservationDto) {
        reservationService.add(reservationDto);
        // 수정: 리다이렉트 경로를 /reservation/list/{userId} 로 수정 (사용자 아이디 필요)
        return "redirect:/";
    }

    @PostMapping("/modify")
    public String modify(@RequestBody ReservationDto reservationDto) {
        reservationService.modify(reservationDto);
        // 수정: 리다이렉트 경로를 /reservation/list/{userId} 로 수정 (사용자 아이디 필요)
        return "redirect:/";
    }
}
