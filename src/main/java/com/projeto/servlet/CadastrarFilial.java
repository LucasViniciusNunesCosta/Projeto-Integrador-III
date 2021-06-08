package com.projeto.servlet;

import com.projeto.DAO.FilialDAO;
import com.projeto.entidade.Filial;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Cadastrar da Filial.
 * @author Icaro
 * @author lucas vinicius
 */
public class CadastrarFilial extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            request.setCharacterEncoding("UTF-8");
            String Cidade = request.getParameter("Cidade");
            String Estado = request.getParameter("Estado");
            int CEP = Integer.valueOf(request.getParameter("CEP"));
            String Endereco = request.getParameter("Endereco");
            int Numero = Integer.valueOf(request.getParameter("Numero"));
            String Complemento = request.getParameter("Complemento");

            Filial filial = new Filial(Cidade, Estado, CEP, Endereco, Numero, Complemento);

            Retorno.sendRedirecionar(FilialDAO.cadastrar(filial), response, request);

        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}