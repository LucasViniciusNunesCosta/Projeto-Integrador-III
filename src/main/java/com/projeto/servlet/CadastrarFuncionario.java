package com.projeto.servlet;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.entidade.Funcionario;
import com.projeto.uteis.CryptoUtils;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> lista de funcionários e Cadastrar do Funcionario.
 * @author Icaro
 * @author lucas vinicius
 */
public class CadastrarFuncionario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
            request.setCharacterEncoding("UTF-8");
            int filialId = Integer.valueOf(request.getParameter("filialID"));
            String nome = request.getParameter("Nome");
            String Sobrenome = request.getParameter("Sobrenome");
            String email = request.getParameter("Email");
            String senha = request.getParameter("Senha");
            String cpf = request.getParameter("CPF");
            String atuacao = request.getParameter("Atuacao");
            double salario = Double.valueOf(request.getParameter("Salario"));
            
            senha = CryptoUtils.HashSenha(senha);
            
            Funcionario funcionario = new Funcionario(filialId, atuacao, salario, nome, Sobrenome, cpf, email, senha);

            Retorno.sendRedirecionar(FuncionarioDAO.cadastrar(funcionario), response, request);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}
