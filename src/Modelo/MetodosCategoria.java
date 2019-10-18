/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class MetodosCategoria {

private Modelo.Conexion conexion = new Modelo.Conexion();


    public boolean CargarCategoria(DefaultComboBoxModel modeloCombo){
         boolean v=false;
         Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 Statement stConsulta =conecta.createStatement();
                 String sSQL ="SELECT CAST(ID_CATEGORIA AS VARCHAR(10))+' - '+DESCRIPCION AS DESCRIPCION FROM CATEGORIA"; 
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                  modeloCombo.removeAllElements();
                 while(rsResultado.next()){
                     modeloCombo.addElement(rsResultado.getObject("DESCRIPCION"));
                     modeloCombo.setSelectedItem(rsResultado.getObject("DESCRIPCION"));
                 }
                 v=true;
                 conecta.close();
                   } catch (SQLException ex) {
                 Logger.getLogger(MetodosCategoria.class.getName()).log(Level.SEVERE, null, ex);
             }
         }else{
             try {
                 conecta.close();
             } catch (SQLException ex) {
                 Logger.getLogger(MetodosCategoria.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return v;
     }
    public int ConsultarID(String Busqueda){
        boolean v=false;
        int ID = 0;
        Connection conecta = conexion.getConexion();
        if (conecta!=null) {
            try {
                String SQL="SELECT ID_CATEGORIA  FROM CATEGORIA WHERE CAST(ID_CATEGORIA AS VARCHAR(10))+' - '+DESCRIPCION = ?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, Busqueda);
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) { //Es mas correcto poner el next en el while, te hace lo mismo que tenias en tu antiguo codigo pero en menos lineas y mas limpio
                    ID = resultado.getInt("ID_CATEGORIA");
                    v=true;
                }
                conecta.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                conecta.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return ID;
    }
}
