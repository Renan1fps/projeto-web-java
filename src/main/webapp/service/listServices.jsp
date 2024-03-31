<%@page import="java.util.List"%>
<%@page import="domain.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Serviços</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #dddddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: gray;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <% 
        List<Service> services = (List<Service>) request.getAttribute("services");
    %>
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Detalhes</th>
            </tr>
        </thead>
        <tbody>
            <% for(Service item: services) { %>
                <tr>
                    <td><%= item.getName() %></td>
                    <td><%= item.getDescription() %></td>
                    <td>
    					<a href="/teste/viewService?id=<%= item.getId() %>">Ver mais</a>
    					<a href="outra_pagina.jsp?id=<%= item.getId() %>">Excluir</a>
					</td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
