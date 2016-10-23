/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.Beans;

import java.sql.Date;

/**
 *
 * @author joãomarcos
 */
public class Matricula_bean extends Alunos_bean {
    
private int matrCod;
private int ativCod;
private float matrValMens;
private Date matrDtVenc;
private String matrStatus;
private String ativNome;

    public String getAtivNome() {
        return ativNome;
    }

    public int getMatrCod() {
        return matrCod;
    }

    public void setAtivNome(String ativNome) {
        this.ativNome = ativNome;
    }

    public void setMatrCod(int matrCod) {
        this.matrCod = matrCod;
    }

    public int getAtivCod() {
        return ativCod;
    }

    public void setAtivCod(int ativCod) {
        this.ativCod = ativCod;
    }

    public float getMatrValMens() {
        return matrValMens;
    }

    public void setMatrValMens(float matrValMens) {
        this.matrValMens = matrValMens;
    }

    public Date getMatrDtVenc() {
        return matrDtVenc;
    }

    public void setMatrDtVenc(Date matrDtVenc) {
        this.matrDtVenc = matrDtVenc;
    }

    public String getMatrStatus() {
        return matrStatus;
    }

    public void setMatrStatus(String matrStatus) {
        this.matrStatus = matrStatus;
    }
    


}
