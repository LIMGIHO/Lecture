package hello.core.web;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    // private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        // MyLogger myLogger = myLoggerProvider.getObject();
        String requestURL = request.getRequestURL().toString();

        System.out.println("Before MyLogger : " + myLogger.getClass());

        myLogger.setRequestUrl(requestURL);

        System.out.println("After MyLogger : " + myLogger.getClass());
        myLogger.log("controller test");

        logDemoService.logic("testId");

        return "OK";
    }

}
