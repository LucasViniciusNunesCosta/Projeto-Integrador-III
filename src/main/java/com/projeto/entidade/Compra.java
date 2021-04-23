package com.projeto.entidade;

import java.util.ArrayList;

/**
 *
 * @author Icaro
 */
public class Compra{
    
    private final int Compra_ID;
    private String CPF;
    private int Funcionario_ID;
    private double V_total = 0;
    private ArrayList<Item> Items = new ArrayList<>();

    @Override
    public String toString(){
        return String.format("CPF:%s\nNumero do Pedido:%1d\nAtendimento:%1d\nValor todal do pedido:$%.2f", getCPF(), getCompra_ID(), getFuncionario_ID(), getV_total());
    }
    
    public Compra(int ID) {
        this.Compra_ID = ID;
    }

    public Compra(int Compra_ID, Funcionario Fuc) {
        this.Compra_ID = Compra_ID;
        this.Funcionario_ID = Fuc.getFunci_ID();
    }

    public Compra(int Compra_ID, Cliente Cli) {
        this.Compra_ID = Compra_ID;
        this.CPF = Cli.getCPF();
    }
    
    public Compra(int Compra_ID, Cliente Cli, Funcionario Fuc) {
        this.Compra_ID = Compra_ID;
        this.CPF = Cli.getCPF();
        this.Funcionario_ID = Fuc.getFunci_ID();
    }
    
    public void Add_All_Items(ArrayList<Item> items){
        items.forEach(i -> {
            V_total += i.ValorAllItemsDesconto();
            Items.add(i);
        });
    }
    
    public void Add_Item(Estoque ES){
        V_total += ES.ValorAllItemsDesconto();
        Items.add(ES);
    }
    
    public double getV_total() {
        return V_total;
    }

    public int getCompra_ID() {
        return Compra_ID;
    }

    public int getFuncionario_ID() {
        if (Funcionario_ID == 0) {
            return -1;
        }else{
            return Funcionario_ID;
        }
    }

    public void setFuncionario_ID(int Funcionario_ID) {
        this.Funcionario_ID = Funcionario_ID;
    }

    public ArrayList<Item> getItems() {
        return Items;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(Cliente Cli) {
        this.CPF = Cli.getCPF();
    }
    
}