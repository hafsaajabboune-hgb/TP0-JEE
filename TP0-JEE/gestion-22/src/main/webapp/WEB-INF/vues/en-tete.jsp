<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion Stock - Version 22</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f0f2f5;
        }

        .barre-navigation {
            background: #1a2c3e;
            color: white;
            padding: 15px 30px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        .barre-navigation a {
            color: white;
            text-decoration: none;
            margin-right: 25px;
            font-weight: 500;
        }

        .barre-navigation a:hover {
            text-decoration: underline;
        }

        .conteneur-principal {
            max-width: 1200px;
            margin: 25px auto;
            padding: 25px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.05);
            min-height: 500px;
        }

        .bouton {
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
        }

        .bouton-principal {
            background: #3498db;
            color: white;
        }

        .bouton-danger {
            background: #e74c3c;
            color: white;
        }

        .bouton-succes {
            background: #27ae60;
            color: white;
        }

        .bouton-secondaire {
            background: #95a5a6;
            color: white;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background: #1a2c3e;
            color: white;
        }

        tr:hover {
            background: #f5f5f5;
        }

        .groupe-formulaire {
            margin-bottom: 20px;
        }

        .groupe-formulaire label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #333;
        }

        .groupe-formulaire input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }

        .pied-page {
            text-align: center;
            margin-top: 30px;
            padding: 20px;
            background: #1a2c3e;
            color: white;
        }

        h2 {
            color: #1a2c3e;
            margin-bottom: 20px;
            border-bottom: 2px solid #3498db;
            padding-bottom: 10px;
        }

        .message-accueil {
            text-align: center;
            padding: 40px;
            background: #ecf0f1;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <div class="barre-navigation">
        <a href="${pageContext.request.contextPath}/">Accueil</a>
        <a href="${pageContext.request.contextPath}/artistes">Artistes</a>
        <a href="${pageContext.request.contextPath}/materiels">Materiels</a>
        <span style="float: right;">Gestion Stock v22</span>
    </div>
    <div class="conteneur-principal">