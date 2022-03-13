<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="entity.Car" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать, JSP!</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Car model:</td>
        <td>Creation date:</td>
    </tr>
    <% List<Car> cars = (List<Car>) request.getAttribute("cars");
        for (int i = 0; i < cars.size(); i += 1) { %>
    <tr>
        <td><%= cars.get(i).getCarModel()%>
        </td>
        <td><%= cars.get(i).getCreationDate()%>
        </td>
    </tr>
    <% } %>
</table>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        out.println("<h2> Found Cookies Name and Value</h2>");
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("time")) {
                out.print("Name : " + cookie.getName() + ",  ");
                out.print("Value: " + cookie.getValue() + " <br/>");
            }
        }
    } else {
        out.println("<h2>No cookies founds</h2>");
    }
%>
</body>
</html>
