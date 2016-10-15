/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.Controller;

import br.control.Beans.DescVal_bean;
import br.control.Dao.DescVal_dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joãomarcos
 */
public class DescVal_controller {
    
    public void CadDescVal(DescVal_bean bean)throws SQLException{
    DescVal_dao dao = new DescVal_dao();
    dao.CadDescVal(bean);
    }
    
    public List<DescVal_bean> ConsUltimoDescCad()throws SQLException{
    DescVal_dao dao = new DescVal_dao();
    List<DescVal_bean> lista = new ArrayList<>();
    lista = dao.ConsUltimoDescCad();
    
    return lista;
    }
    
    public List<DescVal_bean> ConsDescCad(DescVal_bean bean)throws SQLException{
    DescVal_dao dao = new DescVal_dao();
    List<DescVal_bean> lista = new ArrayList<>();
    lista = dao.ConsDescCad(bean);
    
    return lista;
    }
    
    public void AlteraDesc(DescVal_bean bean)throws SQLException{
    DescVal_dao dao = new DescVal_dao();
    dao.AlteraDesc(bean);
    }
    
    public void DesativaDesc(DescVal_bean bean)throws SQLException{
        DescVal_dao dao = new DescVal_dao();
        dao.DesativaDesc(bean);
    }
    
    public void ReativaDesc(DescVal_bean bean)throws SQLException{
        DescVal_dao dao = new DescVal_dao();
        dao.ReativaDesc(bean);
    }
}
