/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Suporte {
 
    private int ID_Requisicao;
    private int ID_Funcionario;
    private String Topico;
    private String Assunto;
    private String Descricao;
    private boolean Resposta;
    private int Referencia;
    private String Email;

    public Suporte(String Topico, String Assunto, String Descricao, boolean Resposta) {
        this.Topico = Topico;
        this.Assunto = Assunto;
        this.Descricao = Descricao;
        this.Resposta = Resposta;
    }

    public Suporte(int ID_Requisicao, String Topico, String Assunto, boolean Resposta) {
        this.ID_Requisicao = ID_Requisicao;
        this.Topico = Topico;
        this.Assunto = Assunto;
        this.Resposta = Resposta;
    }

    public Suporte(int ID_Funcionario, String Topico, String Assunto, String Descricao, boolean Resposta, int Referencia) {
        this.ID_Funcionario = ID_Funcionario;
        this.Topico = Topico;
        this.Assunto = Assunto;
        this.Descricao = Descricao;
        this.Resposta = Resposta;
        this.Referencia = Referencia;
    }

    public Suporte(String Topico, String Assunto, String Descricao, String Email) {
        this.Topico = Topico;
        this.Assunto = Assunto;
        this.Descricao = Descricao;
        this.Email = Email;
    }
    
    public Suporte(int ID_Requisicao) {
        this.ID_Requisicao = ID_Requisicao;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public void setTopico(String Topico) {
        this.Topico = Topico;
    }

    public void setAssunto(String Assunto) {
        this.Assunto = Assunto;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setResposta(boolean Resposta) {
        this.Resposta = Resposta;
    }

    public void setReferencia(int Referencia) {
        this.Referencia = Referencia;
    }
    
    public void setID_Requisicao(int ID_Requisicao) {
        this.ID_Requisicao = ID_Requisicao;
    }

    public void setID_Funcionario(int ID_Funcionario) {
        this.ID_Funcionario = ID_Funcionario;
    }
    
    public boolean isResposta() {
        return Resposta;
    }
    
    public String getTopico() {
        return Topico;
    }
    
    public int getID_Requisicao() {
        return ID_Requisicao;
    }

    public int getID_Funcionario() {
        return ID_Funcionario;
    }

    public String getAssunto() {
        return Assunto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public int getReferencia() {
        return Referencia;
    }
}
