package com.citycare.controller;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.citycare.util.DBConnection;

@WebServlet("/TrackServlet")
public class TrackServlet extends HttpServlet {

 protected void doGet(HttpServletRequest req, HttpServletResponse res)
 throws IOException {

  try {
    int id = Integer.parseInt(req.getParameter("cid"));

    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement(
      "SELECT status FROM complaints WHERE id=?");
    ps.setInt(1, id);

    ResultSet rs = ps.executeQuery();

    if(rs.next())
      res.getWriter().println("Status: " + rs.getString("status"));
    else
      res.getWriter().println("Invalid Complaint ID");

  } catch(Exception e) {
    e.printStackTrace();
  }
 }
}

