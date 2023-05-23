package com.tms;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/book")
public class Book extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String bookTitle = req.getParameter("title");
            String fileName = bookTitle + ".txt";

            byte[] byteArray = Files.readAllBytes(Paths.get("D:\\" + fileName));

            ServletOutputStream out = resp.getOutputStream();
            resp.setContentType("application/txt");
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            out.write(byteArray);
            out.close();

            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            resp.getWriter().print("Something wrong");
            System.out.println("Something wrong " + e);
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}

