package com.tms;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@WebServlet("/book-load")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class BookLoad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Part filePart = req.getPart("file");
            String name = filePart.getSubmittedFileName();
            filePart.write("D:\\" + name);
            resp.getWriter().print("The file uploaded successfully");
            System.out.println("The file uploaded successfully");

            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            resp.getWriter().print("Something wrong");
            System.out.println("Something wrong " + e);
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
