package hello.servlet.web.springmvc.v1;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMemberListControllerV1 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {
        List<Member> member = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", member);
        return mv;
    }

}
