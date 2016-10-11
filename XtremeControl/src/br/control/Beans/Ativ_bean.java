/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.Beans;

/**
 *
 * @author joãomarcos
 */
public class Ativ_bean {

    private int ativCod ;
    private String ativNome;
    private String ativDescr;
    private float ativValor;
    private String ativStatus ;
    public int desativ;

    public int getDesativ() {
        return desativ;
    }

    public void setDesativ(int desativ) {
        this.desativ = desativ;
    }

    public int getAtivCod() {
        return ativCod;
    }

    public void setAtivCod(int ativCod) {
        this.ativCod = ativCod;
    }

    public String getAtivNome() {
        return ativNome;
    }

    public void setAtivNome(String ativNome) {
        this.ativNome = ativNome;
    }

    public String getAtivDescr() {
        return ativDescr;
    }

    public void setAtivDescr(String ativDescr) {
        this.ativDescr = ativDescr;
    }

    public float getAtivValor() {
        return ativValor;
    }

    public void setAtivValor(float ativValor) {
        this.ativValor = ativValor;
    }

    public String getAtivStatus() {
        return ativStatus;
    }

    public void setAtivStatus(String ativStatus) {
        this.ativStatus = ativStatus;
    }
    
}
