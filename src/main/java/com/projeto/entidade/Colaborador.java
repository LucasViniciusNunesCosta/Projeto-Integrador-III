package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Colaborador extends Usuario{
    
    private final String senha;
    private final String email;

    public Colaborador(String Senha, String Email, String Nome, String CPF) {
        super(Nome, CPF);
        this.senha = Senha;
        this.email = Email;
    }
    
    @Override
    public String toString(){
        return String.format("%s Email:%s", super.toString(), getEmail());
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }
    
}