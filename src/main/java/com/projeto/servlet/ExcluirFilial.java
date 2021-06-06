package com.projeto.servlet;

import com.projeto.DAO.FilialDAO;
import com.projeto.entidade.Filial;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExcluirFilial extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            Filial fil = new Filial(ID);
            
            Retorno.sendRedirecionar(FilialDAO.Excluir(fil), response, request);
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}
