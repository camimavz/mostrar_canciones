<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title> Canciones </title>
</head>

<body>
    <h1> Canciones </h1>

    <table border="1"> 
        <thead>
            <tr>
                <th>Título</th>
                <th>Artista</th>
                <th>Detalle</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cancion" items="${listaCanciones}">
                <tr>
                    <td>${cancion.titulo}</td>
                    <td>${cancion.artista}</td>
                    <td> <a href="/canciones/detalle/${cancion.id}"> Detalle </a> </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/canciones/formulario/agregar">Agrega una canción </a>
</body>