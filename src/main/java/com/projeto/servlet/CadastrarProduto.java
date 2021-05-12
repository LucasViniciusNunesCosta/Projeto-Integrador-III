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
 *
 * @author Icaro
 */
public class CadastrarProduto extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        try {
            String Nome = request.getParameter("Nome");
            String Marca = request.getParameter("Marca");
            String Categoria = request.getParameter("Categoria");
            int QTD = Integer.parseInt(request.getParameter("Quatidade"));
            double V_compra = Double.parseDouble(request.getParameter("Valor_compra").replaceAll(",", "."));
            double V_venda = Double.parseDouble(request.getParameter("Valor_venda").replaceAll(",", "."));
            int Filial_ID = Integer.parseInt(request.getParameter("Filial"));
            
            Estoque est = new Estoque(Filial_ID, Nome, Marca, Categoria, QTD, V_compra, V_venda);
            
            Retorno.sendRedirecionar(EstoqueDAO.AddEstoque(est), response, request);
            
        } catch (IOException | NumberFormatException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }
    
}