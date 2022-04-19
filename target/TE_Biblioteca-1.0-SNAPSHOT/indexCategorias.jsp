<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Categorias"%>
<%@page import="com.emergentes.modelo.GestorCategorias"%>
<% 
       if (session.getAttribute("agenda") == null){
       GestorCategorias objeto1 = new GestorCategorias();
       
       objeto1.insertarCategorias(new Categorias(1, "Novela"));
       objeto1.insertarCategorias(new Categorias(2, "Historia"));
       objeto1.insertarCategorias(new Categorias(3, "Cuento"));
       
       session.setAttribute("agenda", objeto1);
       }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    
    <body>
        <h1>Lista de Categorias</h1>
        <a href ="ControllerCategorias?op=nuevo">Nuevo</a>  
        <br><br>
        <table border ="1">
            <tr> 
                <th>Id</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr> 
            <c:forEach var ="item" items="${sessionScope.agenda.getLista()}">
            <tr> 
                <td>${item.id}</td>
                <td>${item.categoria}</td>
                <td><a href="ControllerCategorias?op=modificar&id=${item.id}">Editar</a></td>
                <td><a href="ControllerCategorias?op=eliminar&id=${item.id}"
                    onclick='return confirm("Esta seguro de eliminar el registro ?");'>Eliminar</a></td>
            </tr>    
            </c:forEach>
            
        </table>
    
    </body>
</html>
