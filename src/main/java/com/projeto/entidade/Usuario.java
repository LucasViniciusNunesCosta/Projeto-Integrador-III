package com.projeto.entidade;



/**
 *
 * @author Icaro
 */
public abstract class Usuario {
 
    private String login;
    private String senha;

    public Usuario(String nome, String senha) {
        this.login = nome;
        this.senha = senha;
    }
    
    @Override
    public String toString(){
        return String.format("Nome: %s  CPF:%s", getLogin(), getSenha());
    }
    
    public String getSenha() {
        return senha;
    }
    
    public String getLogin() {
        return login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
}