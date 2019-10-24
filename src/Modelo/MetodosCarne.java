/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class MetodosCarne {
     private Modelo.Conexion conexion = new Modelo.Conexion();
    
    
    //Este metodo llena el ingreso de leche
    //FALTA EL INGRESO DE REVISIÓN DE FECHA
    public boolean IngresoRegCarne(Controlador.Carne Carne)
    {
        boolean v = false;
        Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 String SQL = "INSERT INTO CARNE(ID_ANIMAL, ESTADO, CALIDAD, FECHA_REVISION, OBSERVACIONES)"
                         +" values(?,?,?,?,?)";
                 PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
//                 File image = new File(ruta);
//                 FileInputStream fis = new FileInputStream(image);
                 preparedStmt.setString(1, Carne.getID_ANIMAL());
                 preparedStmt.setString(2, Carne.getESTADO());
                 preparedStmt.setString(3, Carne.getCALIDAD());
                 preparedStmt.setString(4, Carne.getFECHA_REVISION());
                 preparedStmt.setString(5, Carne.getOBSERVACIONES());
                 preparedStmt.execute();
                 v = true;
             } catch (SQLException ex) {
                 Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                 try {
                     conecta.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         return v;
    }
}
