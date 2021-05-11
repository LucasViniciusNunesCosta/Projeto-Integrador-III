/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.servlet;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas vinicius
 */
@WebServlet(name = "AtualizarFuncionarioServlet", urlPatterns = {"/AtualizarFuncionarioServlet"})
public class AtualizarFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int filialId = Integer.valueOf(request.getParameter("filialID"));
            int Id = Integer.valueOf(request.getParameter("funcionarioID"));
            String atuacao = request.getParameter("atuacao");
            double salario = Double.valueOf(request.getParameter("salario"));
            String senha = request.getParameter("senha");
            String login = request.getParameter("login");
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            Funcionario funcionario = new Funcionario(filialId, Id, atuacao, salario, senha, login, nome, cpf, email);
            boolean ok = FuncionarioDAO.cadastrar(funcionario);
            sendRedirect(ok, response);
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public static void sendRedirect(boolean ok, HttpServletResponse response) throws IOException {
        if (ok) {
            response.sendRedirect("sucesso.jsp");
        } else {
            response.sendRedirect("erro.jsp");
        }
    }
}
