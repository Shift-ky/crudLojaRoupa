/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudeLojaRoupa.Dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author robsonPaiva
 */
public class ConnectionFactory {
   
    Connection connection;
    
    public Connection getConnection(){
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/loja_roupa?autoReconnect=true&useSSL=false", "root", "251218");
            if(connection != null){
                System.out.println("Conexao estabelecida com sucesso");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
   
    
        return connection;
        
   
    
    }
}
