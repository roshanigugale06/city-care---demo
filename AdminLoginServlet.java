package com.citycare.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {

 protected void doPost(HttpServletRequest req, HttpServletResponse res)
 throws IOException {

  String u = req.getParameter("username");
  String p = req.getParameter("password");

  if(u.equals("admin") && p.equals("admin123")) {
    res.sendRedirect("admin/dashboard.jsp");
  } else {
    res.getWriter().println("Invalid Login");
  }
 }
}

