package com.projeto.servlet;

import com.projeto.DAO.ClienteDAO;
import com.projeto.DAO.VendaDAO;
import com.projeto.entidade.Cliente;
import com.projeto.entidade.Venda;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Cadastrar de Venda.
 * @author Icaro
 * @author gianm
 */
public class CadastrarVendaServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            int IDF = Integer.parseInt(request.getParameter("ID"));
            String CPF = request.getParameter("CPF");
            Date date = Date.valueOf(LocalDate.now());
            
            Venda venda = (Venda)session.getAttribute("carrinho");
            venda.setCPF(CPF);
            venda.setId_funcionario(IDF);
            
            if (ClienteDAO.BobuscarCPF(venda)) {
                Cliente cli = ClienteDAO.getCliente(venda);
                venda.setID_Cliente(cli.getID_Cliente());
                venda.setData(date);
                if (VendaDAO.addVenda(venda)) {
                    session.removeAttribute("carrinho");
                    Retorno.sendRedirecionar(true, response, request);
                }else{
                    Retorno.sendRedirecionar(false, response, request);
                }
            }else{
                request.setAttribute("msgErro", "Cliente não encontrado");
                request.getRequestDispatcher("/Erro.jsp").forward(request, response);
            }
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Venda venda = (Venda)session.getAttribute("carrinho");
            request.setAttribute("venda", venda);
            request.getRequestDispatcher("/protegido/Vendas/cadastrar.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}