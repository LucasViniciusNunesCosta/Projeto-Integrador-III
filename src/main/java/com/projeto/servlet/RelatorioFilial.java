/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.servlet;

import com.projeto.DAO.RelatorioDAO;
import com.projeto.entidade.Relatorio;
import com.projeto.entidade.RelatorioPorFilial;
import com.projeto.entidade.Venda;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gianm
 */
@WebServlet(name = "RelatorioFilial", urlPatterns = {"/RelatorioFilial"})
public class RelatorioFilial extends HttpServlet {
    
    Date dataInicio;
    Date dataFim;
    int idFilial;
    String tipoBusca;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            this.dataInicio = Date.valueOf(request.getParameter("inicio"));
            this.dataFim = Date.valueOf(request.getParameter("fim"));
            this.idFilial = Integer.valueOf(request.getParameter("id"));
            this.tipoBusca = request.getParameter("select");
            System.out.println(dataInicio.getTime());
            RelatorioPorFilial relatorioPorFilial = new RelatorioPorFilial(idFilial, tipoBusca, dataInicio, dataFim);
            Relatorio periodo = new Relatorio(dataInicio, dataFim);
            List<Venda> listaPorFilial = RelatorioDAO.getListaRelatorioPorFilial(relatorioPorFilial);
            
            request.setAttribute("periodo", periodo);
            request.setAttribute("listaPorFilial", listaPorFilial);
            
            request.getRequestDispatcher("/Relatorio/Filial/RelatorioFilial.jsp").forward(request, response);
            
        }catch (IOException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }     
    }
}
