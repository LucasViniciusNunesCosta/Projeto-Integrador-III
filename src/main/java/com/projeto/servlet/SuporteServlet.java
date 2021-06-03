package com.projeto.servlet;

import com.projeto.DAO.SuporteDAO;
import com.projeto.entidade.Funcionario;
import com.projeto.entidade.FuncionarioCargo;
import com.projeto.uteis.Retorno;
import com.projeto.entidade.Suporte;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Suporte.
 * @author Icaro
 */
public class SuporteServlet extends HttpServlet {

    /**
     * método de solicitação de dados do Suporte.
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("send");
            String Corrente = request.getParameter("Corrente");
            String ID = request.getParameter("ID");
            String minhas = request.getParameter("minha");
            
            if (action!=null) {
                Retorno acao = new Retorno(action);
                request.setAttribute("acao", acao);
                
                if (acao.isResponder()) {
                    HttpSession session = request.getSession();
                    FuncionarioCargo fun = (FuncionarioCargo)session.getAttribute("usuario");
                    List<Suporte> listaSuporte = SuporteDAO.RequisicaoFilial(fun);
                    request.setAttribute("listaSuporte", listaSuporte);
                    request.getRequestDispatcher("/protegido/suporte/listaSuporte.jsp").forward(request, response);
                    
                }else if (acao.isAtua() || acao.isApps() || acao.isHardware() || acao.isWebApp()) {
                    request.getRequestDispatcher("/protegido/suporte/suportefuncionario.jsp").forward(request, response);
                }
                
            } else if (Corrente!=null) {
                Suporte sup = new Suporte(Integer.parseInt(Corrente));
                List<Suporte> listaSuporte = SuporteDAO.RequisicaoCorrente(sup);
                request.setAttribute("listaSuporte", listaSuporte);
                request.getRequestDispatcher("/protegido/suporte/Corrente.jsp").forward(request, response);
                
            } else if (ID!=null) {
                Suporte sup = new Suporte(Integer.parseInt(ID));
                sup = SuporteDAO.RequisicaoID(sup);
                request.setAttribute("Requisicao", sup);
                request.getRequestDispatcher("/protegido/suporte/Resposta.jsp").forward(request, response);
                
            } else if (minhas!=null) {
                Funcionario fun = new Funcionario(Integer.parseInt(minhas));
                List<Suporte> listaSuporte = SuporteDAO.MinhaRequisicao(fun);
                request.setAttribute("listaSuporte", listaSuporte);
                request.getRequestDispatcher("/protegido/suporte/listaSuporte.jsp").forward(request, response);
                
            }
        } catch (IOException | ServletException | NumberFormatException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            int funcionarioID = Integer.parseInt(request.getParameter("funcionarioID"));
            String topico = request.getParameter("topico");
            String assunto = request.getParameter("Assunto");    
            String descricao = request.getParameter("descricao");
            
            Suporte sup = new Suporte(topico, assunto, descricao, false);
            sup.setID_Funcionario(funcionarioID);
            Retorno.sendRedirecionar(SuporteDAO.NovaRequisicao(sup), response, request);
        } catch (IOException | NumberFormatException | ServletException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }

}
