package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Funcionario{
    
    private int filialId;
    private int id;
    private String atuacao;
    private double salario;
    private String senha;
    private String login;
    private String nome;
    private String Sobrenome;
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

    public Funcionario(int id) {
        this.id = id;
    }
    
    public Funcionario(int id, int filialId, String nome, String Sobrenome, String email, String cpf, String atuacao, double salario) {
        this.filialId = filialId;
        this.id = id;
        this.atuacao = atuacao;
        this.salario = salario;
        this.nome = nome;
        this.Sobrenome = Sobrenome;
        this.cpf = cpf;
        this.email = email;
    }
    
    public Funcionario(String senha, String email) {
        this.senha = senha;
        this.email = email;
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

    public void setId(int id) {
        this.id = id;
    }
    
}