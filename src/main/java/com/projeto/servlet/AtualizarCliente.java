/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.servlet;

import com.projeto.DAO.ClienteDAO;
import com.projeto.entidade.Cliente;
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
public class AtualizarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int ID_cliente = Integer.parseInt(request.getParameter("ID"));
            Cliente cliente = ClienteDAO.getCliente(ID_cliente);
            request.setAttribute("cliente", cliente);
            request.getRequestDispatcher("/clientes/cadastro.jsp").forward(request, response);
            
        } catch (Exception e) {
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            String CPF = request.getParameter("CPF");
            String Nome = request.getParameter("Nome");
            Cliente cli = new Cliente(ID, Nome, CPF);
            
            if (ClienteDAO.Atualizar(cli)) {
                response.sendRedirect(request.getContextPath()+"/sucesso.jsp");
            }else{
                String msg = "Não foi possível cadastrar no banco de dadods";
                request.setAttribute("msgErro", msg);
                request.getRequestDispatcher("/Erro.jsp").forward(request, response);
            }
            
        } catch (Exception e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }

}
