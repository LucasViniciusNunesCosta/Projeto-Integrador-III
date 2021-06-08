package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Funcionario extends Usuario{
    
    private int ID_Filial;
    private String atuacao;
    private double salario;
    private String nome;
    private String Sobrenome;
    private String CPF;

    public Funcionario(String email, String senha) {
        super(email, senha);
    }

    public Funcionario(String nome, int ID) {
        super(ID);
        this.nome = nome;
    }

    public Funcionario(int filialId, String atuacao, double salario, String nome, String Sobrenome, String cpf, String email, String senha) {
        super(email, senha);
        this.ID_Filial = filialId;
        this.atuacao = atuacao;
        this.nome = nome;
        this.Sobrenome = Sobrenome;
        if (MinSalario(salario)) {
            this.salario = salario;
        }
        if (Validar_CPF(cpf)) {
            this.CPF = cpf;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
    }
    
    public Funcionario(int filialId, String atuacao, double salario, String nome, String Sobrenome, String cpf, int ID, String email) {
        super(ID, email);
        this.ID_Filial = filialId;
        this.atuacao = atuacao;
        this.nome = nome;
        this.Sobrenome = Sobrenome;
        if (MinSalario(salario)) {
            this.salario = salario;
        }
        if (Validar_CPF(cpf)) {
            this.CPF = cpf;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public Funcionario(String atuacao, int ID, String email, String senha) {
        super(ID, email, senha);
        this.atuacao = atuacao;
    }
    
    public Funcionario(int ID) {
        super(ID);
    }
    
    public static boolean Validar_CPF(String cpf){
        try {
            int Ns[] = new int[11];
            int mul[] = {11,10,9,8,7,6,5,4,3,2};
            int soma = 0, resto;
            String[] RS = cpf.split("");

            for (int i = 0; i < Ns.length; i++) {
                Ns[i] = Integer.parseInt(RS[i]);
            }

            if (VF(8, Ns)==true) {
                return false;
            }else{

                for (int i = 0; i < 9; i++) {
                    soma += (Ns[i] * mul[i+1]);
                }

                resto = (soma*10)%11;
                if (resto == 10) {
                    resto = 0;
                }

                if (resto != Ns[9]) {
                    return false;
                }else{

                    soma = 0;
                    for (int i = 0; i < 10; i++) {
                        soma += (Ns[i] * mul[i]);
                    }

                    resto = (soma*10)%11;
                    if (resto == 10) {
                        resto = 0;
                    }

                    return resto == Ns[10];
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("você colocou letra ou um caractere especial no CPF");
        }
    }
    
    public static boolean VF(int i, int CPF[]){
        if (i==1) {
            return CPF[i-1] == CPF[i];
        }else{
            return CPF[i-1] == CPF[i] && VF(i-1, CPF);
        }
    }
    
    public static boolean MinSalario(double salario){
        if (salario < 1000) {
            throw new IllegalArgumentException("Erro salário igual ou menor ao salário mínimo");
        }else{
            return true;
        }
    }
    
    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }
    
    public int getID_Filial(){
        return ID_Filial;
    }
    
    public void setID_Filial(int ID_Filial){
        this.ID_Filial = ID_Filial;
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
        if (MinSalario(salario)) {
            this.salario = salario;
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCPF(){
        return CPF;
    }
    
    public void setCPF(String CPF){
        if (Validar_CPF(CPF)) {
            this.CPF = CPF;
        }
    }
    
}