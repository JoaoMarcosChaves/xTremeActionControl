/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.Dao;

import br.control.Beans.DescVal_bean;
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
public class DescVal_dao {
    private Connection conexao;
    
    public DescVal_dao()throws SQLException{
        this.conexao = new ConectaBanco().getConexao();
    }
    
    public void CadDescVal(DescVal_bean bean)throws SQLException{
        String sql = "INSERT INTO [dbo].[t_descVal]\n" +
"                    ([descVal]\n" +
"                    ,[descQtdAtiv]\n" +
"                    ,[descStatus])\n" +
"                    VALUES\n" +
"                    (?\n" +
"                    ,?\n" +
"                    ,'Ativo')";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setFloat(1, bean.getDescVal());
        stmt.setInt(2, bean.getDescQtdAtiv());
        
        stmt.execute();
        stmt.close();
        
        
    }
    
    public List<DescVal_bean> ConsUltimoDescCad()throws SQLException{
        
        String sql = "select * from t_descVal where descCod = (select MAX(descCod)descCod from t_descVal) ";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<DescVal_bean> lista = new ArrayList<>();
        
        while (rs.next()) {
            DescVal_bean c1 = new DescVal_bean();
            
            c1.setDescCod(rs.getInt("descCod"));
            c1.setDescVal(rs.getFloat("descVal"));
            c1.setDescQtdAtiv(rs.getInt("descQtdAtiv"));
            c1.setDescStatus(rs.getString("descStatus"));
            
            lista.add(c1);
        }
        return lista;
    }
    
    public List<DescVal_bean> ConsDescCad(DescVal_bean bean)throws SQLException{
        
        String sql = "";
        
        if(bean.getDescCod() == 0 && bean.getDescVal() == 0 && bean.getDescQtdAtiv() ==0){
            sql = "select * from t_descVal";
        }
        else if(bean.getDescCod() != 0 && bean.getDescVal() == 0 && bean.getDescQtdAtiv() ==0){
            sql = "select * from t_descVal where descCod = "+bean.getDescCod();
        }
        else if(bean.getDescCod() != 0 && bean.getDescVal() != 0 && bean.getDescQtdAtiv() ==0){
            sql = "select * from t_descVal where descCod = "+bean.getDescCod();
        }
        else if(bean.getDescCod() != 0 && bean.getDescVal() == 0 && bean.getDescQtdAtiv() !=0){
            sql = "select * from t_descVal where descCod = "+bean.getDescCod();
        }
        else if(bean.getDescCod() != 0 && bean.getDescVal() != 0 && bean.getDescQtdAtiv() !=0){
            sql = "select * from t_descVal where descCod = "+bean.getDescCod();
        }
        else if(bean.getDescCod() == 0 && bean.getDescVal() != 0 && bean.getDescQtdAtiv() ==0){
            sql = "select * from t_descVal where  descVal = "+bean.getDescVal();
        }
        else if(bean.getDescCod() == 0 && bean.getDescVal() == 0 && bean.getDescQtdAtiv() !=0){
            sql = "select * from t_descVal where  descQtdAtiv = "+bean.getDescQtdAtiv();
        }
        
        if(bean.getDesativ() == 0 && bean.getDescCod() == 0 && bean.getDescVal() == 0 && bean.getDescQtdAtiv() ==0){
            sql += "\nwhere descStatus = 'Ativo'";
        }else if(bean.getDesativ() == 0) {
            sql += "\nand descStatus = 'Ativo'";
        }
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<DescVal_bean> lista = new ArrayList<>();
        
        while (rs.next()) {
            DescVal_bean c1 = new DescVal_bean();
            
            c1.setDescCod(rs.getInt("descCod"));
            c1.setDescVal(rs.getFloat("descVal"));
            c1.setDescQtdAtiv(rs.getInt("descQtdAtiv"));
            c1.setDescStatus(rs.getString("descStatus"));
            
            lista.add(c1);
        }
        rs.close();
        stmt.close();
        return lista;
    }
    
  public void AlteraDesc(DescVal_bean bean)throws SQLException{
      String sql = "update t_descVal set descVal = ? , descQtdAtiv = ? where descCod = ?";
      PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setFloat(1, bean.getDescVal());
        stmt.setInt(2, bean.getDescQtdAtiv());
        stmt.setInt(3, bean.getDescCod());
        
        stmt.execute();
        stmt.close();
        
  }
  
  public void DesativaDesc(DescVal_bean bean)throws SQLException{
      String sql = "update t_descVal set descStatus = 'Inativo' where descCod = ?";
      PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        stmt.setInt(1, bean.getDescCod());
        
        stmt.execute();
        stmt.close();
        
  }
  
  public void ReativaDesc(DescVal_bean bean)throws SQLException{
      String sql = "update t_descVal set descStatus = 'Ativo' where descCod = ?";
      PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getDescCod());
        
        stmt.execute();
        stmt.close();
        
  }
}
