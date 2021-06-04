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
 * <b>Servlet</b> Controller de solicitações e manipulação<br> lista de Clientes.
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
            
        } catch (IOException | ServletException | IllegalArgumentException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String Nome = request.getParameter("Nome");
            String action = request.getParameter("send");
            
            Cliente cli = new Cliente(Nome);
            
            if (!action.equals("")) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
            }
            
            List<Cliente> listaClientes = ClienteDAO.BuscarClientes(cli);
            request.setAttribute("listaClientes", listaClientes);
            
            request.getRequestDispatcher("/protegido/clientes/ListaClientes.jsp").forward(request, response);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}