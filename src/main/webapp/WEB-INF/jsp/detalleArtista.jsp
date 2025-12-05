<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title> Detalle </title>
</head>

<body> 
    <h1> Detalle Artista </h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Biografía</th>
                <th>Fecha de creación</th>
                <th>Fecha de actualización</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${artista.id}</td>
                <td>${artista.nombre}</td>
                <td>${artista.apellido}</td>
                <td>${artista.biografia}</td>
                <td>${artista.fechaCreacion}</td>
                <td>${artista.fechaActualizacion}</td>
            </tr>
        </tbody>
    </table>

    <h2>Canciones del Artista</h2>
    <c:if test="${not empty artista.listaCanciones}">
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Álbum</th>
                    <th>Género</th>
                    <th>Idioma</th>
                    <th>Fecha de creación</th>
                    <th>Fecha de actualización</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cancion" items="${artista.listaCanciones}">
                    <tr>
                        <td>${cancion.id}</td>
                        <td>${cancion.titulo}</td>
                        <td>${cancion.album}</td>
                        <td>${cancion.genero}</td>
                        <td>${cancion.idioma}</td>
                        <td>${cancion.fechaCreacion}</td>
                        <td>${cancion.fechaActualizacion}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <a href="/artistas">Volver a lista de artistas </a>

    </body>
</html>