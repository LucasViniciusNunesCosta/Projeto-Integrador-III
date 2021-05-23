package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Funcionario extends Usuario{
    
    private int filialId;
    private String atuacao;
    private double salario;
    private String nome;
    private String Sobrenome;
    private String cpf;

    public Funcionario(String nome, String senha) {
        super(nome, senha);
    }

    public Funcionario(int filialId, String atuacao, double salario, String nome, String Sobrenome, String cpf, String email, String senha) {
        super(email, senha);
        this.filialId = filialId;
        this.atuacao = atuacao;
        this.salario = salario;
        this.nome = nome;
        this.Sobrenome = Sobrenome;
        this.cpf = cpf;
    }
    
    public Funcionario(int filialId, String atuacao, double salario, String nome, String Sobrenome, String cpf, int ID, String email) {
        super(ID, email);
        this.filialId = filialId;
        this.atuacao = atuacao;
        this.salario = salario;
        this.nome = nome;
        this.Sobrenome = Sobrenome;
        this.cpf = cpf;
    }
    
    

    public Funcionario(int ID) {
        super(ID);
    }
    
    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }
    
    public int getFilialId(){
        return filialId;
    }
    
    public void setFilialId(int filialId){
        this.filialId = filialId;
    }
 
    public String getAtuacao() {
        return atuacao;
    }
    
    public void setAtuacao(String atuacao){
        this.atuacao = atuacao;
    }

    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Erro salario 0");
        }else{
            this.salario = salario;
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
}