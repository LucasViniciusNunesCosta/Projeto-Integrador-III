package com.projeto.entidade;



/**
 *
 * @author Icaro
 */
public abstract class Usuario {
 
    private String Nome;
    private final String CPF;

    public Usuario(String Nome, String CPF) {
        this.Nome = Nome;
        if (Validar_CPF(CPF)) {
            this.CPF = CPF;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public Usuario(String CPF) {
        if (Validar_CPF(CPF)) {
            this.CPF = CPF;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
    }
    
    @Override
    public String toString(){
        return String.format("Nome: %s  CPF:%s", getNome(), getCPF());
    }
    
    public static boolean Validar_CPF(String s){
        
        int Ns[] = new int[11];
        int mul[] = {11,10,9,8,7,6,5,4,3,2};
        int soma = 0, resto;
        String[] RS = s.split("");
        
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

    public String getCPF() {
        return CPF;
    }
    
    public String getNome() {
        return Nome;
    }
    
}