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
    
    public static boolean VF(int i, int CPF[]){
        if (i==1) {
            return CPF[i-1] == CPF[i];
        }else{
            return CPF[i-1] == CPF[i] && VF(i-1, CPF);
        }
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