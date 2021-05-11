/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.servlet;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.entidade.Funcionario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas vinicius
 */
@WebServlet(name = "FuncionarioServlet", urlPatterns = {"/FuncionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Funcionario> listaFuncionarios = FuncionarioDAO.getFuncionarios();
        request.setAttribute("listaFuncionarios", listaFuncionarios);
        request.getRequestDispatcher("/Funcionarios/ListarFuncionarios.jsp").forward(request, response);
   }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperar os parametros
        //int filialId = Integer.parseInt(request.getParameter("filialId"));
       try{
        int filialId = Integer.valueOf(request.getParameter("filialID"));
        //int funcionarioId = Integer.parseInt(request.getParameter("funcionarioId"));
        int Id = Integer.valueOf(request.getParameter("funcionarioID"));
        String atuacao = request.getParameter("atuacao");
        //double salario =  Double.parseDouble(request.getParameter("salario"));
        double salario = Double.valueOf(request.getParameter("salario"));
        String senha = request.getParameter("senha");
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        
        //inserir o funcionario no banco de dados
        Funcionario funcionario = new Funcionario(filialId, Id, atuacao, salario, senha, login, nome, cpf, email);
        boolean ok = FuncionarioDAO.cadastrar(funcionario);
       
        //redirecionar para a tela de sucesso/erro
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
        } else {
            String msg = "Não foi possível cadastrar o cliente";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
       }catch (IOException | NumberFormatException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}
