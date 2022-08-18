package com.example.theatherproject.controller;
import com.example.theatherproject.dto.TicketDTO;
import com.example.theatherproject.service.MemberService;
import com.example.theatherproject.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;

    private final MemberService memberService;
    @PostMapping("/save")
    public String save(@ModelAttribute TicketDTO ticketDTO,Model model){
        TicketDTO result= ticketService.save(ticketDTO);
        model.addAttribute("id",ticketDTO);
        model.addAttribute("ticket",result);
        return "ticketPages/select";
    }
}
