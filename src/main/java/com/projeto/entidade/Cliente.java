package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Cliente extends Usuario{
    
    private int Cliente_ID;

    public Cliente(int ID, String Nome, String CPF) {
        super(Nome, CPF);
        this.Cliente_ID = ID;
    }

    public Cliente(String Nome, String CPF) {
        super(Nome, CPF);
    }
    
    @Override
    public String toString(){
        return String.format("ID do Cliente:%s\n%s,", getCliente_ID(), super.toString());
    }
    
    public int getCliente_ID() {
        return Cliente_ID;
    }
    
}