package hello.servlet.web.frontcontroller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyView {
    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    public void render(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        modelToRequestAttribute(model, req);
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        System.out.println("render = " + model.get("username") + "viewPath = " + viewPath);
        dispatcher.forward(req, resp);
    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest req) {
        System.out.println("modelToRequestAttribute = " + model.toString());
        model.forEach((key, value) -> {
            req.setAttribute(key, value);
        });
    }
}
