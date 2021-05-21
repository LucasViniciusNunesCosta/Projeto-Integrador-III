package com.projeto.servlet;

import com.projeto.entidade.Item;
import com.projeto.entidade.Venda;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
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
                Item item = new Item(QTD, ID);

                
                if (session.getAttribute("carrinho")!=null) {
                    Venda venda =(Venda)session.getAttribute("carrinho");
                    venda.addItem(item);
                    session.setAttribute("carrinho", venda);
                }else{
                    Venda venda = new Venda(0, 0);
                    venda.addItem(item);
                    session.setAttribute("carrinho", venda);
                }
            }else{
                Venda venda =(Venda)session.getAttribute("carrinho");
                List<Item> items = venda.getItems();
                request.setAttribute("listaItems", items);
            }
            
        } catch (NumberFormatException e) {
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }
}
