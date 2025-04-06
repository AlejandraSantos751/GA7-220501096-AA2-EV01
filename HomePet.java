/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package home.pet;

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
            rs=statement.executeQuery("SELECT * FROM USUARIOS");
            rs.next();
            
            do {
                System.out.println(rs.getInt("ID_Usuario")+" "+rs.getString("Nombre"));
            } while (rs.next());
            
            //Espacio para dividir las consultas
            
            System.out.println(" ");
            
            //Insert
            
            statement.executeUpdate("INSERT INTO USUARIOS VALUES(6, 'Julian', 'Pulido', 'Cédula de ciudadanía', '80456951', 'julipuli83@gmail.com', '3057133981', 'Arrendatario', 'T0y8kA858')");
            rs=statement.executeQuery("SELECT * FROM USUARIOS");
            rs.next();
            
            do {
                System.out.println(rs.getInt("ID_Usuario")+" "+rs.getString("Nombre"));
            } while (rs.next());
            
            
            //Update
            
            statement.executeUpdate("UPDATE USUARIOS SET Correo'carlosramirez98@gmail.com' WHERE ID_Usuario=2");
            rs=statement.executeQuery("SELECT * FROM USUARIOS");
            rs.next();
            
            do {
                System.out.println(rs.getInt("ID_Usuario")+" "+rs.getString("Nombre"));
            } while (rs.next());
            
            
            //Delete
            
            statement.executeUpdate("DELETE FROM USUARIOS WHERE ID_Usuario=6");
            rs=statement.executeQuery("SELECT * FROM USUARIOS");
            rs.next();
            
            do {
                System.out.println(rs.getInt("ID_Usuario")+" "+rs.getString("Nombre"));
            } while (rs.next());
        
        } catch (SQLException ex) {
            Logger.getLogger(HomePet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

