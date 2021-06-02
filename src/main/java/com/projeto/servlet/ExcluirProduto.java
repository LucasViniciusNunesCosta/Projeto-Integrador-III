package com.projeto.servlet;

import com.projeto.DAO.EstoqueDAO;
import com.projeto.entidade.Estoque;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Excluir do Produto.
 * @author Icaro
 */
public class ExcluirProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        try {
            Estoque est = new Estoque(Integer.parseInt(request.getParameter("ID")));
            
            Retorno.sendRedirecionar(EstoqueDAO.Excluir(est), response, request);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }

}
