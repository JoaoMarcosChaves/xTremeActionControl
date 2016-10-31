/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.Controller;

import br.control.Beans.Login_bean;
import br.control.Dao.Login_dao;
import java.sql.SQLException;

/**
 *
 * @author joãomarcos
 */
public class Login_controller {
    
    public boolean ConsultaTotUsersCad()throws SQLException{
        Login_dao dao = new Login_dao();
        
        return dao.ConsultaTotUsersCad();
    }
    
    public void CadUser(Login_bean bean)throws SQLException{
        Login_dao dao = new Login_dao();
        
        dao.CadUser(bean);
    }
    
    public boolean AcessarSistema(Login_bean bean)throws SQLException{
        Login_dao dao = new Login_dao();
        
        return dao.AcessarSistema(bean);
    }
}
