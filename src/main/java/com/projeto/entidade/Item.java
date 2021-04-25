package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Item extends Produto{
    
    private final double valorCompra;
    private double valorVenda;
    private int desconto;
    private int quantidade;

    public Item(int produtoId, String nomeProduto, String marcaProduto, int quantidade, double valorCompra, double valorVenda) {
        super(produtoId, nomeProduto, marcaProduto);
        if (valorCompra <= 0) {
            throw new IllegalArgumentException("Erro valor de Aquzição 0 ou menor");
        }else{
            this.valorCompra = valorCompra;
        }
        if (valorVenda <= valorCompra) {
            throw new IllegalArgumentException("Erro valor de venda é menor que a compra");
        }else{
            this.valorVenda = valorVenda;
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Erro Quatidade negativa!");
        }else{
            this.quantidade = quantidade;
        }
        
    }

    public Item(int produtoId, String nomeProduto, String marcaProduto, int quantidade, double valorCompra, double valorVenda, int desconto) {
        super(produtoId, nomeProduto, marcaProduto);
        if (valorCompra <= 0) {
            throw new IllegalArgumentException("Erro valor de Aquzição 0 ou menor");
        }else{
            this.valorCompra = valorCompra;
        }
        if (valorVenda <= valorCompra) {
            throw new IllegalArgumentException("Erro valor de venda é menor que a compra");
        }else{
            this.valorVenda = valorVenda;
        }
        if (desconto < 0) {
            throw new IllegalArgumentException("Erro Desconto negativo!");
        }else{
            this.desconto = desconto;
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Erro Quatidade negativa!");
        }else{
            this.quantidade = quantidade;
        }
        
    }
    
    /**
     * retorna o valor dos items já com desconto
     * @return double
     */
    public double ValorAllItemsDesconto(){
        return ( getValorVenda() - ( getValorVenda() * ( getDesconto() / getValorVenda() ) ) ) * getQuantidade() ;
    }
    
    @Override
    public String toString(){
         return String.format("%s \nDesconto/Promoção: %1d\nQuantidade: %1d\nValor de aquicição:%.2f\nValor de vende: %.2f", super.toString(), getDesconto(), getQuantidade(), getValorCompra(), getValorVenda());
    }
    
    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int Desconto) {
        if (Desconto < 0) {
            throw new IllegalArgumentException("Erro Desconto negativo!");
        }else{
            this.desconto = Desconto;
        }
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        if (valorVenda <= getValorCompra()) {
            throw new IllegalArgumentException("Erro valor de venda é menor que a compra");
        }else{
            this.valorVenda = valorVenda;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Erro Quatidade negativa!");
        }else{
            this.quantidade = quantidade;
        }
    }
    
}