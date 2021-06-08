package com.projeto.servlet;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.entidade.Funcionario;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> lista de Funcionario.
 * @author Icaro
 */
public class listeFuncionario extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            List<Funcionario> listaFuncionarios = FuncionarioDAO.getFuncionarios();
            request.setAttribute("listaFuncionarios", listaFuncionarios);
            
            String action = request.getParameter("send");
            if (action!=null) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
            }
            
            request.getRequestDispatcher("/protegido/Funcionarios/ListarFuncionarios.jsp").forward(request, response);
        } catch (IOException | ServletException | IllegalArgumentException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String Nome = request.getParameter("Nome");
            String action = request.getParameter("send");
            
            Funcionario fun = new Funcionario(Nome, 0);
            
            if (!action.equals("")) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
            }
            
            List<Funcionario> listaFuncionarios = FuncionarioDAO.BuscarFuncionario(fun);
            request.setAttribute("listaFuncionarios", listaFuncionarios);
            
            request.getRequestDispatcher("/protegido/Funcionarios/ListarFuncionarios.jsp").forward(request, response);
            
        } catch (IOException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}