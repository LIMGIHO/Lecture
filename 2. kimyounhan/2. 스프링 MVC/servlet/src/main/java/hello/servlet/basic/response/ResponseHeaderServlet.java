package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ResponseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // [status-line]
        resp.setStatus(HttpServletResponse.SC_OK);

        // [response-header]
        // resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        // resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        // [Header 편의 메서드]
        content(resp);
        cookies(resp);
        redirect(resp);

        PrintWriter writer = resp.getWriter();
        writer.println("ok");
    }

    private void redirect(HttpServletResponse resp) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html

        // resp.setStatus(HttpServletResponse.SC_FOUND);
        // resp.setHeader("Location", "/basic/hello-form.html");

        resp.sendRedirect("/basic/hello-form.html");
    }

    private void cookies(HttpServletResponse resp) {
        // Set-Cookie: myCookie=good; Max-Age=600;
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600")
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }

    private void content(HttpServletResponse resp) {

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
    }
}
