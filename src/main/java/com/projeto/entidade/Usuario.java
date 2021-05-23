package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public abstract class Usuario {
 
    private int ID;
    private String email;
    private String senha;
    private String SenhaFechada;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int ID) {
        this.ID = ID;
    }

    public Usuario(int ID, String email) {
        this.ID = ID;
        this.email = email;
    }

    public Usuario(int ID, String email, String senha) {
        this.ID = ID;
        this.email = email;
        this.senha = senha;
    }
    
    public Usuario(String email) {
        this.email = email;
    }
    
    public String getSenhaFechada() {
        return SenhaFechada;
    }

    public void setSenhaFechada(String SenhaFechada) {
        this.SenhaFechada = SenhaFechada;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}