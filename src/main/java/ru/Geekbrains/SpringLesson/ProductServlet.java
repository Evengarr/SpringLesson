package ru.Geekbrains.SpringLesson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
    String[] message = new String[3];
    Product product1 = new Product(1, "aaa", 15.5);
    Product product2 = new Product(2, "bbb", 13.0);
    Product product3 = new Product(3, "ccc", 11.5);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("List_product", Arrays.deepToString(message));

        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    public void init() {

        message[0] = "<br>" + (product1.getId() + " " + product1.getTitle() + " " + product1.getCost());
        message[1] = "<br>" + (product2.getId() + " " + product2.getTitle() + " " + product2.getCost());
        message[2] = "<br>" + (product3.getId() + " " + product3.getTitle() + " " + product3.getCost() + "<br>");
    }

    public void destroy() {
    }
}
