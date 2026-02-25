<%@ page import="java.sql.*" %>
<html>
<body>

<h2>Admin Dashboard</h2>

<table border="1">
<tr>
<th>ID</th>
<th>Issue</th>
<th>Status</th>
</tr>

<%
Connection con = DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/citycare","root","");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM complaints");

while(rs.next()){
%>
<tr>
<td><%= rs.getInt("id") %></td>
<td><%= rs.getString("issue_type") %></td>
<td><%= rs.getString("status") %></td>
</tr>
<% } %>

</table>

</body>
</html>

