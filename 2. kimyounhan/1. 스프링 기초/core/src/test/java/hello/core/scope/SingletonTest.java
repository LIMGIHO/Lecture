package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean s1 = ac.getBean(SingletonBean.class);
        SingletonBean s2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 = " + s1);
        System.out.println("singletonBean2 = " + s2);

        Assertions.assertThat(s1).isSameAs(s2);
        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean {

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
