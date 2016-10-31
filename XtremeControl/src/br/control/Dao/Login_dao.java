
package br.control.Dao;

import br.control.Beans.Login_bean;
import br.control.ConexaoBd.ConectaBanco;
import br.control.interfaces.Descriptografar;
import br.control.interfaces.InterfaceCrip;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login_dao {

private Connection conexao;
    
    public Login_dao() throws SQLException{
        this.conexao = ConectaBanco.getConexao();    
   }   
    
    public void CadUser(Login_bean bean)throws SQLException{
        String sql = "INSERT INTO [dbo].[t_ususSis]\n" +
"           ([ususTipo]\n" +
"           ,[ususLogin]\n" +
"           ,[ususSenha]\n" +
"           ,[ususEmail])\n" +
"           VALUES\n" +
"           (1\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, bean.getUsusLogin());
        stmt.setString(2, bean.getUsusSenha());
        stmt.setString(3, bean.getUsusEmail());
        
        stmt.execute();
        stmt.close();
    }
    
    public boolean ConsultaTotUsersCad()throws SQLException{
     int tot = 0;
       String sql = "select count(ususCod)tot from t_ususSis";
       PreparedStatement stmt = this.conexao.prepareStatement(sql);
       ResultSet rs = stmt.executeQuery();
       
       while(rs.next()){
           tot = rs.getInt("tot");
       }
       rs.close();
       stmt.close();
       if(tot == 0){
           return true;
       }else{
           return false;
       }
     
    }    
    
    public boolean AcessarSistema(Login_bean bean)throws SQLException{
        String sql = "select * from t_ususSis where ususLogin = ? ";
        boolean ret = false;
       PreparedStatement stmt = this.conexao.prepareStatement(sql);
       stmt.setString(1, bean.getUsusLogin());
       ResultSet rs = stmt.executeQuery();
       InterfaceCrip i = new Descriptografar();
       while(rs.next()){
           if(i.TipoCrip(rs.getString("ususSenha")).equals(bean.getUsusSenha())){
               ret =  true;
           }
       }
       rs.close();
       stmt.close();
       return ret;
    }
}
