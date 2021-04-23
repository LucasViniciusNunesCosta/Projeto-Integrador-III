package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Colaborador extends Usuario{
    
    private final String Senha;
    private final String Email;

    public Colaborador(String Senha, String Email, String Nome, String CPF) {
        super(Nome, CPF);
        this.Senha = Senha;
        this.Email = Email;
    }
    
    @Override
    public String toString(){
        return String.format("%s Email:%s", super.toString(), getEmail());
    }

    public String getSenha() {
        return Senha;
    }

    public String getEmail() {
        return Email;
    }
    
}