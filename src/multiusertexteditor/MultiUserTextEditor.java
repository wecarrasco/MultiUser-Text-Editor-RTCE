/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiusertexteditor;

import java.sql.*;

/**
 *
 * @author Walther
 */
public class MultiUserTextEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection myConn = null;
        try{
            // 1.- Get a connection to database
            System.out.println("Consiguiendo Coneccion");
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin", "wecarrasco", "Djwale2014");
            //myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
            // 2.- Create a statement
            System.out.println("Creando Statement");
            Statement myStmt = myConn.createStatement();
            
            /*System.out.println("Ejecutando query de inserccion");
            myStmt.executeUpdate("insert into user values(default, 'pity', 'miguel', 'miguel@unitec.edu')");*/
            
            /*System.out.println("Ejecutando query de Update");
            myStmt.executeUpdate("update user set password='marcerojas' where username='marcela'");*/
            
            System.out.println("Ejecutando query de Delete");
            myStmt.executeUpdate("delete from user where username='marcela'");
            // 3.- Execute SQL query
            System.out.println("Ejecutando query de lectura");
            ResultSet myRs = myStmt.executeQuery("SELECT * FROM user");

            // 4.- Process the result set
            System.out.println("Buscando resultados");
            //System.out.println(myRs.getString("last_name"));
            while (myRs.next()){
                //System.out.println("Entra");
                System.out.println(myRs.getString("username") + ", " + myRs.getString("password"));
            }
            //myRs.close();
            //myStmt.close();
            myConn.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                myConn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
}
