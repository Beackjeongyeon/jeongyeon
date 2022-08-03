package com.example.theatherproject.controller;

import com.example.theatherproject.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;
    //공지사항 등록
    @GetMapping("/notice-form")
    public String noticeForm() {
        System.out.println("NoticeController.noticeForm");
        return "noticePages/notice";
    }
}

