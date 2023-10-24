package com.teamp.spring.tp.controller;

import com.teamp.spring.tp.dto.ReservationVo;
import com.teamp.spring.tp.service.ReservationService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/reservation/*")
@AllArgsConstructor
@Controller
public class ReservationController {
    private ReservationService reservationService;

    @GetMapping("/booklist")
    public void booklist(Model model) {
        model.addAttribute("list", reservationService.booklist());
    }

    @PostMapping("/bookadd")
    public String bookadd(
    		@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("R_date") Date R_date, 
    		@RequestParam("R_name") String R_name, 
    		@RequestParam("R_hospital_name") String R_hospital_name){
        reservationService.bookadd(R_date, R_name, R_hospital_name);
        System.out.println("예약이 완료되었습니다.");
        return "redirect:/searchMap";
    }

    @PostMapping("/bookdelete")
    public String bookdelete(@RequestParam("R_name") String R_name) {
        reservationService.bookdelete(R_name);
        System.out.println("예약이 삭제되었습니다.");
        return "redirect:/searchMap";
    }

    @PostMapping("/bookmodify")
    public String bookmodify(
    	@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("R_date") Date R_date, 
        @RequestParam("R_name") String R_name, 
        @RequestParam("R_hospital_name") String R_hospital_name) {
        reservationService.bookmodify(R_date, R_name, R_hospital_name);
        System.out.println("예약이 수정되었습니다.");
        return "redirect:/searchMap";
    }
    
    @PostMapping("/booksearch")
    public String bookSearch(String R_name, Model model) {
        ArrayList<ReservationVo> searchResults = reservationService.booksearch(R_name);
        model.addAttribute("searchResults", searchResults);
        System.out.println("예약을 조회합니다.");
        return "reservation/searchResultsView";
    }
}
