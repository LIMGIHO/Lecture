package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        // AppConfig appConfig = new AppConfig();
        // memberService = appConfig.memberService();
        // orderService = appConfig.orderService();
        ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = apc.getBean("memberService", MemberService.class);
        orderService = apc.getBean("orderService", OrderService.class);
    }

    @Test
    void OrderTest() {
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.creatOrder(member.getId(), "ItemA", 10000);
        // System.out.println("order:" + order);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
