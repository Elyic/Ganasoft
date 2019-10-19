
package Modelo;

import java.sql.*;

public class Conexion 
{
  Connection con = null;

 public Conexion() {
  try {
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=GANASOFT","sa","123");
   //jdbc:sqlserver://localhost:1433;databaseName=db_proyecto [sa on dbo]
  
  } 
  catch (ClassNotFoundException | SQLException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 public Connection getConexion(){
  return con;
 }
 

}