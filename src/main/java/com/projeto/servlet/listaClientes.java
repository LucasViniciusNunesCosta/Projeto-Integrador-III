package com.projeto.servlet;

import com.projeto.DAO.ClienteDAO;
import com.projeto.entidade.Cliente;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Icaro
 */
public class listaClientes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            List<Cliente> listaClientes = ClienteDAO.getClientes();
            request.setAttribute("listaClientes", listaClientes);
            
            String action = request.getParameter("send");
            if (action!=null) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
            }
            
            request.getRequestDispatcher("/protegido/clientes/ListaClientes.jsp").forward(request, response);
            
        } catch (IOException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }
}