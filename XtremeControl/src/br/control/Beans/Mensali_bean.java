/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.Beans;

import java.util.Date;

/**
 *
 * @author joãomarcos
 */
public class Mensali_bean {
private int mensaliCodPag;
private int matrCod;
private String mensaliStatusPag;
private Date mensaliDtVenc;
private Date mensaliDtPag;
private String ativNome;
private int aluCod;
private String aluNome;
private float matrValMens;

    public float getMatrValMens() {
        return matrValMens;
    }

    public void setMatrValMens(float matrValMens) {
        this.matrValMens = matrValMens;
    }



    public int getAluCod() {
        return aluCod;
    }

    public void setAluCod(int aluCod) {
        this.aluCod = aluCod;
    }

    public String getAluNome() {
        return aluNome;
    }

    public void setAluNome(String aluNome) {
        this.aluNome = aluNome;
    }

    public String getAtivNome() {
        return ativNome;
    }

    public void setAtivNome(String ativNome) {
        this.ativNome = ativNome;
    }

    public int getMensaliCodPag() {
        return mensaliCodPag;
    }

    public void setMensaliCodPag(int mensaliCodPag) {
        this.mensaliCodPag = mensaliCodPag;
    }

    public int getMatrCod() {
        return matrCod;
    }

    public void setMatrCod(int matrCod) {
        this.matrCod = matrCod;
    }

    public String getMensaliStatusPag() {
        return mensaliStatusPag;
    }

    public void setMensaliStatusPag(String mensaliStatusPag) {
        this.mensaliStatusPag = mensaliStatusPag;
    }

    public Date getMensaliDtVenc() {
        return mensaliDtVenc;
    }

    public void setMensaliDtVenc(Date mensaliDtVenc) {
        this.mensaliDtVenc = mensaliDtVenc;
    }

    public Date getMensaliDtPag() {
        return mensaliDtPag;
    }

    public void setMensaliDtPag(Date mensaliDtPag) {
        this.mensaliDtPag = mensaliDtPag;
    }


}
