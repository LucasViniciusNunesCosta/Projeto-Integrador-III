/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.servlet;

import com.projeto.DAO.FilialDAO;
import com.projeto.entidade.Filial;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas vinicius
 */
public class FilialServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try{
            List<Filial> listaFiliais = FilialDAO.getFiliais();
            String action = request.getParameter("send");
            if (action!=null) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
            }
            
            request.getRequestDispatcher("/protegido/Filiais/ListarFiliais.jsp").forward(request, response);
        } catch (IOException | ServletException | IllegalArgumentException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try{
            request.setCharacterEncoding("UTF-8");
            String Cidade = request.getParameter("Cidade");
            String Estado = request.getParameter("Estado");
            int CEP = Integer.valueOf(request.getParameter("CEP"));
            String Endereco = request.getParameter("Endereco");
            int Numero = Integer.valueOf(request.getParameter("Numero"));
            String Complemento = request.getParameter("Complemento");
            
            Filial filial = new Filial(CEP, Estado, Endereco, Numero, Complemento, Cidade);
            
          Retorno.sendRedirecionar(FilialDAO.cadastrar(filial), response, request);
           
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        } catch (IllegalArgumentException e){
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}
