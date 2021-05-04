package com.projeto.entidade;

import java.util.ArrayList;

/**
 *
 * @author Icaro
 */
public class Compra{
    
    private final int id;
    private Cliente cliente;
    private Funcionario funcionario;
    private double vendaTotal = 0;
    private ArrayList<Item> Items = new ArrayList<>();

    @Override
    public String toString(){
        return String.format("CPF:%s\nNumero do Pedido:%1d\nAtendimento:%1d\nValor todal do pedido:$%.2f", this.cliente, this.id, funcionario.getId(), getVendaTotal());
    }
    
    public Compra(int ID) {
        this.id = ID;
    }

    public Compra(int id, Funcionario funcionario) {
        this.id = id;
        this.funcionario = funcionario;
    }

    public Compra(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }
    
    public Compra(int id, Cliente cliente, Funcionario funcionario) {
        this.id = id;
        this.cliente = cliente;
        this.funcionario = funcionario;
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
    
}