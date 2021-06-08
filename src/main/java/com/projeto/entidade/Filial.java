package com.projeto.entidade;

/**
 * 
 * @author Icaro
 */
public class Filial {
    
    private int ID_filial;
    private String Cidade;
    private String Estado;
    private int CEP;
    private String Endereco;
    private int Numero;
    private String Complemento;

    public Filial(int ID_filial, String Cidade, String Estado, int CEP, String Endereco, int Numero, String Complemento) {
        this.ID_filial = ID_filial;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.CEP = CEP;
        this.Endereco = Endereco;
        this.Numero = Numero;
        this.Complemento = Complemento;
    }

    public Filial(String Cidade, String Estado, int CEP, String Endereco, int Numero, String Complemento) {
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.CEP = CEP;
        this.Endereco = Endereco;
        this.Numero = Numero;
        this.Complemento = Complemento;
    }
    
    public Filial(int ID_filial) {
        this.ID_filial = ID_filial;
    }

    public int getID_filial() {
        return ID_filial;
    }

    public void setID_filial(int ID_filial) {
        this.ID_filial = ID_filial;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }
}