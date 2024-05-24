package com.example.tpo5.Servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormServlet", value = "/cars/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html lang=\"en\">");
        response.getWriter().println("<head>");
        response.getWriter().println("<meta charset=\"UTF-8\">");
        response.getWriter().println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        response.getWriter().println("<title>Cars Form</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Find Car</h1>");
        response.getWriter().println("<form action=\"data\" method=\"GET\">");
        response.getWriter().println("<label for=\"Car Type\">Car Type:</label><br>");
        response.getWriter().println("<input type=\"text\" id=\"carType\" name=\"carType\" required><br><br>");
        response.getWriter().println("<input type=\"submit\" value=\"Submit\">");
        response.getWriter().println("</form>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}