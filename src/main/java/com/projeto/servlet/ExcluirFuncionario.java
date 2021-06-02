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
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Excluir do Funcionario.
 * @author Icaro
 */
public class ExcluirFuncionario extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            Funcionario fun = new Funcionario(ID);
            
            Retorno.sendRedirecionar(FuncionarioDAO.Excluir(fun), response, request);
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}
