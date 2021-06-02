package com.projeto.servlet;

import com.projeto.uteis.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Icaro
 */
public class Suporte extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            String action = request.getParameter("send");
            if (action!=null) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
                if (!acao.isAtua()) {
                    request.getRequestDispatcher("/protegido/suporte/suportefuncionario.jsp").forward(request, response);
                }else{
                    
                }
            }
            
        } catch (IOException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    }

}
