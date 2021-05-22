package com.projeto.servlet;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.entidade.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Icaro
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        String login = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        try {
            Funcionario fun = new Funcionario(senha, login);
            Funcionario funlogin = FuncionarioDAO.login(fun);
            if (funlogin != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", funlogin);
                response.sendRedirect(request.getContextPath()+"/protegido/home.jsp");
            }else{
                request.setAttribute("msgErro", "login inválido");
                request.getRequestDispatcher("/Erro.jsp").forward(request, response);
            }
        } catch (IOException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
        
    }

}
