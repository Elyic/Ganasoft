/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Elyic
 */
public class MetodosRaza {
 private Modelo.Conexion conexion = new Modelo.Conexion();
 
    public boolean CargarRazas(DefaultComboBoxModel modeloCombo){
         boolean v=false;
         Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 Statement stConsulta =conecta.createStatement();
                 String sSQL ="SELECT CAST(ID_RAZA AS VARCHAR(10))+' - '+DESCRIPCION AS DESCRIPCION FROM RAZA"; 
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                  modeloCombo.removeAllElements();
                 while(rsResultado.next()){
                     modeloCombo.addElement(rsResultado.getObject("DESCRIPCION"));
                     modeloCombo.setSelectedItem(rsResultado.getObject("DESCRIPCION"));
                 }
                 v=true;
                 conecta.close();
                   } catch (SQLException ex) {
                 Logger.getLogger(MetodosRaza.class.getName()).log(Level.SEVERE, null, ex);
             }
         }else{
             try {
                 conecta.close();
             } catch (SQLException ex) {
                 Logger.getLogger(MetodosRaza.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return v;
     }

}
