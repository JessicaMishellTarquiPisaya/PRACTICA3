<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <body>
        <h1>
            <c:if test = "${requestScope.op == 'nuevoCategorias'}" var="res" scope="request">
            Registro de
            </c:if>
            <c:if test = "${requestScope.op == 'modificarCategorias'}" var="res" scope="request">
            Modificar
            </c:if>
            categorias
        </h1>
        <jsp:useBean id="miCategoria" scope="request" class="com.emergentes.modelo.Categorias" />
    
        <form action="ControllerCategorias" method ="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id"
                               value="<jsp:setProperty name="miCategoria" property="id" />">
                    </td>
                </tr>
                
                <tr>
                    <td>Categorias</td>
                    <td><input type="text" name="categoria"
                               value="<jsp:setProperty name="miCategoria" property="categorias" />">
                    </td>
                </tr>
                 <tr>
                    <td>
                        <input type="hidden" name="opg" value="${requestScope.op}" />
                        <input type="hidden" name="op" value="grabar" />
                    </td>
                </tr>
                <tr>
                  <td></td>
                    <td><input type="submit" value="Enviar"></td>  
                </tr>
              
            </table>
        </form>
    </body>
</html>
