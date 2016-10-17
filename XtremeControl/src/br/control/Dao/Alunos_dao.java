package br.control.Dao;

import br.control.Beans.Alunos_bean;
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
public class Alunos_dao {
private Connection conexao;
    
    public Alunos_dao()throws SQLException{
        this.conexao = new ConectaBanco().getConexao();
    }    
    
    public void cadAluno(Alunos_bean bean)throws SQLException{
        String sql = "INSERT INTO [dbo].[t_alu]\n" +
"           ([aluNome]\n" +
"           ,[aluCpf]\n" +
"           ,[aluPeso]\n" +
"           ,[aluSexo]\n" +
"           ,[aluIdade]\n" +
"           ,[aluCep]\n" +
"           ,[aluNumResid])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, bean.getAluNome());
        stmt.setString(2, bean.getAluCpf());
        stmt.setFloat(3, bean.getAluPeso());
        stmt.setString(4, bean.getAluSexo());
        stmt.setInt(5, bean.getAluIdade());
        stmt.setString(6, bean.getAluCep());
        stmt.setInt(7, bean.getAluNumResid());
        
        stmt.execute();
        stmt.close();
    }
    
    
    public void cadTelefAlu(String tel, String tip)throws SQLException{
        
        String sql = "INSERT INTO [dbo].[t_telefAlu]\n" +
"           ([aluCod]\n" +
"           ,[telefNum]\n" +
"           ,[telefTip])\n" +
"           VALUES\n" +
"           ((select max(aluCod)aluCod from t_alu)\n" +
"           ,?\n" +
"           ,?)";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, tel);
        stmt.setString(2, tip);
        
