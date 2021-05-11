package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Funcionario{
    
    private int filialId;
    private final int id;
    private String atuacao;
    private double salario;
    private String senha;
    private String login;
    private String nome;
    private String cpf;
    private String email;
    
    public Funcionario(int filialId, int id, String atuacao, double salario, String senha, String login, String nome, String cpf, String email) {
        this.filialId = filialId;
        this.id = id;
        this.atuacao = atuacao;
        this.salario = salario;
        this.senha = senha;
        this.login = login;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        if (this.salario <= 0) {
            throw new IllegalArgumentException("Erro salario 0"+ this.salario);
        }
    }
    
    public int getFilialId(){
        return filialId;
    }
    public void setFilialId(int filialId){
        this.filialId = filialId;
    }

    public int getId() {
        return id;
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
    public String getSenha(){
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
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
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "filialId=" + filialId + ", id=" + id + ", atuacao=" + atuacao + ", salario=" + salario + ", senha=" + senha + ", login=" + login + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + '}';
    }
    
}