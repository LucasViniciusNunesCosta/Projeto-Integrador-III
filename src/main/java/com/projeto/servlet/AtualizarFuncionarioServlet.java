package com.projeto.servlet;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.entidade.Funcionario;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas vinicius
 */
public class AtualizarFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            Funcionario fun = new Funcionario(Integer.parseInt(request.getParameter("ID")));
            Funcionario funcionario = FuncionarioDAO.getFuncionario(fun);
            request.setAttribute("funcionario", funcionario);
            request.getRequestDispatcher("/protegido/Funcionarios/CadastroFuncionarios.jsp").forward(request, response);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            int ID = Integer.parseInt(request.getParameter("funcionarioID"));
            int IDFilial = Integer.parseInt(request.getParameter("filialID"));
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String atuacao = request.getParameter("Atuacao");
            double salario = Double.parseDouble(request.getParameter("salario").replaceAll(",", "."));
            
            Funcionario fun = new Funcionario(IDFilial, atuacao, salario, nome, sobrenome, cpf, ID, email);
            
            Retorno.sendRedirecionar(FuncionarioDAO.Atualizar(fun), response, request);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }
}
