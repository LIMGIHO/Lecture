package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
// import jakarta.inject.Provider;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean p1 = ac.getBean(PrototypeBean.class);
        p1.addCount();
        Assertions.assertThat(p1.getCount()).isEqualTo(1);

        PrototypeBean p2 = ac.getBean(PrototypeBean.class);
        p2.addCount();
        Assertions.assertThat(p2.getCount()).isEqualTo(1);

        ac.close();
    }

    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,
                PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClientBean {
        // private final PrototypeBean prototypeBean;

        // @Autowired
        // public ClientBean(PrototypeBean prototypeBean) {
        // this.prototypeBean = prototypeBean;
        // }

        // public int logic() {
        // prototypeBean.addCount();
        // int count = prototypeBean.getCount();
        // return count;
        // }

        // // 아래처럼하면 prototype빈을 logic 호출 시에 생성 -> 무식한 방법
        // @Autowired
        // private AnnotationConfigApplicationContext ac;

        // public int logic() {
        // PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
        // prototypeBean.addCount();
        // int count = prototypeBean.getCount();
        // return count;
        // }

        @Autowired
        private ObjectProvider<PrototypeBean> pObjectProvider;

        public int logic() {
            PrototypeBean prototypeBean = pObjectProvider.getObject();
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }

        // @Autowired
        // private Provider<PrototypeBean> pObjectProvider;

        // public int logic() {
        // PrototypeBean prototypeBean = pObjectProvider.getObject();
        // prototypeBean.addCount();
        // int count = prototypeBean.getCount();
        // return count;
        // }

    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destory() {
            System.out.println("PrototypeBean.destory");
        }

    }
}
