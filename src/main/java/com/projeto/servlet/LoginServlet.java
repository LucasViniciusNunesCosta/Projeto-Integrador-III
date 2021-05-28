package com.projeto.servlet;

import com.projeto.DAO.FuncionarioDAO;
import com.projeto.entidade.Funcionario;
import com.projeto.entidade.FuncionarioCargo;
import com.projeto.uteis.CryptoUtils;
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
        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("email");
        String senha = request.getParameter("senha");
        try {
            Funcionario fun = new Funcionario(login, senha);
            FuncionarioCargo funlogin = FuncionarioDAO.login(fun);
            funlogin.setCargo();
            if (CryptoUtils.ValidaSenha(fun.getSenha(), funlogin.getSenha())) {
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
        }catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("usuario");
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }

}
