package com.projeto.servlet;

import com.projeto.DAO.RelatorioDAO;
import com.projeto.entidade.Relatorio;
import com.projeto.entidade.Venda;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Icaro
 */
public class RelatorioClientes extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String DFini = request.getParameter("inicio");
            String DFfim = request.getParameter("fim");
            String IDCLI = request.getParameter("ID");
            
            Date Dini = Date.valueOf(DFini);
            Date Dfim = Date.valueOf(DFfim);
            
            Relatorio periodo = new Relatorio(Dini, Dfim);
            
            if (IDCLI!=null && !"".equals(IDCLI)) {
                int ID = Integer.parseInt(IDCLI);
                periodo.setID_CLI(ID);
                
                List<Relatorio> listaPedidos = RelatorioDAO.RelatorioClienteDataID(periodo);
                request.setAttribute("listaPedidos", listaPedidos);
                request.setAttribute("periodo", periodo);
                request.getRequestDispatcher("/Relatorio/RelatorioItens.jsp").forward(request, response);
            }else{
                List<Venda> listaClientes = RelatorioDAO.RelatorioClienteData(periodo);

                request.setAttribute("listaClientes", listaClientes);
                request.setAttribute("periodo", periodo);
                request.getRequestDispatcher("/Relatorio/RelatorioCliente.jsp").forward(request, response);
            }
            
        } catch (IOException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }
    }
}