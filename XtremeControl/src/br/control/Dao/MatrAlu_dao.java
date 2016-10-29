/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.Dao;

import br.control.Beans.Matricula_bean;
import br.control.Beans.Mensali_bean;
import br.control.ConexaoBd.ConectaBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joãomarcos
 */
public class MatrAlu_dao {
    private Connection conexao;
    
    public MatrAlu_dao()throws SQLException{
        this.conexao = new ConectaBanco().getConexao();
    }    
    
    public void CadMatricAlu(Matricula_bean bean)throws SQLException{

        String sql = "exec p_insereMatricula ?,?,?,?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getAluCod());
        stmt.setInt(2, bean.getAtivCod());
        stmt.setFloat(3, bean.getMatrValMens());
        stmt.setDate(4, bean.getMatrDtVenc());
        
        
        stmt.execute();
        stmt.close();
    }
    
    public void TrancMatricAlu(Matricula_bean bean)throws SQLException{
        String sql = "update t_matrAlu set matrStatus = 'Trancado' where matrCod = ?";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getMatrCod());
        
        
        
        stmt.execute();
        stmt.close();
    }
    
    public void DestrancMatricAlu(Matricula_bean bean)throws SQLException{
        String sql = "update t_matrAlu set matrStatus = 'Aberto' where matrCod = ?";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getMatrCod());
        
        
        
        stmt.execute();
        stmt.close();
    }
    
    public void MarcarMensPaga(Mensali_bean bean)throws SQLException{
        String sql = "update t_mensali set mensaliDtPag = GETDATE(), mensaliStatusPag = 'Pago' where mensaliCodPag = ?";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, bean.getMensaliCodPag());
        
        stmt.execute();
        stmt.close();
               
    }
    
    public int ConsultaUltimaMat()throws SQLException{
        String sql = "select max(matrCod)matrCod from t_matrAlu";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int matr = 0;
        while(rs.next()){
            matr = rs.getInt("matrCod");
        }
        
        rs.close();
        stmt.close();
        return matr;
    }
    
    public List<Matricula_bean> ConsultaMatriculas(Matricula_bean bean)throws SQLException{
        
        String sql =  "select * from t_matrAlu m inner join t_ativ a\n" +
                      "on m.ativCod = a.ativCod\n" +
                      "and aluCod = ?";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getAluCod());
        
        ResultSet rs = stmt.executeQuery();
        
        List<Matricula_bean> lista = new ArrayList<>();
        while(rs.next()){
            Matricula_bean c1 = new Matricula_bean();
            c1.setMatrCod(rs.getInt("matrCod"));
            c1.setAtivCod(rs.getInt("ativCod"));
            c1.setAtivNome(rs.getString("ativNome"));
            c1.setMatrValMens(rs.getFloat("matrValMens"));
            c1.setMatrDtVenc(rs.getDate("matrDt"));
            c1.setMatrStatus(rs.getString("matrStatus"));
            
            lista.add(c1);
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }
    
    public List<Matricula_bean> consultaMatriculasAlunosComp(Matricula_bean bean)throws SQLException{
        
        String sql = "select a.aluCod,a.aluNome from t_alu a inner join t_matrAlu m\n" +
                     "on a.aluCod = m.aluCod \n";
        
        if(bean.getAluCod() != 0 && bean.getMatrCod() == 0){
           sql += "and a.aluCod = "+bean.getAluCod();
        }
        else if(bean.getMatrCod()!= 0 && bean.getAluCod() == 0){
           sql += "and matrCod = "+bean.getMatrCod();
        }
        
        else if(bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            
            sql += "and aluNome like '"+bean.getAluNome()+"%'";
        
        }
        
        
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\n and aluIdade = "+bean.getAluIdade();
        }
       
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\nand aluNumResid = "+ bean.getAluNumResid();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\nand aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\nand aluCep = "+bean.getAluCep();
        }
        
        
        
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\n and aluIdade = "+bean.getAluIdade()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\nand aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\nand aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\nand aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\nand aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'"+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNome like '"+bean.getAluNome()+"%'\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        
        ///////////////////////////////////////////
        
        else if(bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            
            sql += "and aluIdade = "+bean.getAluIdade();
        
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'"+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        
        
        
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+"\nand aluCep = "+bean.getAluCep();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+"\nand aluNumResid = "+ bean.getAluNumResid();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+"\nand aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluIdade = "+bean.getAluIdade()+"\nand aluSexo = '"+bean.getAluSexo();
        }
        
        
        /////////////////////////////////////////////////////////////////////
        
       
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'"+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluSexo = '"+bean.getAluSexo()+"'"+"\nand aluPeso = "+bean.getAluPeso();
        }
        
        
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNumResid = "+ bean.getAluNumResid()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluDescVal = "+ bean.getAluDescVal()+"\nand aluPeso = "+bean.getAluPeso();
        }
        
        
        
        
        ////////////////////////////////////////////////////
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep()+"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        
        
         else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid();
        }
        
        ////////////////////////////////////////////////////////
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNumResid = "+ bean.getAluNumResid();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluNumResid = "+"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        /////////////////////////////////////////
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        
        
        //////////////////////////////////////////
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null && bean.getAtivCod() == 0 && bean.getMatrCod() == 0){
            sql += "and aluSexo = '"+bean.getAluSexo()+"'";
        }
        else if (bean.getAluCod() == 0 &&  bean.getAtivCod() != 0 && bean.getMatrCod() == 0){
            sql += "and ativCod = "+bean.getAtivCod();
        }
        
        
        
        if(!sql.equals("")){
        sql +="\n group by a.aluCod,a.aluNome";
        }
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Matricula_bean> lista = new ArrayList<>();
        while (rs.next()) {
           Matricula_bean c1 = new Matricula_bean();
            
           c1.setAluCod(rs.getInt("aluCod"));
           c1.setAluNome(rs.getString("aluNome"));
           
            lista.add(c1);
        }
        rs.close();
        stmt.close();
        return lista;
    }
    
    
    public List<Mensali_bean> ConsultaMensalis(int cod)throws SQLException{
        
        String sql = "select ms.mensaliCodPag,ms.mensaliDtVenc,a.ativNome,ms.mensaliStatusPag from t_mensali ms inner join t_matrAlu m\n" +
                     "on m.matrCod = ms.matrCod\n" +
                     "inner join t_ativ a\n" +
                     "on a.ativCod = m.ativCod\n" +
                     "and m.aluCod = ?\n" +
                     "and ms.mensaliStatusPag = 'Aberta'";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, cod);
        
        ResultSet rs = stmt.executeQuery();
        List<Mensali_bean> lista = new ArrayList<>();
        while (rs.next()) {
        Mensali_bean c1 = new Mensali_bean();
        
        c1.setMensaliCodPag(rs.getInt("mensaliCodPag"));
        c1.setMensaliDtVenc(rs.getDate("mensaliDtVenc"));
        c1.setMensaliStatusPag(rs.getString("mensaliStatusPag"));
        c1.setAtivNome(rs.getString("ativNome"));
        
        lista.add(c1);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
