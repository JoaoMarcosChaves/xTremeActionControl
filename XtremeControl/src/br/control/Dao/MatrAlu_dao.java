/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.Dao;

import br.control.Beans.Matricula_bean;
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
        String sql = "INSERT INTO [dbo].[t_matrAlu]\n" +
"           ([aluCod]\n" +
"           ,[ativCod]\n" +
"           ,[matrValMens]\n" +
"           ,[matrDt]"+
"           ,[matrStatus])\n" +
"           VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,getdate()"+
"           ,'Aberto')";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getAluCod());
        stmt.setInt(2, bean.getAtivCod());
        stmt.setFloat(3, bean.getMatrValMens());
        //stmt.setDate(4, bean.getMatrDtVenc());
        
        
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
    
    public void InsereInfMensal(Matricula_bean bean)throws SQLException{
        String sql = "INSERT INTO [dbo].[t_mensali]\n" +
"           ([matrCod]\n" +
"           ,[mensaliStatusPag]\n" +
"           ,[mensaliDtVenc])\n" +
"           VALUES\n" +
"           (?\n" +
"           ,'Aberta'\n" +
"           ,?)";
        
         PreparedStatement stmt = this.conexao.prepareStatement(sql);
         
         stmt.setInt(1, bean.getMatrCod());
         stmt.setDate(2, bean.getMatrDtVenc());
         
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
}
