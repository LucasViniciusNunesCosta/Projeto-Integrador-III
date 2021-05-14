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
    private String nomeProduto;
    private int Id_funcionario;
    private double vendaTotal;
    private int filialId;
    private ArrayList<Item> Items = new ArrayList<>();

    public Venda(double vendaTotal, int ID_Cliente, String Nome, String CPF) {
        super(ID_Cliente, Nome, CPF);
        this.vendaTotal = vendaTotal;
    }

    public Venda(Date data, String nomeProduto, int Id_funcionario, double vendaTotal, int ID_Cliente, int filialId) {
        super(ID_Cliente);
        this.data = data;
        this.nomeProduto = nomeProduto;
        this.Id_funcionario = Id_funcionario;
        this.vendaTotal = vendaTotal;
        this.filialId = filialId;
    }

    public Venda(int ID_Compra, Date data, String nomeProduto, int Id_funcionario, double vendaTotal, int ID_Cliente) {
        super(ID_Cliente);
        this.ID_Compra = ID_Compra;
        this.data = data;
        this.nomeProduto = nomeProduto;
        this.Id_funcionario = Id_funcionario;
        this.vendaTotal = vendaTotal;
    }
    
    public void addAllItens(ArrayList<Item> items){
        items.forEach(item -> {
            vendaTotal += item.ValorAllItemsDesconto();
            Items.add(item);
        });
    }

    public int getID_Compra() {
        return ID_Compra;
    }

    public Date getData() {
        return data;
    }

    public int getId_funcionario() {
        return Id_funcionario;
    }
    
    public void addItem(Item item){
        vendaTotal += item.ValorAllItemsDesconto();
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

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getFilialId() {
        return filialId;
    }

    public void setFilialId(int filialId) {
        this.filialId = filialId;
    }
    
}