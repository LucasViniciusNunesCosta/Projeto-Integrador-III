package com.projeto.servlet;

import com.projeto.DAO.VendaDAO;
import com.projeto.entidade.Venda;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gianm
 */
@WebServlet(name = "CadastrarVendaServlet", urlPatterns = {"/CadastrarVendaServlet"})
public class CadastrarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            int idCliente = Integer.valueOf(request.getParameter("Cliente"));
            int idVendedor = Integer.valueOf(request.getParameter("Vendedor"));
            String nomeProduto = request.getParameter("NomeProduto");
            Double valorVenda = Double.valueOf(request.getParameter("Valor_venda"));
            int idFilial = Integer.valueOf(request.getParameter("Filial"));
            Date date = Date.valueOf(LocalDate.now());
            
            Venda venda = new Venda(date, nomeProduto, idVendedor, valorVenda, idCliente, idFilial);
            
            VendaDAO.addVenda(venda);
            
            Retorno.sendRedirecionar(VendaDAO.addVenda(venda), response, request);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
           
            
       
    }

}
