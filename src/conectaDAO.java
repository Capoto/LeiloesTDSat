
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    Connection conn = null;
    public Connection connectDB(){
        
        
        try {
        
            conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=password");
            
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        }
        return conn;
    }
    
   
    public Connection desconectarDB(){
    
        try {
                conn.close();
            
                System.out.println( "Conexão com o banco de dados fechada" );
            } catch (SQLException sqle) {
               System.out.println( "Erro no fechamento da conexão : " + sqle.getMessage() );
            }
        return conn;
        
    }
    
}
