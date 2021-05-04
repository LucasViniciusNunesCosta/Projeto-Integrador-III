package com.projeto.servlet;

import com.projeto.DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Icaro
 */
public class ExcluirCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int ID_cliente = Integer.parseInt(request.getParameter("ID"));
            
            if (ClienteDAO.Excluir(ID_cliente)) {
                response.sendRedirect(request.getContextPath()+"/sucesso.jsp");
            }else{
                String msg = "Não foi possível Excluir do banco de dadods";
                request.setAttribute("msgErro", msg);
                request.getRequestDispatcher("/Erro.jsp").forward(request, response);
            }
        } catch (Exception e) {
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
        
    }
}
