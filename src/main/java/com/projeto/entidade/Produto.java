package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public abstract class Produto{
    
    private final int id;
    private final String nome;
    private final String marca;


    public Produto(int id, String nome, String marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    @Override
    public String toString(){
        return String.format("ID do Produto: %1d\nNome: %s\nMarca: %s", getId(), getNome(), getMarca());
    }
    
    public String getMarca() {
        return marca;
    }

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
}