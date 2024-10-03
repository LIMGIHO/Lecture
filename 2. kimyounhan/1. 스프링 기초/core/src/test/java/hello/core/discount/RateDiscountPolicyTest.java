package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {

    @Test
    @DisplayName("VIP는 10% 할인 되어야 한다")
    void vip_o() {
        DiscountPolicy discountPolicy = new RateDiscountPolicy();

        // given
        Member member = new Member(1L, "stephen", Grade.VIP);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP는 10% 할인 되어야 한다")
    void vip_x() {
        DiscountPolicy discountPolicy = new RateDiscountPolicy();

        // given
        Member member = new Member(1L, "stephen", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}
