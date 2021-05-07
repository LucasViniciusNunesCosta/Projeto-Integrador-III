package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Estoque extends Item{

    private int FiliaID;
    private String Categoria;

    public Estoque(int ID, int Filia_ID, String Nome, String Marca, String Categoria, int QTD, double V_compra, double V_venda) {
        super(ID, Nome, Marca, QTD, V_compra, V_venda);
        this.FiliaID = Filia_ID;
        this.Categoria = Categoria;
    }

    public Estoque(int Filia_ID, String Nome, String Marca ,String Categoria, int QTD, double V_compra, double V_venda) {
        super(V_compra, V_venda, QTD, Nome, Marca);
        this.FiliaID = Filia_ID;
        this.Categoria = Categoria;
    }

    public Estoque(int ID) {
        super(ID);
    }
    
    @Override
    public String toString(){
        return String.format("%s Departamento:%s\n Filia codigo:%1d", super.toString(), getCategoria(), getFiliaID());
    }

    public int getFiliaID() {
        return FiliaID;
    }
    
    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setFiliaID(int FiliaID) {
        this.FiliaID = FiliaID;
    }
}