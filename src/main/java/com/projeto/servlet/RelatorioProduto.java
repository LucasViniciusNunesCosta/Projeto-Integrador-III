package com.projeto.servlet;

import com.projeto.DAO.RelatorioDAO;
import com.projeto.entidade.Relatorio;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Relatorio de Produtos.
 * @author Icaro
 */
public class RelatorioProduto extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            String DFini = request.getParameter("inicio");
            String DFfim = request.getParameter("fim");
            
            Date Dini = Date.valueOf(DFini);
            Date Dfim = Date.valueOf(DFfim);
            
            Relatorio periodo = new Relatorio(Dini, Dfim);
            
            List<Relatorio> listaProdutos = RelatorioDAO.RelatorioProdutoCategoriaData(periodo);

            request.setAttribute("listaProdutos", listaProdutos);
            request.setAttribute("periodo", periodo);
            request.getRequestDispatcher("/protegido/Relatorio/produto/RelatorioCategoria.jsp").forward(request, response);
            
        } catch (IOException | ServletException | IllegalArgumentException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}