package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public abstract class Produto{
    
    private int ID;
    private String Nome;
    private String Marca;

    public Produto(int ID, String Nome, String Marca) {
        this.ID = ID;
        this.Nome = Nome;
        this.Marca = Marca;
    }

    public Produto(String Nome, String Marca) {
        this.Nome = Nome;
        this.Marca = Marca;
    }

    public Produto(int ID) {
        this.ID = ID;
    }
    
    @Override
    public String toString(){
        return String.format("ID do Produto: %1d\nNome: %s\nMarca: %s", getID(), getNome(), getMarca());
    }
    
    public String getMarca() {
        return Marca;
    }

    public int getID() {
        return ID;
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    
}