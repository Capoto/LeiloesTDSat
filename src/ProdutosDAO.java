/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public int cadastrarProduto (ProdutosDTO produto){
        
        try{
        String sql = "insert into produtos(nome,valor,status) values (?,?,?)";
        
        conn = new conectaDAO().connectDB();
        
        prep = conn.prepareStatement(sql);
        
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getStatus());
        prep.executeUpdate();
        
        System.out.print("Dados cadastrados");
        return 1;
        
        }
        catch(SQLException sqle){
            System.out.println( "Erro no acesso ao Bando de Dados : "+ sqle.getMessage());
            return 0;
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        
        
        try{
            
            String sql = "Select id,nome,valor,status from produtos";
            
            conn = new conectaDAO().connectDB();
        
            prep = conn.prepareStatement(sql);
        
            ResultSet rs = prep.executeQuery(sql);
            
            
            while(rs.next()){
            
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int valor = rs.getInt("valor");
                String status = rs.getString("status");
                
                ProdutosDTO p  = new ProdutosDTO(id,nome,valor,status); 
                listagem.add(p);
            }
        
        
        }catch(SQLException sqle){
        
            System.out.println( "Erro efetuando consulta : " + sqle.getMessage() );
        }
        
        //conn =  new conectaDAO().desconectarDB();
        
        return listagem;
    }
    
    
   public int venderProduto(int id){
   
   
       try{
       
           
           String sql = "update  produtos set status = 'Vendido' where id = ?";
           conn = new conectaDAO().connectDB();
        
           prep = conn.prepareStatement(sql);
        
           prep.setInt(1, id);
           prep.executeUpdate();
           
           System.out.println("Dados atualizados");
           return 1;
       
       }catch(SQLException sqle){
       
           System.out.println("Erro efetaundo atualização de dados : " + sqle.getMessage());
           return 0;
       
       }
   
   
   } 
    
    
        
}

