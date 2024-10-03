package hello.servlet.basic.request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestParamSevlet", urlPatterns = "/request-param")
public class RequestParamSevlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RequestParamSevlet.service()");

        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));
        System.out.println();

        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("User Name = " + username + " / Age = " + age);
        System.out.println();

        String[] names = req.getParameterValues("username");

        for (String name : names) {
            System.out.println("names = " + name);
            resp.getWriter().write("names = " + name);
            System.out.println();
        }

        System.out.println("RequestParamSevlet.service() Finish");
    }
}
