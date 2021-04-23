package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public abstract class Produto{
    
    private final int Produto_ID;
    private final String Nome;
    private final String Marca;


    public Produto(int ID, String Nome, String Marca) {
        this.Produto_ID = ID;
        this.Nome = Nome;
        this.Marca = Marca;
    }

    @Override
    public String toString(){
        return String.format("ID do Produto: %1d\nNome: %s\nMarca: %s", getProduto_ID(), getNome(), getMarca());
    }
    
    public String getMarca() {
        return Marca;
    }

    public int getProduto_ID() {
        return Produto_ID;
    }
    
    public String getNome() {
        return Nome;
    }
    
}