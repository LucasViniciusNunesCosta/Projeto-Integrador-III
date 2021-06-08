package com.projeto.servlet;

import com.projeto.DAO.ClienteDAO;
import com.projeto.entidade.Cliente;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Atualizar de Cliente.
 * @author Icaro
 */
public class AtualizarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            Cliente cli = new Cliente(Integer.parseInt(request.getParameter("ID")));
            Cliente cliente = ClienteDAO.getCliente(cli);
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("/protegido/clientes/cadastro.jsp").forward(request, response);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            int ID = Integer.parseInt(request.getParameter("ID"));
            String CPF = request.getParameter("CPF");
            String Nome = request.getParameter("Nome");
            Cliente cli = new Cliente(ID, Nome, CPF);
            
            Retorno.sendRedirecionar(ClienteDAO.Atualizar(cli), response, request);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}