<%@page import="infra.InMemoryRepositoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="domain.Service"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulário de Sessão</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 600px;
            margin: auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="date"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 15px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Formulário de Sessão</h1>
        <form action="http://localhost:8080/teste/addSession" method="post"> 
            <label for="date">Data:</label>
            <input type="date" id="date" name="date" required>
            
            <label for="service">Serviço:</label>
            <select id="service" name="service" required>
                <option value="">Selecione um serviço</option>
                <% 
                    List<Service> services = InMemoryRepositoryService.getInstance().fidAll();
                    for (Service service : services) {
                %>
                    <option value="<%= service.getId() %>"><%= service.getName() %></option>
                <% } %>
            </select>
            
            <button type="submit">Enviar</button>
        </form>
    </div>
</body>
</html>
