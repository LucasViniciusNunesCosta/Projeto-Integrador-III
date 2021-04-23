package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Funcionario extends Colaborador{
    
    private final int Filial_ID;
    private final int Funci_ID;
    private String Atuacao;
    private double Salario;

    @Override
    public String toString(){
        return String.format("%sn\ncodigo do Fucionario:%1d  codigo da Afilial:%1d\nAtuação:%s\nSalario", super.toString(), getFunci_ID(), getFilial_ID(), getAtuacao(), getSalario());
    }
    
    public Funcionario(int Filial_ID, int Funci_ID, String Atuacao, double Salario, String Senha, String Email, String Nome, String CPF) {
        super(Senha, Email, Nome, CPF);
        this.Filial_ID = Filial_ID;
        this.Funci_ID = Funci_ID;
        this.Atuacao = Atuacao;
        if (Salario <= 0) {
            throw new IllegalArgumentException("Erro salario 0");
        }else{
            this.Salario = Salario;
        }
    }
    
    public int getFilial_ID() {
        return Filial_ID;
    }

    public int getFunci_ID() {
        return Funci_ID;
    }

    public String getAtuacao() {
        return Atuacao;
    }

    public double getSalario() {
        return Salario;
    }

    public void setAtuacao(String Atuacao) {
        this.Atuacao = Atuacao;
    }

    public void setSalario(double Salario) {
        if (Salario <= 0) {
            throw new IllegalArgumentException("Erro salario 0");
        }else{
            this.Salario = Salario;
        }
    }
    
}