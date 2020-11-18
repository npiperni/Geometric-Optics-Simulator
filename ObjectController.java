/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DBConnectionProvider;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.object;

/**
 *
 * @author admin
 */
public class ObjectController {
    private String datbaseName = "object.db";
    private String tableName = "objectProperties";
    
    
    public void setSqlObjectProperties(object o){
    DBConnectionProvider dbp = new DBConnectionProvider();
        
    Connection connector = dbp.getConnection(datbaseName);
     
    String query = "INSERT INTO "+tableName+" VALUES ("+o.getObjectDistance()
    +", "+o.getObjectHeight()+", "+o.getFocalPoint()+", "+o.getImageDistance()
    +", "+o.getImageHeight()+", '"+o.getLensType()+"'";
     
    try{
        Statement statement = connector.createStatement();
        statement.executeUpdate(query);
        
    }catch(SQLException ex){
    Logger.getLogger(ObjectController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }
    
    
}
