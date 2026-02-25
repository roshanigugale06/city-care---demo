package com.citycare.controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.citycare.util.DBConnection;

@WebServlet("/ReportServlet")
@MultipartConfig
public class ReportServlet extends HttpServlet {

 protected void doPost(HttpServletRequest req, HttpServletResponse res)
 throws IOException {

  try {
    String issue = req.getParameter("issueType");
    String desc = req.getParameter("description");
    String loc = req.getParameter("location");

    Part photo = req.getPart("photo");
    String fileName = photo.getSubmittedFileName();

    String path = getServletContext().getRealPath("") +
                  "uploads/complaints/";
    new File(path).mkdirs();
    photo.write(path + fileName);

    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement(
      "INSERT INTO complaints(issue_type,description,location,image,status) VALUES(?,?,?,?,?)");

    ps.setString(1, issue);
    ps.setString(2, desc);
    ps.setString(3, loc);
    ps.setString(4, fileName);
    ps.setString(5, "Submitted");

    ps.executeUpdate();
    res.getWriter().println("Complaint Submitted Successfully");

  } catch(Exception e) {
    e.printStackTrace();
  }
 }
}

