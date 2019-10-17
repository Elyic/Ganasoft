/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class MetodosAnimal {
private Modelo.Conexion conexion = new Modelo.Conexion();
//Este Metodo llena el combobox de Padre
public boolean CargarPadres(DefaultComboBoxModel modeloCombo){
         boolean v=false;
         Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 Statement stConsulta =conecta.createStatement();
                 String sSQL ="SELECT '' AS DESCRIPCION\n" +
"UNION SELECT ID_ANIMAL+' - '+DESCRIPCION AS DESCRIPCION FROM ANIMAL WHERE SEXO = 'M'"; 
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                  modeloCombo.removeAllElements();
                 while(rsResultado.next()){
                     modeloCombo.addElement(rsResultado.getObject("DESCRIPCION"));
                     modeloCombo.setSelectedItem(rsResultado.getObject("DESCRIPCION"));
                 }
                 v=true;
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
         return v;
     }
//Este metodo llena el combobox de Madre
public boolean CargarMadres(DefaultComboBoxModel modeloCombo){
         boolean v=false;
         Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 Statement stConsulta =conecta.createStatement();
                 String sSQL ="SELECT '' AS DESCRIPCION\n" +
"UNION SELECT ID_ANIMAL+' - '+DESCRIPCION AS DESCRIPCION FROM ANIMAL WHERE SEXO = 'H'"; 
                 ResultSet rsResultado= stConsulta.executeQuery(sSQL);
                  modeloCombo.removeAllElements();
                 while(rsResultado.next()){
                     modeloCombo.addElement(rsResultado.getObject("DESCRIPCION"));
                     modeloCombo.setSelectedItem(rsResultado.getObject("DESCRIPCION"));
                 }
                 v=true;
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
         return v;
     }
//Metodo que inserta los datos en la base
public boolean IngresoPersona (String CUI, String PNombre, String SNombre, String TNombre, String ApePaterno, String ApeMaterno,int depto,int muni,int carrera, int genero, String EstadoC, String NAC)
    {
        boolean v = false;
        Connection conecta = conexion.getConexion();
        String ruta = System.getProperty("user.dir")+"/test.jpg";
         if (conecta!=null) {
             try {
                 String SQL = "insert into Persona(CUI,PRIMER_NOMBRE,SEGUNDO_NOMBRE,TERCER_NOMBRE,APELLDIO_PATERNO,APELLIDO_MATERNO,ID_DEPARTAMENTO,ID_MUNICIPIO,ID_GENERO,ID_CARRERA,NACIONALIDAD,ESTADO_CIVIL,FOTO) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                 PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
                 File image = new File(ruta);
                 FileInputStream fis = new FileInputStream(image);
                 preparedStmt.setString(1, CUI);
                 preparedStmt.setString(2, PNombre);
                 preparedStmt.setString(3, SNombre);
                 preparedStmt.setString(4, TNombre);
                 preparedStmt.setString(5, ApePaterno);
                 preparedStmt.setString(6, ApeMaterno);
                 preparedStmt.setInt(7, depto);
                 preparedStmt.setInt(8, muni);
                 preparedStmt.setInt(9, genero);
                 preparedStmt.setInt(10, carrera);
                 preparedStmt.setString(11, NAC);
                 preparedStmt.setString(12, EstadoC);
                 preparedStmt.setBinaryStream(13, fis, (int) image.length());
                 preparedStmt.execute();
                 v = true;
             } catch (SQLException ex) {
                 Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE, null, ex);
             } catch (FileNotFoundException ex) {
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
