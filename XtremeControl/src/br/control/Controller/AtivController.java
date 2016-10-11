package br.control.Controller;

import br.control.Beans.Ativ_bean;
import br.control.Dao.Ativ_dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author joãomarcos
 */
public class AtivController {

   
   public void cadAtiv(Ativ_bean bean)throws SQLException{
       Ativ_dao dao = new Ativ_dao();
           dao.cadAtiv(bean);    
   }

   public List<Ativ_bean> ConsultaUltimaAtivCad()throws SQLException{
       Ativ_dao dao = new Ativ_dao();
       List<Ativ_bean> lista = new ArrayList<>();
       lista =  dao.ConsultaUltimaAtivCad();
       return lista;
   }
   
   public List<Ativ_bean> ConsultaAtivs(Ativ_bean bean)throws SQLException{
       Ativ_dao dao = new Ativ_dao();
       List<Ativ_bean> lista = new ArrayList<>();
       lista =  dao.ConsultaAtivs(bean);
       return lista;
   }
   
   public void AlteraAtiv(Ativ_bean bean)throws SQLException{
       Ativ_dao dao = new Ativ_dao();
      dao.AlteraAtiv(bean);
   }
   
   public void DesativaAtiv(Ativ_bean bean)throws SQLException{
       Ativ_dao dao = new Ativ_dao();
       dao.DesativaAtiv(bean);
   }
   
   public void AtivaAtiv(Ativ_bean bean)throws SQLException{
       Ativ_dao dao = new Ativ_dao();
       dao.AtivaAtiv(bean);
   }
}
