package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Filial {
    
    private int id;
    private String cep;
    private String regiao;
    private String local;
    private int numero;
    private String complemento;

    public Filial(int id, String cep, String regiao, String local, int numero, String complemento) {
        this.id = id;
        this.cep = cep;
        this.regiao = regiao;
        this.local = local;
        this.numero = numero;
        this.complemento = complemento;
    }

    public Filial(int id, String cep, String regiao, String local, int numero) {
        this.id = id;
        this.cep = cep;
        this.regiao = regiao;
        this.local = local;
        this.numero = numero;
    }

    @Override
    public String toString(){
        return String.format("Codigo da Afilial:%1d    CEP:%s\nRegião:%s\nRua%s, %1d\nCompremeto:%s", getId(), getCep(), getRegiao(), getLocal(), getNumero(), getComplemento());
    }

    public String getComplemento() {
        return complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}