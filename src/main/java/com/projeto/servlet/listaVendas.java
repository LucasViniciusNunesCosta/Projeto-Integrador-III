package com.projeto.servlet;

import com.projeto.DAO.VendaDAO;
import com.projeto.entidade.Venda;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Icaro
 */
public class listaVendas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            List<Venda> vendas = VendaDAO.getVendas();
            request.setAttribute("vendas", vendas);
            request.getRequestDispatcher("/protegido/Vendas/listaVendas.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}
