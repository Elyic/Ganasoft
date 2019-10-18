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
public class MetodosVacunacion {
    private Modelo.Conexion conexion = new Modelo.Conexion();
    
    
    //Este metodo llena el ingreso de Fertilidad
    //FALTA EL INGRESO DE FECHA DE VACUNACIÓN
    public boolean IngresoRegVacunacion(String id_animal, String fechaVacuna, String medicina,
            String cantMedicina, String observaciones)
    {
        boolean v = false;
        Connection conecta = conexion.getConexion();
        String ruta = System.getProperty("user.dir")+"/test.jpg";
         if (conecta!=null) {
             try {
                 String SQL = "INSER INTO Vacunacion(ID_ANIMAL, FECHA_VACUNACION, MEDICINA, CANTIDAD_MEDICINA, OBSERVACIONES)"
                         +" values(?,?,?,?,?)";
                 PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
//                 File image = new File(ruta);
//                 FileInputStream fis = new FileInputStream(image);
                 preparedStmt.setString(1, id_animal);
                 preparedStmt.setString(2, fechaVacuna);
                 preparedStmt.setString(3, medicina);
                 preparedStmt.setString(4, cantMedicina);
                 preparedStmt.setString(5, observaciones);
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
