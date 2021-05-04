package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Funcionario extends Usuario{
    
    private final int id;
    private String nome;
    private Filial filial;
    private String atuacao;
    private double salario;

    @Override
    public String toString(){
        return String.format("%sn\ncodigo do Fucionario:%1d  codigo da Afilial:%1d\nAtuação:%s\nSalario", super.toString(), getId(), getFilial(), getAtuacao(), getSalario());
    }
    
    public Funcionario(int filialId, int funcionarioId, String atuacao, double salario, String senha, String email, String nome, String cpf) {
        super(senha, email);
        this.filial.setId(filialId);
        this.id = funcionarioId;
        this.atuacao = atuacao;
        if (this.salario <= 0) {
            throw new IllegalArgumentException("Erro salario 0");
        }else{
            this.salario = salario;
        }
    }
    
    public Filial getFilial() {
        return this.filial;
    }

    public int getId() {
        return id;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setAtuacao(String Atuacao) {
        this.atuacao = Atuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Erro salario 0");
        }else{
            this.salario = salario;
        }
    }
    
}