/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package homepet;

/**
 *
 * @author aleja
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Establecemos Variables
        
        String usuario="root";
        String password="Toyuko2025*";
        String url="jdbc:mysql://localhost:3306/homepet";
        
        //Etablecemos Conexion
        
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomePet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Consulta
        
        try {
            conexion=DriverManager.getConnection(url, usuario, password);
            statement=conexion.createStatement();
            rs=statement.executeQuery("SELECT * FROM HOMEPET.USUARIOS");
            rs.next();
            
            do{                
                System.out.println(rs.getInt("ID_Usuario")+" "+rs.getString("Nombre"));
            } while (rs.next());
            
            //Espacio entre consultas
            
            System.out.println(" ");
            
            //Insert
            
            //statement.executeUpdate("INSERT INTO USUARIOS VALUES(7, 'Nicolas', 'Parra', 'Cédula de ciudadanía', '1085963247', 'nicolas_santos@correo.com', '3005896547', 'Arrendatario', 'N85sa65D')");
            rs=statement.executeQuery("SELECT * FROM HOMEPET.USUARIOS");
            rs.next();
            
            do{                
                System.out.println(rs.getInt("ID_Usuario")+" "+rs.getString("Nombre"));
            } while (rs.next());
            
            
            //Update
            //statement.executeUpdate("UPDATE USUARIOS SET Nombre='María Camila' WHERE ID_Usuario=3");
            System.out.println(" ");
            rs=statement.executeQuery("SELECT * FROM HOMEPET.USUARIOS");
            rs.next();
            
            do{                
                System.out.println(rs.getInt("ID_Usuario")+" "+rs.getString("Nombre"));
            } while (rs.next());
            
            
            //Delete
            
            statement.executeUpdate("DELETE FROM USUARIOS WHERE ID_Usuario=7");
            System.out.println(" ");
            rs=statement.executeQuery("SELECT * FROM HOMEPET.USUARIOS");
            rs.next();
            
            do{                
                System.out.println(rs.getInt("ID_Usuario")+" "+rs.getString("Nombre"));
            } while (rs.next());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(HomePet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