        stmt.execute();
        stmt.close();
    }
    
    public void cadEmailAlu(String email)throws SQLException{
        String sql = "INSERT INTO [dbo].[t_emailAlu]\n" +
"           ([aluCod]\n" +
"           ,[emailAlu])\n" +
      "     VALUES\n" +
"           ((select max(aluCod)aluCod from t_alu)\n" +
"           ,?)";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, email);
        
        
        stmt.execute();
        stmt.close();
    }
    
    public void cadTelefAlu(Alunos_bean bean)throws SQLException{
        
        String sql = "INSERT INTO [dbo].[t_telefAlu]\n" +
"           ([aluCod]\n" +
"           ,[telefNum]\n" +
"           ,[telefTip])\n" +
"           VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?)";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getAluCod());
        stmt.setString(2, bean.getAluTelefone());
        stmt.setString(3, bean.getTelefTip());
        
        stmt.execute();
        stmt.close();
    }
    
    public void cadEmailAlu(Alunos_bean bean)throws SQLException{
        String sql = "INSERT INTO [dbo].[t_emailAlu]\n" +
"           ([aluCod]\n" +
"           ,[emailAlu])\n" +
      "     VALUES\n" +
"           (?\n" +
"           ,?)";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getAluCod());
        stmt.setString(2, bean.getAluEmail());
        
        
        stmt.execute();
        stmt.close();
    }
    
    public void AlteraEmailAlu(Alunos_bean bean)throws SQLException{
        String sql = "update t_emailAlu set emailAlu = ? where  emailCod = ?";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, bean.getAluEmail());
        stmt.setInt(2, bean.getEmailCod());
        
        stmt.execute();
        stmt.close();
    }
    
    public void AlteraTelefAlu(Alunos_bean bean)throws SQLException{
        String sql = "update t_telefAlu set telefNum = ? where telefCod = ?";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, bean.getAluTelefone());
        stmt.setInt(2, bean.getTelefCod());
        
        stmt.execute();
        stmt.close();
    }
    
    public void AlteraAlu(Alunos_bean bean)throws SQLException{
        
            String sql = "update t_alu set aluNome = ?, aluCpf = ?, aluPeso = ?, aluSexo = ?, aluIdade = ?\n" +
",aluCep = ?, aluNumResid = ? where aluCod = ?";
             
             PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setString(1, bean.getAluNome());
        stmt.setString(2, bean.getAluCpf());
        stmt.setFloat(3, bean.getAluPeso());
        stmt.setString(4, bean.getAluSexo());
        stmt.setInt(5, bean.getAluIdade());
        stmt.setString(6, bean.getAluCep());
        stmt.setInt(7, bean.getAluNumResid());
        stmt.setInt(8, bean.getAluCod());
        
        stmt.execute();
        stmt.close();
        
    }
    
    public void ExcluiTelAlu(Alunos_bean bean)throws SQLException{
        
            String sql = "delete from t_telefAlu where telefCod = ?";
             
             PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getTelefCod());
        
        stmt.execute();
        stmt.close();
        
    }
    
    public void ExcluiEmailAlu(Alunos_bean bean)throws SQLException{
        
            String sql = "delete from t_emailAlu where emailCod = ?";
             
             PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, bean.getEmailCod());
        
        stmt.execute();
        stmt.close();
        
    }
    
    
    
    public List<Alunos_bean> ConsultaAlu(Alunos_bean bean)throws SQLException{
    
        String sql = "";
//        System.out.println(bean.getAluCod() +"\n'"+ bean.getAluNome() +"'\n'"+ bean.getAluCpf()+"'\n"+ bean.getAluPeso()+"\n"+
//                 bean.getAluIdade() +"\n'"+ bean.getAluCep()+"'\n"+ bean.getAluNumResid()+"\n"+bean.getAluDescVal()+"\n'"+
//                bean.getAluSexo()+"'");
        
        if(bean.getAluCod() != 0){
           sql = "select * from t_alu where aluCod = "+bean.getAluCod();
        }
        else if(bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            
            sql = "select * from t_alu";
        
        }
        else if(bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'";
        
        }
        
        
        
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\n and aluIdade = "+bean.getAluIdade();
        }
       
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\nand aluNumResid = "+ bean.getAluNumResid();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\nand aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\nand aluCep = "+bean.getAluCep();
        }
        
        
        
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\n and aluIdade = "+bean.getAluIdade()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\nand aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\nand aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\nand aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\nand aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'"+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && !bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluNome like '"+bean.getAluNome()+"%'\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        
        ///////////////////////////////////////////
        
        else if(bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade();
        
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where and aluIdade = "+bean.getAluIdade()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade()+
                    "\nand aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'"+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade()+"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        
        
        
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade()+"\nand aluCep = "+bean.getAluCep();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() != 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade()+"\nand aluNumResid = "+ bean.getAluNumResid();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade()+"\nand aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluIdade = "+bean.getAluIdade()+"\nand aluSexo = '"+bean.getAluSexo();
        }
        
        
        /////////////////////////////////////////////////////////////////////
        
       
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'"+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluSexo = '"+bean.getAluSexo()+"'"+"\nand aluPeso = "+bean.getAluPeso();
        }
        
        
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNumResid = "+ bean.getAluNumResid()+"\nand aluPeso = "+bean.getAluPeso();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() != 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluDescVal = "+ bean.getAluDescVal()+"\nand aluPeso = "+bean.getAluPeso();
        }
        
        
        
        
        ////////////////////////////////////////////////////
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep()+"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        
        
         else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && !bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluCep = "+bean.getAluCep()+"\nand aluNumResid = "+ bean.getAluNumResid();
        }
        
        ////////////////////////////////////////////////////////
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNumResid = "+ bean.getAluNumResid();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluNumResid = "+ bean.getAluNumResid()+"\nand aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() != 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluNumResid = "+"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        /////////////////////////////////////////
        
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()== null){
            sql = "select * from t_alu where aluDescVal = "+ bean.getAluDescVal();
        }
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() != 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluDescVal = "+ bean.getAluDescVal()
                    +"\nand aluSexo = '"+bean.getAluSexo()+"'";
        }
        
        
        //////////////////////////////////////////
        else if (bean.getAluCod() == 0 && bean.getAluNome().equals("") && bean.getAluCpf().equals("") && bean.getAluPeso() == 0
                && bean.getAluIdade() == 0 && bean.getAluCep().equals("") && bean.getAluNumResid() == 0 && bean.getAluDescVal() == 0
                && bean.getAluSexo()!= null){
            sql = "select * from t_alu where aluSexo = '"+bean.getAluSexo()+"'";
        }
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Alunos_bean> lista = new ArrayList<>();
        
        while (rs.next()) {
            Alunos_bean c1 = new Alunos_bean();
            
            c1.setAluCod(rs.getInt("aluCod"));
            c1.setAluNome(rs.getString("aluNome"));
            c1.setAluCpf(rs.getString("aluCpf"));
            c1.setAluPeso(rs.getFloat("aluPeso"));
            c1.setAluSexo(rs.getString("aluSexo"));
            c1.setAluIdade(rs.getInt("aluIdade"));
            if(rs.getString("aluDescVal") == null){
                c1.setValDesc(000);
            }else{
                c1.setValDesc(ConsultaValDesc(rs.getInt("aluDescVal")));
            }
            c1.setAluCep(rs.getString("aluCep"));
            c1.setAluNumResid(rs.getInt("aluNumResid"));
            
            lista.add(c1);
        }
        rs.close();
        stmt.close();
        return lista;
    }
    
      public List<Alunos_bean> ConsultaTelefsAlu(Alunos_bean bean)throws SQLException{
        
          String sql = "select * from t_telefAlu where aluCod = ?";
          
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, bean.getAluCod());
        ResultSet rs = stmt.executeQuery();
        
        
        
        ArrayList<Alunos_bean> lista = new ArrayList<>();
        while (rs.next()) {
            Alunos_bean c1 = new Alunos_bean();
            
            c1.setTelefCod(rs.getInt("telefCod"));
            c1.setAluTelefone(rs.getString("telefNum"));
            c1.setTelefTip(rs.getString("telefTip"));       
            
            lista.add(c1);
        }
        rs.close();
        stmt.close();
        return lista;
      }
      
      public List<Alunos_bean> ConsultaEmailAlu(Alunos_bean bean)throws SQLException{
          String sql = "select * from t_emailAlu where aluCod = ?";
          
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, bean.getAluCod());
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<Alunos_bean> lista = new ArrayList<>();
        while (rs.next()) {
            Alunos_bean c1 = new Alunos_bean();
            
            c1.setEmailCod(rs.getInt("emailCod"));
            c1.setAluEmail(rs.getString("emailAlu"));
            
            lista.add(c1);
        }
        rs.close();
        stmt.close();
        return lista;
      }
      
      public int ConsultaTotMatr(int cod)throws SQLException{
        String sql = "select COUNT(matrCod)matrCod from t_matrAlu where aluCod = ?";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, cod);
        ResultSet rs = stmt.executeQuery();
        
        
        
        int tot = 0;
        while (rs.next()) {
            
            
            tot = rs.getInt("matrCod");
            
            
        }
        rs.close();
        stmt.close();
        return tot;
    }
      
      public float ConsultaValDesc(int cod)throws SQLException{
        String sql = "select * from t_descVal where descCod = ? and descStatus = 'Ativo'";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        stmt.setInt(1, cod);
        ResultSet rs = stmt.executeQuery();
        
        float descVal = 0;
        while (rs.next()) {
           Alunos_bean c1 = new Alunos_bean();
           
            descVal = rs.getFloat("descVal");
            
        }
        rs.close();
        stmt.close();
        return descVal;
    }
      
}
