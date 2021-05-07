package com.projeto.entidade;


/**
 *
 * @author Icaro
 */
public class Cliente{
    
    private int ID;
    private String Nome;
    private String CPF;

    public Cliente(int id, String nome, String cpf) {
        this.ID = id;
    }

    public Cliente(String nome, String cpf) {
        if (Validar_CPF(cpf)) {
            this.CPF = cpf;
            this.Nome = nome;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
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
        return ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getCpf() {
        return CPF;
    }

    public void setCpf(String cpf) {
        this.CPF = cpf;
    }
    
    @Override
    public String toString(){
        return String.format("ID do Cliente:%s\n%s,", getId(), super.toString());
    }
    
}