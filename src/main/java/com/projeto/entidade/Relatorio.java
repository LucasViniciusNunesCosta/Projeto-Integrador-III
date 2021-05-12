package com.projeto.entidade;

import java.sql.Date;

/**
 *
 * @author Icaro
 */
public class Relatorio {
    
    private Date Data_inicio;
    private Date Data_fim;
    private Date Data_cri;
    private String Nome_Pro;
    private String Categoria;
    private String Endreco;
    private double V_tatal;
    private int QTD;
    private int ID_CLI;
    private int ID_PED;

    public Relatorio(int ID_PED, Date Data_cri, String Nome_Pro, String Categoria,int QTD, double V_tatal, String Endreco) {
        this.Data_cri = Data_cri;
        this.Nome_Pro = Nome_Pro;
        this.Categoria = Categoria;
        this.Endreco = Endreco;
        this.V_tatal = V_tatal;
        this.QTD = QTD;
        this.ID_PED = ID_PED;
    }
    
    public Relatorio(Date Data_inicio, Date Data_fim, int ID_CLI) {
        this.Data_inicio = Data_inicio;
        this.Data_fim = Data_fim;
        this.ID_CLI = ID_CLI;
    }
    
    public Relatorio(Date Data_inicio, Date Data_fim) {
        this.Data_inicio = Data_inicio;
        this.Data_fim = Data_fim;
    }

    public String getNome_Pro() {
        return Nome_Pro;
    }

    public void setNome_Pro(String Nome_Pro) {
        this.Nome_Pro = Nome_Pro;
    }

    public Date getData_cri() {
        return Data_cri;
    }

    public void setData_cri(Date Data_cri) {
        this.Data_cri = Data_cri;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getEndreco() {
        return Endreco;
    }

    public void setEndreco(String Endreco) {
        this.Endreco = Endreco;
    }

    public double getV_tatal() {
        return V_tatal;
    }

    public void setV_tatal(double V_tatal) {
        this.V_tatal = V_tatal;
    }

    public int getQTD() {
        return QTD;
    }

    public void setQTD(int QTD) {
        this.QTD = QTD;
    }

    public int getID_CLI() {
        return ID_CLI;
    }

    public void setID_CLI(int ID_CLI) {
        this.ID_CLI = ID_CLI;
    }

    public int getID_PED() {
        return ID_PED;
    }

    public void setID_PED(int ID_PED) {
        this.ID_PED = ID_PED;
    }

    public Date getData_inicio() {
        return Data_inicio;
    }

    public Date getData_fim() {
        return Data_fim;
    }
}