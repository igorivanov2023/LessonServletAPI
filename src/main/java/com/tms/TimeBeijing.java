package com.tms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/beijing_time")
public class TimeBeijing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ZoneId zone = ZoneId.of("Asia/Shanghai");
        ZonedDateTime currentTime = ZonedDateTime.now(zone);
        LocalTime localCurrentTime = currentTime.toLocalTime();

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1> Время в Пекине: " + localCurrentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "</h1>");
        printWriter.close();

    }
}
