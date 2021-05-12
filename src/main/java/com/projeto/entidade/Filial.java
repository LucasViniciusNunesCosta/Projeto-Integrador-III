package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Filial {
    
    private int ID_filial;
    private String Cidade;
    private String Estado;
    private String CEP;
    private String Endereco;
    private int numero;
    private String complemento;

    public Filial(int id, String cep, String regiao, String local, int numero, String complemento) {
        this.ID_filial = id;
        this.CEP = cep;
        this.Estado = regiao;
        this.Endereco = local;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Filial(int id, String cep, String regiao, String local, int numero) {
        this.ID_filial = id;
        this.CEP = cep;
        this.Estado = regiao;
        this.Endereco = local;
        this.numero = numero;
    }
    
    public String getComplemento() {
        return complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public void setId(int id) {
        this.ID_filial = id;
    }
    
    public int getId() {
        return ID_filial;
    }

    public String getCep() {
        return CEP;
    }

    public void setCep(String cep) {
        this.CEP = cep;
    }

    public String getRegiao() {
        return Estado;
    }

    public void setRegiao(String regiao) {
        this.Estado = regiao;
    }

    public String getLocal() {
        return Endereco;
    }

    public void setLocal(String local) {
        this.Endereco = local;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}