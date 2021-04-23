package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Estoque extends Item{

    private final int Filia_ID;
    private String Categoria;

    public Estoque(Filial Fil, int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda) {
        super(ID, Nome, Marca, QTD, V_compra, V_venda);
        this.Filia_ID = Fil.getFilial_ID();
    }

    public Estoque(Filial Fil, int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda, int Desconto) {
        super(ID, Nome, Marca, QTD, V_compra, V_venda, Desconto);
        this.Filia_ID = Fil.getFilial_ID();
    }

    public Estoque(Filial Fil, String Categoria, int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda) {
        super(ID, Nome, Marca, QTD, V_compra, V_venda);
        this.Filia_ID = Fil.getFilial_ID();
        this.Categoria = Categoria;
    }

    public Estoque(Filial Fil, String Categoria, int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda, int Desconto) {
        super(ID, Nome, Marca, QTD, V_compra, V_venda, Desconto);
        this.Filia_ID = Fil.getFilial_ID();
        this.Categoria = Categoria;
    }
    
    public String toString(){
        return String.format("%s Departamento:%s\n Filia codigo:%1d", super.toString(), getCategoria(), getFilia_ID());
    }

    public int getFilia_ID() {
        return Filia_ID;
    }
    
    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
}