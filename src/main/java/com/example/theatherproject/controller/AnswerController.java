package com.example.theatherproject.controller;

import com.example.theatherproject.dto.AnswerDTO;
import com.example.theatherproject.service.AnswerService;
import com.example.theatherproject.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/save")
    public String save(@ModelAttribute AnswerDTO answerDTO, Model model){
        answerService.save(answerDTO);
        return "questionPages/adminlist";

    }

}
