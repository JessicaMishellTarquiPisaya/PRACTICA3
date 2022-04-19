<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Libros"%>
<%@page import="com.emergentes.modelo.GestorLibros"%>
<% 
       if (session.getAttribute("agenda") == null){
       GestorLibros objeto1 = new GestorLibros();
       
       objeto1.insertarLibros(new Libros(1, "El principito","Antonie de Sain","Si", "Cuento"));
       objeto1.insertarLibros(new Libros(2, "La conspiracion","Dan Brown","No", "Novela"));
       objeto1.insertarLibros(new Libros(3, "Historia de Bolivia","Historia","Si", "Novela"));
       
       session.setAttribute("agenda", objeto1);
       }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
    </head>
    
    <body>
        <h1>Lista de libros</h1>
        <a href ="ControllerLibros?op=nuevo">Nuevo</a>  
        <br><br>
        <table border ="1">
            <tr> 
                <th>Id</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Disponible</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr> 
            <c:forEach var ="item" items="${sessionScope.agenda.getLista()}">
            <tr> 
                <td>${item.id}</td>
                <td>${item.titulo}</td>
                <td>${item.autor}</td>
                <td>${item.disponible}</td>
                <td>${item.categoria}</td>
                <td><a href="ControllerLibros?op=modificar&id=${item.id}">Editar</a></td>
                <td><a href="ControllerLibros?op=eliminar&id=${item.id}"
                    onclick='return confirm("Esta seguro de eliminar el registro ?");'>Eliminar</a></td>
            </tr>    
            </c:forEach>
            
        </table>
    
    </body>
</html>
