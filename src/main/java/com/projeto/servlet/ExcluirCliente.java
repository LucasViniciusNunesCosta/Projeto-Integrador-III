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
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Excluir do Cliente.
 * @author Icaro
 */
public class ExcluirCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        try {
            Cliente cli = new Cliente(Integer.parseInt(request.getParameter("ID")));
            
            Retorno.sendRedirecionar(ClienteDAO.Excluir(cli), response, request);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}