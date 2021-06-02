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
    private String Cidade;
    private String Estado;
    private String Endereco;
    private String Nome;
    private String Categoria;
    private String Endreco;
    private String Marca;
    private double V_tatal;
    private int QTD;
    private int Desconto;
    private int ID_CLI;
    private int ID_PED;
    private int ID_FIL;
    private String CPF;

    public Relatorio(Date Data_cri, String Nome, double V_tatal, String CPF) {
        this.Data_cri = Data_cri;
        this.Nome = Nome;
        this.V_tatal = V_tatal;
        this.CPF = CPF;
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

    public Relatorio(int IDP, int ID_CLI, Date Data_cri, double V_tatal, String Endreco) {
        this.ID_PED = IDP;
        this.ID_CLI = ID_CLI;
        this.Data_cri = Data_cri;
        this.V_tatal = V_tatal;
        this.Endreco = Endreco;
    }

    public Relatorio(String Nome_Pro, String Marca, String Categoria, int QTD, double V_tatal, int Desconto) {
        this.Nome = Nome_Pro;
        this.Marca = Marca;
        this.Categoria = Categoria;
        this.QTD = QTD;
        this.V_tatal = V_tatal;
        this.Desconto = Desconto;
    }

    public Relatorio(String Categoria, double V_tatal, int QTD) {
        this.Categoria = Categoria;
        this.V_tatal = V_tatal;
        this.QTD = QTD;
    }

    public Relatorio(String Cidade, String Estado, String Endereco, double V_tatal, int ID_FIL) {
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.Endereco = Endereco;
        this.V_tatal = V_tatal;
        this.ID_FIL = ID_FIL;
    }

    public void setQTD(int QTD) {
        this.QTD = QTD;
    }
    
    public void setID_FIL(int ID_FIL) {
        this.ID_FIL = ID_FIL;
    }

    public String getCPF() {
        return CPF;
    }

    public void setID_CLI(int ID_CLI) {
        this.ID_CLI = ID_CLI;
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

    public Date getData_cri() {
        return Data_cri;
    }

    public String getCidade() {
        return Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getNome() {
        return Nome;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getEndreco() {
        return Endreco;
    }

    public String getMarca() {
        return Marca;
    }

    public double getV_tatal() {
        return V_tatal;
    }

    public int getQTD() {
        return QTD;
    }

    public int getDesconto() {
        return Desconto;
    }

    public int getID_CLI() {
        return ID_CLI;
    }

    public int getID_PED() {
        return ID_PED;
    }

    public int getID_FIL() {
        return ID_FIL;
    }
    
}