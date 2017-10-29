/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ALL_IN_ONE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



/**
 *
 * @author evimouth
 */
public class Database_Connection {
    Connection conn;
    Statement stmt;
    ResultSet res;
    public Database_Connection()
    {
        
    }
    public Connection setConnection(){
        try{
            
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/TestDBase?","manosm","r678CKpFr1SuwAft");
           
            
            
        }catch(Exception e)
        {
            
        }
        return conn;
    }
    public ResultSet getResult(String sql,Connection conn){
        this.conn = conn;
        try
        {
            stmt=conn.createStatement();
            res=stmt.executeQuery(sql);
            
        }catch(Exception e)
        {
            
        }
        return res;
}
}
