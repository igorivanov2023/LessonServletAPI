package com.tms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkInformation")
public class CheckInformation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");

        if (name.isEmpty() || age.isEmpty() || gender.isEmpty()){
            req.getRequestDispatcher("/save-request.jsp").forward(req,resp);
        } else {
            req.setAttribute("name",name);
            req.setAttribute("age",age);
            req.setAttribute("gender",gender);
            req.getRequestDispatcher("/success-request.jsp").forward(req,resp);
        }

    }
}
