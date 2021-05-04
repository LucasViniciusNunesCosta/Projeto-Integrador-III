package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Estoque extends Item{

    private Filial filial;
    private String categoria;

    public Estoque(Filial filial, int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda) {
        super(ID, Nome, Marca, QTD, V_compra, V_venda);
        this.filial = filial;
    }

    public Estoque(Filial filial, int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda, int Desconto) {
        super(ID, Nome, Marca, QTD, V_compra, V_venda, Desconto);
        this.filial = filial;
    }

    public Estoque(Filial filial, String Categoria, int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda) {
        super(ID, Nome, Marca, QTD, V_compra, V_venda);
        this.filial = filial;
        this.categoria = Categoria;
    }

    public Estoque(Filial filial, String Categoria, int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda, int Desconto) {
        super(ID, Nome, Marca, QTD, V_compra, V_venda, Desconto);
        this.filial = filial;
        this.categoria = Categoria;
    }
    
    @Override
    public String toString(){
        return String.format("%s Departamento:%s\n Filia codigo:%1d", super.toString(), getCategoria(), getFilial());
    }

    public Filial getFilial() {
        return this.filial;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String Categoria) {
        this.categoria = Categoria;
    }
}