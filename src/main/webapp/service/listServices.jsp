<%@page import="java.util.List"%>
<%@page import="domain.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Serviços</title>
</head>
<body>
    <% 
        List<Service> services = (List<Service>) request.getAttribute("services");
    %>
    <table border="1">
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th>id</th>
            <th></th>
        </tr>
         <tbody>
            <% for(Service item: services) { %>
                <tr>
                    <td><%= item.getName() %></td>
                    <td><%= item.getDescription() %></td>
                    <td><%= item.getId() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>