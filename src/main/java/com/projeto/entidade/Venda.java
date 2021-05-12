package com.projeto.entidade;

import java.sql.Date;
import java.util.ArrayList;


/**
 *
 * @author Icaro
 */
public class Venda{
    
    private final int id;
    private int Id_cliente;
    private Date data;
    private String nomeProduto;
    private int Id_funcionario;
    private double vendaTotal = 0;
    private ArrayList<Item> Items = new ArrayList<>();

    @Override
    public String toString(){
        return String.format("CPF:%s\nNumero do Pedido:%1d\nAtendimento:%1d\nValor todal do pedido:$%.2f", this.Id_cliente, this.id, this.Id_funcionario, getVendaTotal());
    }
    
    public Venda(int ID) {
        this.id = ID;
    }
  
    public Venda(int id, int id_cliente, int id_funcionario, double VendaTotal) {
        this.id = id;
        this.Id_cliente = id_cliente;
        this.Id_funcionario = id_funcionario;
        this.vendaTotal = VendaTotal;
    }
    
    public Venda(int id, int Id_cliente, int Id_funcionario, String nomeProduto, double VendaTotal, Date Data) {
        this.id = id;
        this.Id_cliente = Id_cliente;
        this.Id_funcionario = Id_funcionario;
        this.vendaTotal = VendaTotal;
        this.nomeProduto = nomeProduto;
        this.data = Data;
    }
    
    public void addAllItens(ArrayList<Item> items){
        items.forEach(i -> {
            vendaTotal += i.ValorAllItemsDesconto();
            Items.add(i);
        });
    }
    
    public void addItem(Estoque ES){
        vendaTotal += ES.ValorAllItemsDesconto();
        Items.add(ES);
    }
    
    public double getVendaTotal() {
        return vendaTotal;
    }

    public int getId() {
        return id;
    }
    public ArrayList<Item> getItems() {
        return Items;
    }

    public Date getData() {
        return data;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getId_funcionario() {
        return Id_funcionario;
    }

    public int getId_cliente() {
        return Id_cliente;
    }
    
}