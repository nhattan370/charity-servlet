<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>User Accounts</h2>
<table>
    <tr>
        <th>Email</th>
        <th>Password</th>
    </tr>
    <%
        String[][] users = {
                {"an.nguyen@mail.com", "pass123"},
                {"bich.tran@mail.com", "pass123"},
                {"cuong.le@mail.com", "pass123"},
                {"dung.pham@mail.com", "pass123"},
                {"e.nguyen@mail.com", "pass123"},
                {"f.tran@mail.com", "pass123"},
                {"giang.le@mail.com", "pass123"},
                {"h.pham@mail.com", "pass123"},
                {"i.nguyen@mail.com", "pass123"},
                {"j.tran@mail.com", "pass123"}
        };

        for (String[] u : users) {
    %>
    <tr>
        <td><%= u[0] %></td>
        <td><%= u[1] %></td>
    </tr>
    <% } %>
</table>
</body>
</html>