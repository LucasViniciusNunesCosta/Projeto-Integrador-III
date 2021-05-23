package com.projeto.servlet;

import com.projeto.DAO.RelatorioDAO;
import com.projeto.entidade.Relatorio;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author icaro
 * @author gianm
 */
public class RelatorioFilial extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            String Obj = request.getParameter("Filial");
            String[] Objs = Obj.split(",");

                String IDCLI = Objs[0];
                String DFini = Objs[1];
                String DFfim = Objs[2];

                Date Dini = Date.valueOf(DFini);
                Date Dfim = Date.valueOf(DFfim);

                Relatorio periodo = new Relatorio(Dini, Dfim);

                int ID = Integer.parseInt(IDCLI);
                periodo.setID_FIL(ID);
                
                List<Relatorio> listaPorFilialID = RelatorioDAO.RelatorioFilialDataID(periodo);
                
                request.setAttribute("periodo", periodo);
                request.setAttribute("listaPorFilialID", listaPorFilialID);
                
                request.getRequestDispatcher("/protegido/Relatorio/Filial/RelatorioFilial.jsp").forward(request, response);
        } catch (IOException | NumberFormatException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }     
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        try {
            String DFini = request.getParameter("inicio");
            String DFfim = request.getParameter("fim");
            
            Date Dini = Date.valueOf(DFini);
            Date Dfim = Date.valueOf(DFfim);
            
            Relatorio periodo = new Relatorio(Dini, Dfim);
            
            List<Relatorio> listaPorFilial = RelatorioDAO.RelatorioFilialData(periodo);
            
            request.setAttribute("periodo", periodo);
            request.setAttribute("listaPorFilial", listaPorFilial);
            
            request.getRequestDispatcher("/protegido/Relatorio/Filial/RelatorioFilial.jsp").forward(request, response);
            
        }catch (IOException | ServletException e) {
            request.setAttribute("msgErro", e);
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        } catch (IllegalArgumentException e){
            request.setAttribute("msgErro", e.getMessage());
            request.getRequestDispatcher("/Erro.jsp").forward(request, response);
        }     
    }
}
