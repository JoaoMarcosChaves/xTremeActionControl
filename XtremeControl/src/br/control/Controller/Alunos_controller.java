
package br.control.Controller;

import br.control.Beans.Alunos_bean;
import br.control.Dao.Alunos_dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joãomarcos
 */
public class Alunos_controller {

    public void cadAluno(Alunos_bean bean)throws SQLException{
        Alunos_dao  dao = new Alunos_dao();
        
        dao.cadAluno(bean);
    }
    
     public void cadTelefAlu(String tel, String tip)throws SQLException{
        Alunos_dao  dao = new Alunos_dao();
        dao.cadTelefAlu(tel, tip);
    }
    
    public void cadEmailAlu(String email)throws SQLException{
        Alunos_dao  dao = new Alunos_dao();
        dao.cadEmailAlu(email);
    }
    
    public List<Alunos_bean> ConsultaAlu(Alunos_bean bean)throws SQLException{
        Alunos_dao  dao = new Alunos_dao();
        List<Alunos_bean> alu = new ArrayList<>();
        List<Alunos_bean> aluDef = new ArrayList<>();
        List<Alunos_bean> desc = new ArrayList<>();
      
       alu =  dao.ConsultaAlu(bean);
      
           return alu;
      
        
    }
    
    public List<Alunos_bean> ConsultaTelefsAlu(Alunos_bean bean)throws SQLException{
        Alunos_dao  dao = new Alunos_dao();
        List<Alunos_bean> tel = new ArrayList<>();
        
        tel = dao.ConsultaTelefsAlu(bean);
        
        return tel;
    }
    
     public List<Alunos_bean> ConsultaEmailAlu(Alunos_bean bean)throws SQLException{
         Alunos_dao  dao = new Alunos_dao();
        List<Alunos_bean> em = new ArrayList<>();
        
        em = dao.ConsultaEmailAlu(bean);
        
        return em;
     }
     
     public void AlteraEmailAlu(Alunos_bean bean)throws SQLException{
         Alunos_dao  dao = new Alunos_dao();
         
         dao.AlteraEmailAlu(bean);
     }
     
     public void AlteraTelefAlu(Alunos_bean bean)throws SQLException{
         Alunos_dao  dao = new Alunos_dao();
         
         dao.AlteraTelefAlu(bean);
     }
     
     public void AlteraAlu(Alunos_bean bean)throws SQLException{
         Alunos_dao  dao = new Alunos_dao();
         
         dao.AlteraAlu(bean);
     }
     
     public void ExcluiTelAlu(Alunos_bean bean)throws SQLException{
         Alunos_dao  dao = new Alunos_dao();
         dao.ExcluiTelAlu(bean);
    }
    
    public void ExcluiEmailAlu(Alunos_bean bean)throws SQLException{
         Alunos_dao  dao = new Alunos_dao();
         dao.ExcluiEmailAlu(bean);
    }
    
    public void cadTelefAlu(Alunos_bean bean)throws SQLException{
        Alunos_dao  dao = new Alunos_dao();
        dao.cadTelefAlu(bean);
    }
    
    public void cadEmailAlu(Alunos_bean bean)throws SQLException{
        Alunos_dao  dao = new Alunos_dao();
        dao.cadEmailAlu(bean);
    }
}
