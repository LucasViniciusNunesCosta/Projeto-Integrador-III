package com.projeto.entidade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gianm
 */
public class RelatorioPorFilial{
    
    private int filialId;
    private String tipoDeBusca;
    private Date dataInicio;
    private Date dataFim;
    private List<Venda> listaVendas = new ArrayList<>();

    public RelatorioPorFilial(int filialId, String tipoDeBusca, Date dataInicio, Date dataFim) {
        this.filialId = filialId;
        this.tipoDeBusca = tipoDeBusca;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public int getFilialId() {
        return filialId;
    }

    public void setFilialId(int filial) {
        this.filialId = filial;
    }

    public String getTipoDeBusca() {
        return tipoDeBusca;
    }

    public void setTipoDeBusca(String tipoDeBusca) {
        this.tipoDeBusca = tipoDeBusca;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public List<Venda> getListaVendas() {
        return listaVendas;
    }

    public void setListaVendas(List<Venda> listaVendas) {
        this.listaVendas = listaVendas;
    }
    
}
