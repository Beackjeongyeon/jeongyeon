package com.example.theatherproject.controller;
import com.example.theatherproject.dto.MemberDTO;
import com.example.theatherproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //회원가입 페이징 처리
    @GetMapping("/Save-form")
    public String saveForm() {

        return "/memberPages/save";
    }
    @GetMapping("/admin-form")
    public String admin(){
        return "/adminPages/admin";
    }

    //회원가입처리
    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "redirect:/";
    }
    //로그인처리
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getUserId());
            session.setAttribute("id", loginResult.getId());
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    //로그아웃처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginId");
        session.removeAttribute("id");
        return "redirect:/";
    }
    //마이페이지 페이징처리

    @GetMapping("/myPage")
    public String MyPage() {
        return "memberPages/check";
    }

    @PostMapping("/Check")
    public String Check(@RequestParam("memberId") Long memberId, @RequestParam("memberPassword2") String memberPassword2) {
        MemberDTO checkResult = memberService.Check(memberId, memberPassword2);
        if (checkResult != null) {
            return "memberPages/Mypage";
        } else {
            return "memberPages/check";
        }
    }

    // 회원정보수정
    @GetMapping("/update-form")
    public String updateform(HttpSession session , Model model) {
        Long id= (Long)session.getAttribute("id");
        MemberDTO result = memberService.findById(id);
        model.addAttribute("result",result);
        return "memberPages/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO, Model model){
        memberService.update(memberDTO);
       return "memberPages/Mypage";
    }

    // 예약정보확인
    @GetMapping("/confirm-form")
    public String Confirmform() {

        return "/memberPages/confirm";
    }


    //나의문의내역
    @GetMapping("/question-form")
    public String questionform(Model model) {

        return "/memberPages/question";
    }

    //회원 탈퇴
    @GetMapping("/secession-form")
    public String secessionform(HttpSession session, Model model) {
        return "/memberPages/secession";
    }

    @PostMapping("/secession")
    public String secession(HttpSession session, @RequestParam("memberPassword") String pwCheck) {
        Long id = (Long) session.getAttribute("id");
        MemberDTO result = memberService.findById(id);
        String pw = result.getMemberPassword();
        if (pw.equals(pwCheck)) {
            memberService.delete(id);
            session.invalidate();
            return "redirect:/";
        } else {
            return "redirect:/memberPages/secession";
        }
    }

}



