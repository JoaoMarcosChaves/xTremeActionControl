
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
    
    public List<Alunos_bean> ConsultaUltimoCadastro(Alunos_bean bean)throws SQLException{
        Alunos_dao  dao = new Alunos_dao();
        List<Alunos_bean> alu = new ArrayList<>();
        
      
       alu =  dao.ConsultaAlu(bean);
        
        return alu;
    }
    
}
