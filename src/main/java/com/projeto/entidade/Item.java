package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Item extends Produto{
    
    private double V_compra;
    private double V_venda;
    private int Desconto;
    private int QTD;

    public Item(int ID) {
        super(ID);
    }
    public Item(double V_compra, double V_venda, int QTD, String Nome, String Marca) {
        super(Nome, Marca);
        if (V_compra <= 0) {
            throw new IllegalArgumentException("Erro valor de Aquzição =< 0");
        }else{
            this.V_compra = V_compra;
        }
        if (V_venda <= V_compra) {
            throw new IllegalArgumentException("Erro valor de venda é menor ou igual que o valor de Aquzição");
        }else{
            this.V_venda = V_venda;
        }
        if (QTD <= 0) {
            throw new IllegalArgumentException("Erro quantidade igual ou menor que zero!");
        }else{
            this.QTD = QTD;
        }
    }

    public Item(int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda) {
        super(ID, Nome, Marca);
        if (V_compra <= 0) {
            throw new IllegalArgumentException("Erro valor de Aquzição =< 0");
        }else{
            this.V_compra = V_compra;
        }
        if (V_venda <= V_compra) {
            throw new IllegalArgumentException("Erro valor de venda é menor ou igual que o valor de Aquzição");
        }else{
            this.V_venda = V_venda;
        }
        if (QTD <= 0) {
            throw new IllegalArgumentException("Erro quantidade igual ou menor que zero!");
        }else{
            this.QTD = QTD;
        }
    }

    public Item(int ID, String Nome, String Marca, int QTD, double V_compra, double V_venda, int Desconto) {
        super(ID, Nome, Marca);
        if (V_compra <= 0) {
            throw new IllegalArgumentException("Erro valor de Aquzição =< 0");
        }else{
            this.V_compra = V_compra;
        }
        if (V_venda <= V_compra) {
            throw new IllegalArgumentException("Erro valor de venda é menor ou igual que o valor de Aquzição");
        }else{
            this.V_venda = V_venda;
        }
        if (Desconto < 0) {
            throw new IllegalArgumentException("Erro Desconto negativo!");
        }else{
            this.Desconto = Desconto;
        }
        if (QTD <= 0) {
            throw new IllegalArgumentException("Erro quantidade igual ou menor que zero!");
        }else{
            this.QTD = QTD;
        }
    }
    
    /**
     * retorna o valor dos items já com desconto
     * @return double
     */
    public double ValorAllItemsDesconto(){
        return ( getV_venda() - ( getV_venda() * ( getDesconto() / getV_venda() ) ) ) * getQTD() ;
    }
    
    @Override
    public String toString(){
         return String.format("%s \nDesconto/Promoção: %1d\nQuantidade: %1d\nValor de aquicição:%.2f\nValor de vende: %.2f", super.toString(), getDesconto(), getQTD(), getV_compra(), getV_venda());
    }
    
    public int getDesconto() {
        return Desconto;
    }

    public void setDesconto(int Desconto) {
        if (Desconto < 0) {
            throw new IllegalArgumentException("Erro Desconto negativo!");
        }else{
            this.Desconto = Desconto;
        }
    }

    public double getV_compra() {
        return V_compra;
    }

    public double getV_venda() {
        return V_venda;
    }
    
    public void setV_compra(double V_compra){
        this.V_compra = V_compra;
    }

    public void setV_venda(double V_venda) {
        if (V_venda <= getV_compra()) {
            throw new IllegalArgumentException("Erro valor de venda é menor ou igual que o valor de Aquzição");
        }else{
            this.V_venda = V_venda;
        }
    }

    public int getQTD() {
        return QTD;
    }

    public void setQTD(int QTD) {
        if (QTD < 0) {
            throw new IllegalArgumentException("Erro quantidade menor que zero!");
        }else{
            this.QTD = QTD;
        }
    }
    
}