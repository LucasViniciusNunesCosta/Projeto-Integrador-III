package com.projeto.servlet;

import com.projeto.DAO.FilialDAO;
import com.projeto.entidade.Filial;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizarFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            Filial fil = new Filial(Integer.parseInt(request.getParameter("ID")));
            Filial filial = FilialDAO.getFilial(fil);
            request.setAttribute("filial", filial);
            request.getRequestDispatcher("/protegido/Filial/CadastroFilial.jsp").forward(request, response);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String Cidade = request.getParameter("Cidade");
            String Estado = request.getParameter("Estado");
            int CEP = Integer.parseInt(request.getParameter("CEP"));
            String Endereco = request.getParameter("Endereco");
            int Numero = Integer.parseInt(request.getParameter("Numero"));
            String Complemento = request.getParameter("Complemento");
            
            Filial fil = new Filial(Cidade, Estado, CEP, Endereco, Numero, Complemento);
            
            Retorno.sendRedirecionar(FilialDAO.Atualizar(fil), response, request);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}
