package com.projeto.servlet;

import com.projeto.DAO.EstoqueDAO;
import com.projeto.entidade.Estoque;
import com.projeto.entidade.Filial;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> lista do Estoque.
 * @author Icaro
 */
public class listaEstoque extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            if (request.getParameter("ID")!=null) {
                
                int ID = Integer.parseInt(request.getParameter("ID"));
                Filial fil = new Filial(ID);
                List<Estoque> listaEtoqueFilial = EstoqueDAO.getEstoqueFilial(fil);
                request.setAttribute("listaEtoqueFilial", listaEtoqueFilial);
                request.getRequestDispatcher("/protegido/Vendas/Carrinho.jsp").forward(request, response);
                
            }else{
                List<Estoque> listaEtoque = EstoqueDAO.getEstoque();
                request.setAttribute("listaEstoque", listaEtoque);

                String action = request.getParameter("send");
                if (action!=null) {
                    Retorno acao = new Retorno(action);
                    request.setAttribute("acao", acao);
                }

                request.getRequestDispatcher("/protegido/estoque/ListaEstoque.jsp").forward(request, response);
            }
            
        } catch (IOException | ServletException | IllegalArgumentException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String Nome = request.getParameter("Nome");
            String action = request.getParameter("send");
            
            Estoque pro = new Estoque(Nome);
            
            if (request.getParameter("ID")!=null) {
                
                int ID = Integer.parseInt(request.getParameter("ID"));
                Filial fil = new Filial(ID);
                
                List<Estoque> listaEtoqueFilial = EstoqueDAO.BuscarEstoqueFilial(pro, fil);
                request.setAttribute("listaEtoqueFilial", listaEtoqueFilial);
                
                request.getRequestDispatcher("/protegido/Vendas/Carrinho.jsp").forward(request, response);
                
            }else{
                
                if (!action.equals("")) {
                    Retorno acao = new Retorno(action);
                    request.setAttribute("acao", acao);
                }

                List<Estoque> listaEtoque = EstoqueDAO.BuscarEstoque(pro);
                request.setAttribute("listaEstoque", listaEtoque);

                request.getRequestDispatcher("/protegido/estoque/ListaEstoque.jsp").forward(request, response);
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}