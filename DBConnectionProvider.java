/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DBConnectionProvider {
    private final String DB_PATH = "C:\\Users\\admin\\Desktop\\Project\\LensDraft\\data\\";
    
    public Connection getConnection(String databaseName){
        //the target format for connection string is :
        //   jdbc:sqlite:path\\database
        // jdbc:sqlite:C:\\Users\\admin\\Desktop\\Project\\SQL_Database_Draft\\data\\hr.bd
        String engine = "jdbc:sqlite";
        String connectionString = engine+":"+DB_PATH+databaseName;
        
       
        try {
           Connection dbConnection = DriverManager.getConnection(connectionString);
            return dbConnection;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionProvider.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    
    }
}
