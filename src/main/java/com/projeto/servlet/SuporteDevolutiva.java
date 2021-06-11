package com.projeto.servlet;

import com.projeto.DAO.SuporteDAO;
import com.projeto.entidade.Suporte;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Devolutiva do Suporte.
 * @author Icaro
 */
public class SuporteDevolutiva extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            String ID = request.getParameter("ID");
            Suporte sup = new Suporte(Integer.parseInt(ID));
            sup = SuporteDAO.RequisicaoID(sup);
            request.setAttribute("solicitacao", sup);
            request.getRequestDispatcher("/protegido/suporte/Resposta.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            int IDfun = Integer.parseInt(request.getParameter("funcionarioID"));
            int IDReq = Integer.parseInt(request.getParameter("referencia"));
            String descricao = request.getParameter("descricao");
            //String Statu = request.getParameter("Status");
            Suporte sup = new Suporte(IDfun, "Devolutiva GTI", "Resposta", descricao, true, IDReq);
            Retorno.sendRedirecionar(SuporteDAO.RespostaRequisicao(sup), response, request);
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    public static boolean Status(String Statu){
        return Statu.equals("em Progresso");
    }
}
