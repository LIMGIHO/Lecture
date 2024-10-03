package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// @Controller -> 이렇게 하면 return "ok" 가 view이름을 반환하는게 되는거고
@RestController // -> 이렇게 하면 return "ok"가 그냥 문자열로 반환하게 되는거다
public class LogTestController {
    // private final Logger log = LoggerFactory.getLogger(getClass()); -> @Slf4j 이게
    // 대신 해줌(lombok이 제공하는 어노테이션)

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        // 아래 순서로 설정(application.properties)
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
