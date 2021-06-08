package com.projeto.servlet;

import com.projeto.DAO.EstoqueDAO;
import com.projeto.entidade.Item;
import com.projeto.entidade.Venda;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> manipulação do carrinho no site.
 * @author Icaro
 */
public class CarrinhoV extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            
            if (request.getParameter("Item")!=null) {
                
                String oitem = request.getParameter("Item");
                String[] ObjItem = oitem.split(",");
                int ID =  Integer.parseInt(ObjItem[0]);
                int QTD =  Integer.parseInt(ObjItem[1]);
                int Desconto =  Integer.parseInt(ObjItem[2]);
                Item item = new Item(ID, QTD, Desconto);
                item = EstoqueDAO.getItem(item);
                item.VTotalPorItem();
                
                if (session.getAttribute("carrinho")!=null) {
                    Venda venda =(Venda)session.getAttribute("carrinho");
                    venda.addItem(item);
                    session.setAttribute("carrinho", venda);
                }else{
                    Venda venda = new Venda(0, 0);
                    venda.addItem(item);
                    session.setAttribute("carrinho", venda);
                }
            }else if (request.getParameter("canpedido")!=null) {
                session.removeAttribute("carrinho");
            }else{
                Venda venda =(Venda)session.getAttribute("carrinho");
                List<Item> items = venda.getItems();
                request.setAttribute("listaItems", items);
                request.getRequestDispatcher("/protegido/Vendas/Carrinho.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}