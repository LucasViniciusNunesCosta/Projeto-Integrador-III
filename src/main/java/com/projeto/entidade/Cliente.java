package com.projeto.entidade;


/**
 *
 * @author Icaro
 */
public class Cliente{
    
    private int ID_Cliente;
    private String Nome;
    private String CPF;

    public Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public Cliente(String Nome, String CPF) {
        this.Nome = Nome;
        if (Validar_CPF(CPF)) {
            this.CPF = CPF;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public Cliente(int ID_Cliente, String Nome, String CPF) {
        this.ID_Cliente = ID_Cliente;
        this.Nome = Nome;
        if (Validar_CPF(CPF)) {
            this.CPF = CPF;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
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
    
    public int getID_Cliente() {
        return ID_Cliente;
    }

    public String getNome() {
        return Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setCPF(String CPF) {
        if (Validar_CPF(CPF)) {
            this.CPF = CPF;
        }else{
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }
    
}