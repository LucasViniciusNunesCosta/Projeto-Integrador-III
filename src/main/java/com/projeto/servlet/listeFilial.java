package com.projeto.servlet;

import com.projeto.DAO.FilialDAO;
import com.projeto.entidade.Filial;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listeFilial extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            List<Filial> listaFilial =  FilialDAO.getFiliais();
            request.setAttribute("listaFiliais", listaFilial);
            
            String action = request.getParameter("send");
            if (action!=null) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
            }
            
            request.getRequestDispatcher("/protegido/Filial/ListarFilial.jsp").forward(request, response);
        } catch (IOException | ServletException | IllegalArgumentException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            
            String Endereco = request.getParameter("Endereco");
            String action = request.getParameter("send");
            
            Filial fil = new Filial(0);
            fil.setEndereco(Endereco);
            
            if (!action.equals("")) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
            }
            
            List<Filial> listaFilial = FilialDAO.BuscarFilial(fil);
            request.setAttribute("listaFiliais", listaFilial);
            
            request.getRequestDispatcher("/protegido/Filial/ListarFilial.jsp").forward(request, response);
            
        } catch (IOException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }

}
