package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void BeforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "stephen", Grade.VIP);

        // when
        memberService.join(member);

        // then
        Member findMember = memberService.findMember(1L);
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
