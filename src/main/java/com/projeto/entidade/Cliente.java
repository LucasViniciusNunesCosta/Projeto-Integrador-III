package com.projeto.entidade;



/**
 *
 * @author Icaro
 */
public class Cliente{
    
    private int id;
    private String nome;
    private String cpf;

    public Cliente(int id, String nome, String cpf) {
        this.id = id;
    }

    public Cliente(String nome, String cpf) {
        if (Validar_CPF(cpf)) {
            this.cpf = cpf;
            this.nome = nome;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public Cliente(String CPF) {
        super(CPF);
    }
    
    public static boolean Validar_CPF(String cpf){
        
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
    }
    
    public static boolean VF(int i, int CPF[]){
        if (i==1) {
            return CPF[i-1] == CPF[i];
        }else{
            return CPF[i-1] == CPF[i] && VF(i-1, CPF);
        }
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Override
    public String toString(){
        return String.format("ID do Cliente:%s\n%s,", getId(), super.toString());
    }
    
}