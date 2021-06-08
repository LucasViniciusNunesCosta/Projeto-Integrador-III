package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class FuncionarioCargo extends Funcionario{

    private static boolean Vendedor;
    private static boolean RH;
    private static boolean ADM;
    private static boolean Gerente;
    private static boolean Suporte;
    
    public FuncionarioCargo(int ID) {
        super(ID);
    }

    public FuncionarioCargo(int filialId, String atuacao, double salario, String nome, String Sobrenome, String cpf, String email, String senha) {
        super(filialId, atuacao, salario, nome, Sobrenome, cpf, email, senha);
    }

    public FuncionarioCargo(String atuacao, int ID, String email, String senha) {
        super(atuacao, ID, email, senha);
    }
    
    public void setCargo(){
        switch (getAtuacao()){
            case "Vendedor":
                Vendedor = true;
                RH = false;
                ADM = false;
                Gerente = false;
                Suporte = false;
            break;
            case "RH":
                Vendedor = false;
                RH = true;
                ADM = false;
                Gerente = false;
                Suporte = false;
            break;
            case "ADM":
                Vendedor = false;
                RH = false;
                ADM = true;
                Gerente = false;
                Suporte = false;
            break;
            case "Gerente":
                Vendedor = false;
                RH = false;
                ADM = false;
                Gerente = true;
                Suporte = false;
            break;
            case "Suporte":
                Vendedor = false;
                RH = false;
                ADM = false;
                Gerente = false;
                Suporte = true;
            break;
        }
    }

    public static boolean isVendedor() {
        if (ADM) {
            return ADM;
        }else
            return Vendedor;
    }

    public static boolean isRH() {
        if (ADM) {
            return ADM;
        }else
            return RH;
    }

    public static boolean isADM() {
        return ADM;
    }

    public static boolean isGerente() {
        if (ADM) {
            return ADM;
        }else
            return Gerente;
    }

    public static boolean isSuporte() {
        if (ADM) {
            return ADM;
        }else
            return Suporte;
    }
}
