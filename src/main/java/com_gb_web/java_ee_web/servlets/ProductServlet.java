package com_gb_web.java_ee_web.servlets;

import com_gb_web.java_ee_web.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@WebServlet(name = "productServlet", value = "/product-servlet")
public class ProductServlet extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        message = showArrayList();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<p>" + message + "<p>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private List<Product> initProducts(){
        List<Product> products = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            products.add(new Product(i, generateRandomString(), Math.random() * 43));
        }
        return products;
    }


    private String generateRandomString(){
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    private String showArrayList(){
        StringBuilder sb = new StringBuilder();
        for (Product p: initProducts()) {
            sb.append(p.toString());
            sb.append(",  ");
        }
        return sb.toString();
    }

}
