<%@ page import="com.example.demo.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: luoji
  Date: 2021/2/8
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table border="1px">
    <%
        UserBean user = (UserBean) request.getAttribute("USERLIST");
    %>
    <tr>
        <td>email:</td>
        <td>Password:</td>
        <td>Confirm Password:</td>
        <td>Gender:</td>
        <td>Country:</td>
        <td>Hobby:</td>
        <td>Address:</td>
    </tr>
    <tr>
        <td><%=user.getEmail()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getConfirmPassword()%></td>
        <td><%=user.getGender()%></td>
        <td><%=user.getCountry()%></td>
        <td><%=user.getHobby()%></td>
        <td><%=user.getAddress()%></td>
    </tr>
</table>
