package com.tms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ageControl")
public class AgeControl extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameterAge = req.getParameter("age");

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        try {
            int age = Integer.parseInt(parameterAge);
            if (age >= 18 ){
                printWriter.println("<h1> Совершеннолетний </h1>");
            }else {
                printWriter.println("<h1> Несовершеннолетний </h1>");
            }

        } catch (NumberFormatException e) {
            printWriter.println("<h1> Неправильный формат параметра. </h1>");
        }

        printWriter.close();
    }
}
