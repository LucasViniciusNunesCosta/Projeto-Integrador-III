package com.projeto.servlet;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.entidade.Funcionario;
import com.projeto.uteis.CryptoUtils;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Icaro
 */
public class AtualizarFuncionarioDados extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            Funcionario fun = new Funcionario(ID);
            fun = FuncionarioDAO.getFuncionario(fun);
            request.setAttribute("funcionario", fun);
            request.getRequestDispatcher("/protegido/use/FuncionarioDados.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            int ID = Integer.parseInt(request.getParameter("funcionarioID"));
            String Acao = request.getParameter("Acao");

            Funcionario fun = new Funcionario(ID);
            
            if (Acao.equals("Senha")) {
                fun.setSenha(CryptoUtils.HashSenha(request.getParameter("Senha")));
                Retorno.sendRedirecionar(FuncionarioDAO.AtualizarSenha(fun), response, request);
            }
            if (Acao.equals("Dados")) {
                fun.setNome(request.getParameter("Nome"));
                fun.setSobrenome(request.getParameter("Sobrenome"));
                fun.setEmail(request.getParameter("Email"));
                fun.setCPF(request.getParameter("CPF"));
                Retorno.sendRedirecionar(FuncionarioDAO.AtualizarDados(fun), response, request);
            }
        } catch (UnsupportedEncodingException | NumberFormatException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}