<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title> Detalle </title>
</head>

<body>
    <h1> Detalle de canción </h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Álbum</th>
                <th>Género</th>
                <th>Idioma</th>
                <th>Fecha de creación</th>
                <th>Fecha de actualización </th>
            </tr>
        </thead>
        <tbody>
            <tr>
            <td>${cancion.id}</td>
            <td>${cancion.titulo}</td>
            <td>${cancion.artista}</td>
            <td>${cancion.album}</td>
            <td>${cancion.genero}</td>
            <td>${cancion.idioma}</td>
            <td>${cancion.fechaCreacion}</td>
            <td>${cancion.fechaActualizacion}</td>
            </tr>
        </tbody>
    </table>
    <br>
    <a href="/canciones"> Volver a lista de canciones </a>
    <a href="/canciones/formulario/editar/${idCancion}">Editar Canción </a>
</body>
</html>
