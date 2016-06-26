package endeavor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */

public class Bd {
    
    private Connection con;
    private Statement stmt;
    
    public Bd(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println("Erro: "+ e.getMessage());
        }
        
        String url = "jdbc:mysql://localhost:3306/blocodenotas";
        String user = "root";
        String password = "root";
        
        try{
            con = DriverManager.getConnection(url,user,password);
            stmt = con.createStatement();
        }catch(SQLException e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
    
    
    public void insertRecord(String query){
       try{
           stmt.executeUpdate(query);
       }catch(SQLException e){
           System.out.println("Erro: "+ e.getMessage());
       }
    }
    
}
