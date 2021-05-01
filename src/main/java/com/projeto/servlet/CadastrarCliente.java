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
public class CadastrarCliente extends HttpServlet {
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String CPF = request.getParameter("CPF");
        String Nome = request.getParameter("Nome");
        
        try {
            Cliente cli = new Cliente(Nome, CPF);
            
            if (ClienteDAO.AddCliente(cli)) {
                response.sendRedirect(request.getContextPath()+"/sucesso.jsp");
            }else{
                String msg = "Não foi possível cadastrar no banco de dadods";
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
