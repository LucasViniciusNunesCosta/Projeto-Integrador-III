package com.projeto.entidade;

/**
 *
 * @author Icaro
 */
public class Filial {
    
    private final int Filial_ID;
    private final String CEP;
    private final String Regiao;
    private final String Loca;
    private final int Nume;
    private String Com;

    public Filial(int ID, String CEP, String Regiao, String Loca, int Nume, String Com) {
        this.Filial_ID = ID;
        this.CEP = CEP;
        this.Regiao = Regiao;
        this.Loca = Loca;
        this.Nume = Nume;
        this.Com = Com;
    }

    public Filial(int ID, String CEP, String Regiao, String Loca, int Nume) {
        this.Filial_ID = ID;
        this.CEP = CEP;
        this.Regiao = Regiao;
        this.Loca = Loca;
        this.Nume = Nume;
    }

    @Override
    public String toString(){
        return String.format("Codigo da Afilial:%1d    CEP:%s\nRegião:%s\nRua%s, %1d\nCompremeto:%s", getFilial_ID(), getCEP(), getRegiao(), getLoca(), getNume(), getCom());
    }
    
    public int getFilial_ID() {
        return Filial_ID;
    }

    public String getCEP() {
        return CEP;
    }

    public String getRegiao() {
        return Regiao;
    }

    public String getLoca() {
        return Loca;
    }

    public int getNume() {
        return Nume;
    }

    public String getCom() {
        return Com;
    }

    public void setCom(String Com) {
        this.Com = Com;
    }
    
}