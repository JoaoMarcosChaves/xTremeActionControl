
package br.control.Controller;

import br.control.Beans.Ativ_bean;
import br.control.Beans.Matricula_bean;
import br.control.Beans.Mensali_bean;
import br.control.Dao.Ativ_dao;
import br.control.Dao.MatrAlu_dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joãomarcos
 */
public class MatrAlu_controller {

public List<Ativ_bean> ConsultaAtivs(Ativ_bean bean)throws SQLException{
       Ativ_dao dao = new Ativ_dao();
       List<Ativ_bean> lista = new ArrayList<>();
       lista =  dao.ConsultaAtivs(bean);
       return lista;
   }

public void CadMatricAlu(Matricula_bean bean)throws SQLException{
    MatrAlu_dao dao = new MatrAlu_dao();
    
    dao.CadMatricAlu(bean);
}

    
    public int ConsultaUltimaMat()throws SQLException{
        MatrAlu_dao dao = new MatrAlu_dao();
        int matr = 0;
        
        matr = dao.ConsultaUltimaMat();
        return matr;
    }

    public List<Matricula_bean> ConsultaMatriculas(Matricula_bean bean)throws SQLException{
        MatrAlu_dao dao = new MatrAlu_dao();
        List<Matricula_bean> lista = new ArrayList<>();
        lista = dao.ConsultaMatriculas(bean);
        return lista;
    }
    
    public void TrancMatricAlu(Matricula_bean bean)throws SQLException{
        MatrAlu_dao dao = new MatrAlu_dao();
        
        dao.TrancMatricAlu(bean);
    }
    
    public void DestrancMatricAlu(Matricula_bean bean)throws SQLException{
        MatrAlu_dao dao = new MatrAlu_dao();
        
        dao.DestrancMatricAlu(bean);
    }
    
    public List<Matricula_bean> consultaMatriculasAlunosComp(Matricula_bean bean)throws SQLException{
        MatrAlu_dao dao = new MatrAlu_dao();
        List<Matricula_bean> lista = new ArrayList<>();
        
        lista = dao.consultaMatriculasAlunosComp(bean);
                
        return lista;
    }
    
    public List<Mensali_bean> ConsultaMensalis(int cod)throws SQLException{
        MatrAlu_dao dao = new MatrAlu_dao();
        List<Mensali_bean> lista = new ArrayList<>();
        
        lista = dao.ConsultaMensalis(cod);
                
        return lista;
        
    }
    
    public void MarcarMensPaga(Mensali_bean bean)throws SQLException{
        MatrAlu_dao dao = new MatrAlu_dao();
        
        dao.MarcarMensPaga(bean);
    }
    
    public List<Mensali_bean> ConsultaMensalisDeTodos()throws SQLException{
        MatrAlu_dao dao = new MatrAlu_dao();
        List<Mensali_bean> lista = new ArrayList<>();
        
        lista = dao.ConsultaMensalisDeTodos();
                
        return lista;
    }
    
    public void AdicionaNovaMensAosVenc()throws SQLException{
        MatrAlu_dao dao = new MatrAlu_dao();
        dao.AdicionaNovaMensAosVenc();
    }
}
