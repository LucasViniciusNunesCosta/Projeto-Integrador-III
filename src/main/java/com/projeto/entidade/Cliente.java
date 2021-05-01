package com.projeto.entidade;



/**
 *
 * @author Icaro
 */
public class Cliente extends Usuario{
    
    private int ID;

    public Cliente(int ID, String Nome, String CPF) {
        super(Nome, CPF);
        this.ID = ID;
    }
    
    public Cliente(String Nome, String CPF) {
        super(Nome, CPF);
    }

    public Cliente(String CPF) {
        super(CPF);
    }
    
    @Override
    public String toString(){
        return String.format("ID do Cliente:%s\n%s,", getID(), super.toString());
    }
    
    public int getID() {
        return ID;
    }
    
}