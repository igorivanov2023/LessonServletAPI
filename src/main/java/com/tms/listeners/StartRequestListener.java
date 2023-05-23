package com.tms.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@WebListener
public class StartRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        String nameRequest = req.getRequestURI();

        LocalTime currentTime = LocalTime.now();
        System.out.println("Request " +  nameRequest.substring(1) + " : " + currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}
