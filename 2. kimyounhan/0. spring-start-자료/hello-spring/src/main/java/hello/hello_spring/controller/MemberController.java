package hello.hello_spring.controller;

import hello.hello_spring.domain.Members;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "member/createForm";
    }

    @PostMapping("/members/new")
    public String createNew(MemberForm memberForm) {
        Members member = new Members();
        member.setName(memberForm.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Members> list = memberService.findMembers();
        model.addAttribute("members", list);
        return "member/memberList";
    }
}
