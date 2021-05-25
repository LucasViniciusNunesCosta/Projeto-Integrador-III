package com.projeto.entidade;

import java.sql.Date;
import java.util.ArrayList;


/**
 *
 * @author Icaro
 */
public class Venda extends Cliente{
    
    private int ID_Compra;
    private Date data;
    private int Id_funcionario;
    private double vendaTotal;
    private ArrayList<Item> Items = new ArrayList<>();

    public Venda(double vendaTotal, int ID_Cliente, String Nome, String CPF) {
        super(ID_Cliente, Nome, CPF);
        this.vendaTotal = vendaTotal;
    }

    public Venda(int Id_funcionario, int ID_Cliente) {
        super(ID_Cliente);
        this.Id_funcionario = Id_funcionario;
    }

    public Venda(int ID_Compra, Date data, int Id_funcionario, double vendaTotal, int ID_Cliente) {
        super(ID_Cliente);
        this.ID_Compra = ID_Compra;
        this.data = data;
        this.Id_funcionario = Id_funcionario;
        this.vendaTotal = vendaTotal;
    }
    
    public void addAllItens(ArrayList<Item> items){
        items.forEach(item -> {
            vendaTotal += item.getV_total();
            Items.add(item);
        });
    }

    public int getID_Compra() {
        return ID_Compra;
    }

    public Date getData() {
        return data;
    }

    public void setID_Compra(int ID_Compra) {
        this.ID_Compra = ID_Compra;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setId_funcionario(int Id_funcionario) {
        this.Id_funcionario = Id_funcionario;
    }

    public void setVendaTotal(double vendaTotal) {
        this.vendaTotal = vendaTotal;
    }
    
    public int getId_funcionario() {
        return Id_funcionario;
    }
    
    public void addItem(Item item){
        vendaTotal += item.getV_total();
        Items.add(item);
    }
    
    public double getVendaTotal() {
        return vendaTotal;
    }

    public int getId() {
        return ID_Compra;
    }
    
    public ArrayList<Item> getItems() {
        return Items;
    }
}