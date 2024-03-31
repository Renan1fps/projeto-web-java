<%@page import="domain.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Serviço</title>
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

        .service-detail {
            margin-bottom: 20px;
        }

        .service-detail label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Detalhes do Serviço</h1>
        <div class="service-detail">
            <label>Nome:</label>
            <%= ((Service)request.getAttribute("service")).getName() %>
        </div>
        <div class="service-detail">
            <label>Descrição:</label>
            <%= ((Service)request.getAttribute("service")).getDescription() %>
        </div>
        <div class="service-detail">
            <label>Preço:</label>
            <%= ((Service)request.getAttribute("service")).getPrice() %>
        </div>
        <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/service/addSession.jsp'">Agendar</button>
    </div>
</body>
</html>
