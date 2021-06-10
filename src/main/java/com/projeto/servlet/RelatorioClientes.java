package com.projeto.servlet;

import com.projeto.DAO.RelatorioDAO;
import com.projeto.entidade.Relatorio;
import com.projeto.entidade.Venda;
import com.projeto.uteis.Retorno;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Servlet</b> Controller de solicitações e manipulação<br> Relatorio de Clientes.
 * @author Icaro
 */
public class RelatorioClientes extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String DFini = request.getParameter("inicio");
            String DFfim = request.getParameter("fim");
            
            Date Dini = Date.valueOf(DFini);
            Date Dfim = Date.valueOf(DFfim);
            
            Relatorio periodo = new Relatorio(Dini, Dfim);
            
            List<Venda> listaClientes = RelatorioDAO.RelatorioClienteData(periodo);

            request.setAttribute("listaClientes", listaClientes);
            request.setAttribute("periodo", periodo);
            request.getRequestDispatcher("/protegido/Relatorio/Cliente/RelatorioCliente.jsp").forward(request, response);
            
        } catch (IOException | ServletException | IllegalArgumentException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getParameter("Cliente")!=null) {
                String Obj = request.getParameter("Cliente");
                String[] Objs = Obj.split(",");

                String IDCLI = Objs[0];
                String DFini = Objs[1];
                String DFfim = Objs[2];

                Date Dini = Date.valueOf(DFini);
                Date Dfim = Date.valueOf(DFfim);

                Relatorio periodo = new Relatorio(Dini, Dfim);

                int ID = Integer.parseInt(IDCLI);
                periodo.setID_CLI(ID);

                List<Relatorio> listaPedidos = RelatorioDAO.RelatorioClienteDataID(periodo);
                request.setAttribute("listaPedidos", listaPedidos);
                request.setAttribute("periodo", periodo);
                
            } else if (request.getParameter("Pedido")!=null) {
                
                String Obj = request.getParameter("Pedido");
                String[] Objs = Obj.split(",");

                String IDPED = Objs[0];
                String DFini = Objs[1];
                String DFfim = Objs[2];

                Date Dini = Date.valueOf(DFini);
                Date Dfim = Date.valueOf(DFfim);

                Relatorio periodo = new Relatorio(Dini, Dfim);

                int IDP = Integer.parseInt(IDPED);
                periodo.setID_PED(IDP);

                List<Relatorio> listaPedido = RelatorioDAO.RelatorioClienteDataIDPedido(periodo);
                request.setAttribute("listaPedido", listaPedido);
                request.setAttribute("periodo", periodo);
            }
            
            request.getRequestDispatcher("/protegido/Relatorio/Cliente/RelatorioItens.jsp").forward(request, response);

        } catch (IOException | ServletException | IllegalArgumentException e) {
            Retorno.sendErro(e.getMessage(), response, request);
        }
    }
}