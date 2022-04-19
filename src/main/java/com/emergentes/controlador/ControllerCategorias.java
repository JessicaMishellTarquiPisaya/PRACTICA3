package com.emergentes.controlador;

import com.emergentes.modelo.GestorCategorias;
import com.emergentes.modelo.Categorias;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ControllerCategorias", urlPatterns = {"/ControllerCategorias"})
public class ControllerCategorias extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Categorias objCategoria = new Categorias();
        int id;
        int pos;
        String opcion = request.getParameter("op");
        String op = (opcion != null) ? request.getParameter("op") : "view";
        
        if ( op.equals("nuevo")){
            HttpSession ses = request.getSession();
            GestorCategorias agenda = (GestorCategorias) ses.getAttribute("agenda");
            objCategoria.setId(agenda.obtieneId());
            request.setAttribute("op", op);
            request.setAttribute("miCategoria", objCategoria);
            request.getRequestDispatcher("editarCategorias.jsp").forward(request, response);
        }
        
        if(op.equals("modificarCategorias")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorCategorias agenda = (GestorCategorias) ses.getAttribute("agenda");
            pos = agenda.ubicarCategorias(id);
            objCategoria = agenda.getLista().get(pos);
            
            request.setAttribute("op", op);
            request.setAttribute("miCategoria", objCategoria);
            request.getRequestDispatcher("editarCategorias.jsp").forward(request, response);
        }
        
        if(op.equals("eliminarCategorias")){
            id = Integer.parseInt(request.getParameter("id"));
            HttpSession ses = request.getSession();
            GestorCategorias agenda = (GestorCategorias) ses.getAttribute("agenda");
            pos = agenda.ubicarCategorias(id);
            agenda.eliminarCategorias(pos);
            ses.setAttribute("agenda", agenda);
            response.sendRedirect("indexCategorias.jsp");
        }
        
        if(op.equals("view")){
            response.sendRedirect("indexCategorias.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Categorias objCategoria = new Categorias();
        int pos;
        String op = request.getParameter("op");
        
        if (op.equals("grabar")){
            //Recuperar valores del formulario
            //Verificar si es nuevo o ese una modificacion
            
            objCategoria.setId(Integer.parseInt(request.getParameter("id")));
            objCategoria.setCategoria(request.getParameter("categoria"));
            
            HttpSession ses = request.getSession();
            GestorCategorias agenda = (GestorCategorias) ses.getAttribute("agenda");
            
            String opg = request.getParameter("opg");
            if(opg.equals("nuevo")){
                agenda.insertarCategorias(objCategoria);
            }
            else{
                pos = agenda.ubicarCategorias(objCategoria.getId());
                agenda.modificarCategorias(pos, objCategoria);
            }
            ses.setAttribute("agenda", agenda);
            response.sendRedirect("indexCategorias.jsp");
        }
    }
}