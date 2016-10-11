
package br.control.Dao;

import br.control.Beans.Ativ_bean;
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
public class Ativ_dao {

    private Connection conexao;
    
    public Ativ_dao()throws SQLException{
        this.conexao = new ConectaBanco().getConexao();
    }
    
    public void cadAtiv(Ativ_bean bean)throws SQLException{
        String sql = "INSERT INTO [dbo].[t_ativ]\n" +
"           ([ativNome]\n" +
"           ,[ativDescr]\n" +
"           ,[ativValor]\n" +
"           ,[ativStatus])\n" +
"           VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,'Ativo')";
        
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, bean.getAtivNome());
        stmt.setString(2, bean.getAtivDescr());
        stmt.setFloat(3, bean.getAtivValor());
        
        
        
        stmt.execute();
        stmt.close();
        
    }
    
    public void AlteraAtiv(Ativ_bean bean)throws SQLException{
        String sql = "update t_ativ set ativNome = ?, ativDescr = ?, ativValor = ? where ativCod = ?";
        
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, bean.getAtivNome());
        stmt.setString(2, bean.getAtivDescr());
        stmt.setFloat(3, bean.getAtivValor());
        stmt.setInt(4,bean.getAtivCod());
        
        
        stmt.execute();
        stmt.close();
        
    }
    
    public void DesativaAtiv(Ativ_bean bean)throws SQLException{
        String sql = "update t_ativ set ativStatus = 'Inativo' where ativCod = ?";
        
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1,bean.getAtivCod());
        
        stmt.execute();
        stmt.close();
        
    }
    
    
    public void AtivaAtiv(Ativ_bean bean)throws SQLException{
        String sql = "update t_ativ set ativStatus = 'Ativo' where ativCod = ?";
        
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1,bean.getAtivCod());
        
        stmt.execute();
        stmt.close();
        
    }
    
    public List<Ativ_bean> ConsultaUltimaAtivCad()throws SQLException{
        
        String sql = "select * from t_ativ where ativCod = (select MAX(ativCod)ativCod from t_ativ)";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Ativ_bean> lista = new ArrayList<>();
        
        while (rs.next()) {
            Ativ_bean bean = new Ativ_bean();
            
            bean.setAtivCod(rs.getInt("ativCod"));
            bean.setAtivNome(rs.getString("ativNome"));
            bean.setAtivValor(rs.getFloat("ativValor"));
            bean.setAtivDescr(rs.getString("ativDescr"));
            
            lista.add(bean);
        }
        rs.close();
        stmt.close();
        return lista;
    }
    
    public List<Ativ_bean> ConsultaAtivs(Ativ_bean bean)throws SQLException{
        
        String sql = "";
        if(bean.getAtivCod() != 0 && bean.getAtivNome().equals("") && bean.getAtivValor() == 0){
            sql = "select * from t_ativ where ativCod = "+ bean.getAtivCod();
        }else if(bean.getAtivCod() == 0 && !bean.getAtivNome().equals("") && bean.getAtivValor() == 0){
            sql = "select * from t_ativ where ativNome like '"+ bean.getAtivNome()+"%'";
        }else if(bean.getAtivCod() == 0 && bean.getAtivNome().equals("") && bean.getAtivValor() != 0){
            sql = "select * from t_ativ where ativValor = "+ bean.getAtivValor();
        }else if(bean.getAtivCod() != 0 && !bean.getAtivNome().equals("") && bean.getAtivValor() != 0){
            sql = "select * from t_ativ where ativCod = "+ bean.getAtivCod();
        }else if(bean.getAtivCod() == 0 && bean.getAtivNome().equals("") && bean.getAtivValor() == 0){
            sql = "select * from t_ativ";
        }else if(bean.getAtivCod() == 0 && !bean.getAtivNome().equals("") && bean.getAtivValor() != 0){
            sql = "select * from t_ativ where ativNome like '"+ bean.getAtivNome()+"%'";
        }
        
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Ativ_bean> lista = new ArrayList<>();
        
        while (rs.next()) {
            Ativ_bean c1 = new Ativ_bean();
            
            c1.setAtivCod(rs.getInt("ativCod"));
            c1.setAtivNome(rs.getString("ativNome"));
            c1.setAtivValor(rs.getFloat("ativValor"));
            c1.setAtivDescr(rs.getString("ativDescr"));
            c1.setAtivStatus(rs.getString("ativStatus"));
            
            lista.add(c1);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}
