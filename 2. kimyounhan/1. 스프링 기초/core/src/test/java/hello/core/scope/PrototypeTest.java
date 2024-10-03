package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import hello.core.scope.SingletonTest.SingletonBean;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find prototypeBean1");
        PrototypeBean p1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean p2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + p1);
        System.out.println("prototypeBean2 = " + p2);

        Assertions.assertThat(p1).isNotSameAs(p2);

        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void close() {
            System.out.println("SingletonBean.destroy");
        }
    }
}
