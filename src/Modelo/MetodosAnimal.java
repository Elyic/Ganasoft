/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Animal;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elyic
 */
public class MetodosAnimal {
//private Modelo.Conexion conexion = new Modelo.Conexion();
//Este Metodo llena el combobox de Padre
public boolean CargarPadres(DefaultComboBoxModel modeloCombo){
         boolean v=false;
         Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 Statement stConsulta =conecta.createStatement();
                 String sSQL ="SELECT '' AS DESCRIPCION\n" +
"UNION SELECT ID_ANIMAL+' - '+DESCRIPCION AS DESCRIPCION FROM ANIMAL WHERE SEXO = 'Macho'"; 
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
         Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 Statement stConsulta =conecta.createStatement();
                 String sSQL ="SELECT '' AS DESCRIPCION\n" +
"UNION SELECT ID_ANIMAL+' - '+DESCRIPCION AS DESCRIPCION FROM ANIMAL WHERE SEXO = 'Hembra'"; 
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
public boolean IngresoAnimal (Animal Animal) 
    {
        Modelo.Conexion conexion = new Modelo.Conexion();
        boolean v = false;
        Connection conecta = conexion.getConexion();
         String ruta =  "";
         File image = null;
         FileInputStream fis = null;
         String SQL ="";
        if(Animal.getFOTO() != null){
            ruta =  Animal.getFOTO();
             image = new File(ruta);
            try {
                fis = new FileInputStream(image);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }
           SQL = "INSERT INTO [dbo].[ANIMAL]\n" +
"           ([ID_ANIMAL]\n" +
"           ,[DESCRIPCION]\n" +
"           ,[RAZA]\n" +
"           ,[TIPO]\n" +
"           ,[FECHA_NACIMIENTO]\n" +
"           ,[EDAD]\n" +
"           ,[NO_LOTE]\n" +
"           ,[PROCEDENCIA]\n" +
"           ,[CATEGORIA]\n" +
"           ,[NO_HIJOS]\n" +
"           ,[PESO]\n" +
"           ,[PADRE]\n" +
"           ,[MADRE]\n" +
"           ,[UBICACION]\n" +
"           ,[PRECIO_COMPRA]\n" +
"           ,[PRECIO_VENTA]\n" +
"           ,[ESTADO]\n" +
"           ,[SEXO]"+ 
"           ,[FOTO])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?   )";
        }else{
            SQL = "INSERT INTO [dbo].[ANIMAL]\n" +
"           ([ID_ANIMAL]\n" +
"           ,[DESCRIPCION]\n" +
"           ,[RAZA]\n" +
"           ,[TIPO]\n" +
"           ,[FECHA_NACIMIENTO]\n" +
"           ,[EDAD]\n" +
"           ,[NO_LOTE]\n" +
"           ,[PROCEDENCIA]\n" +
"           ,[CATEGORIA]\n" +
"           ,[NO_HIJOS]\n" +
"           ,[PESO]\n" +
"           ,[PADRE]\n" +
"           ,[MADRE]\n" +
"           ,[UBICACION]\n" +
"           ,[PRECIO_COMPRA]\n" +
"           ,[PRECIO_VENTA]\n" +
"           ,[ESTADO]\n" +
"           ,[SEXO]"+ 
"           )\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n  )";
        }

        System.out.println(ruta);
         if (conecta!=null) {
             try {
                    if(Animal.getFOTO() != null){
                 PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
                 preparedStmt.setString(1, Animal.getID_ANIMAL());
                 preparedStmt.setString(2, Animal.getDESCRIPCION());
                 preparedStmt.setInt(3, Animal.getRAZA());
                 preparedStmt.setString(4, Animal.getTIPO());
                 preparedStmt.setString(5, Animal.getFECHA_NACIMIENTO());
                 preparedStmt.setString(6, Animal.getEDAD());
                 preparedStmt.setString(7, Animal.getNO_LOTE());
                 preparedStmt.setString(8, Animal.getPROCEDENCIA());
                 preparedStmt.setInt(9, Animal.getCATEGORIA());
                 preparedStmt.setInt(10, Animal.getNO_HIJOS());
                 preparedStmt.setFloat(11, Animal.getPESO());
                 preparedStmt.setString(12, Animal.getPADRE());
                 preparedStmt.setString(13, Animal.getMADRE());
                 preparedStmt.setString(14, Animal.getUBICACION());
                 preparedStmt.setFloat(15, Animal.getPRECIO_COMPRA());
                 preparedStmt.setFloat(16, Animal.getPRECIO_VENTA());
                 preparedStmt.setString(17, Animal.getESTADO());
                 preparedStmt.setString(18, Animal.getSEXO());
                 preparedStmt.setBinaryStream(19, fis, (int) image.length());
                 preparedStmt.execute();
                 v = true;
                    }else{
                 PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
                 preparedStmt.setString(1, Animal.getID_ANIMAL());
                 preparedStmt.setString(2, Animal.getDESCRIPCION());
                 preparedStmt.setInt(3, Animal.getRAZA());
                 preparedStmt.setString(4, Animal.getTIPO());
                 preparedStmt.setString(5, Animal.getFECHA_NACIMIENTO());
                 preparedStmt.setString(6, Animal.getEDAD());
                 preparedStmt.setString(7, Animal.getNO_LOTE());
                 preparedStmt.setString(8, Animal.getPROCEDENCIA());
                 preparedStmt.setInt(9, Animal.getCATEGORIA());
                 preparedStmt.setInt(10, Animal.getNO_HIJOS());
                 preparedStmt.setFloat(11, Animal.getPESO());
                 preparedStmt.setString(12, Animal.getPADRE());
                 preparedStmt.setString(13, Animal.getMADRE());
                 preparedStmt.setString(14, Animal.getUBICACION());
                 preparedStmt.setFloat(15, Animal.getPRECIO_COMPRA());
                 preparedStmt.setFloat(16, Animal.getPRECIO_VENTA());
                 preparedStmt.setString(17, Animal.getESTADO());
                 preparedStmt.setString(18, Animal.getSEXO());
                 preparedStmt.execute();
                 v = true;
                    }
                 
             } catch (SQLException ex) {
                 Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE, null, ex);
             } finally{
                 try {
                     conecta.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
         return v;
    }

    public String ConsultarID(String Busqueda){
        Modelo.Conexion conexion = new Modelo.Conexion();
        boolean v=false;
        String ID ="";
        Connection conecta = conexion.getConexion();
        if (conecta!=null) {
            try {
                String SQL="SELECT ID_ANIMAL FROM ANIMAL WHERE ID_ANIMAL+' - '+DESCRIPCION = ?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, Busqueda);
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) { //Es mas correcto poner el next en el while, te hace lo mismo que tenias en tu antiguo codigo pero en menos lineas y mas limpio
                    ID = resultado.getString("ID_ANIMAL");
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
    public boolean VerificarID(String Busqueda){
        Modelo.Conexion conexion = new Modelo.Conexion();
        boolean v=false;
        String ID ="";
        Connection conecta = conexion.getConexion();
        if (conecta!=null) {
            try {
                String SQL="SELECT COUNT(1) FROM ANIMAL WHERE ID_ANIMAL = ?";
                PreparedStatement consulta = conecta.prepareStatement(SQL);
                consulta.setString(1, Busqueda);
                ResultSet resultado = consulta.executeQuery();
                while (resultado.next()) { //Es mas correcto poner el next en el while, te hace lo mismo que tenias en tu antiguo codigo pero en menos lineas y mas limpio
//                    ID = resultado.getString("ID_ANIMAL");
                    
                    if(resultado.getInt(1) > 0){
                       v=true; 
                    }
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
        
        return v;
    }
    
    public boolean CargarAnimales(DefaultComboBoxModel modeloCombo){
         boolean v=false;
         Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 Statement stConsulta =conecta.createStatement();
                 String sSQL ="SELECT ID_ANIMAL+' - '+DESCRIPCION AS DESCRIPCION FROM ANIMAL"; 
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

    public void CargarTabla(DefaultTableModel tableModel){
        //String sql ="Select * from persona";
        Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
        try {
            ResultSet resultado = null;
            tableModel.setRowCount(0);
            tableModel.setColumnCount(0);
           // PreparedStatement st = conecta.prepareStatement(sql);
            PreparedStatement st = conecta.prepareStatement("SELECT \n" +
"ID_ANIMAL AS REGISTRO \n" +
",A.DESCRIPCION\n" +
",R.DESCRIPCION AS RAZA\n" +
",C.DESCRIPCION AS CATEGORIA\n" +
",A.PRECIO_COMPRA AS 'PRECIO DE COMPRA'\n" +
",A.PRECIO_VENTA AS 'PRECIO DE VENTA'\n" +
"FROM ANIMAL A\n" +
"INNER JOIN RAZA R\n" +
"ON R.ID_RAZA = A.RAZA\n" +
"INNER JOIN CATEGORIA C\n" +
"ON C.ID_CATEGORIA = A.CATEGORIA");
            //PreparedStatement st = conecta.prepareStatement("select * from persona where id = ?");
                  //st.setInt(1, 1);                  
                  st.execute();
            try {
                resultado = st.executeQuery();
                if(resultado != null)
                {
                    int numeroColumna = resultado.getMetaData().getColumnCount();
                    for(int j = 1;j <= numeroColumna;j++)
                    {
                        tableModel.addColumn(resultado.getMetaData().getColumnName(j));
                    }
                    while(resultado.next())
                    {
                        String []datos = new String[numeroColumna];
                        for(int i = 1;i <= numeroColumna;i++)
                        {
                            datos[i-1] = (String) resultado.getString(i);
                        }
                        tableModel.addRow(datos);
                    }
                }
            }catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"Error al realizar la actualización por"+e.getMessage());
            }
            
            finally
            {
                try
                {
                    st.close();
                    conecta.close();
                    
                    if(resultado != null)
                    {
                        resultado.close();
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }catch(SQLException ex)
        {
              Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
    public boolean BorrarAnimal (String id){
            boolean v = false;
         Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
        if (conecta!= null) {
            try {
                PreparedStatement st = conecta.prepareStatement("DELETE FROM CARNE WHERE ID_ANIMAL IN (?)\n" +
"DELETE FROM FERTILIDAD WHERE ID_ANIMAL IN (?)\n" +
"DELETE FROM LECHE WHERE ID_ANIMAL IN (?)\n" +
"DELETE FROM PARTO WHERE ID_ANIMAL IN (?)\n" +
"DELETE FROM VACUNACION WHERE ID_ANIMAL IN (?)\n" +
"DELETE FROM ANIMAL WHERE ID_ANIMAL = ?");
                    st.setString(1, id);
                    st.setString(2, id);
                    st.setString(3, id);
                    st.setString(4, id);
                    st.setString(5, id);
                    st.setString(6, id);
                    st.execute();
                st.close();
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

     public boolean ActualizaAnimal(Animal Animal){
         Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
         String ruta =  "";
         File image = null;
         FileInputStream fis = null;
         String SQL ="";
         boolean v = false;
         if(Animal.getFOTO() != null){
            ruta =  Animal.getFOTO();
             image = new File(ruta);
            try {
                fis = new FileInputStream(image);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MetodosAnimal.class.getName()).log(Level.SEVERE, null, ex);
            }
            SQL ="UPDATE [dbo].[ANIMAL]\n" +
"   SET \n" +
"      [DESCRIPCION]		= ?\n" +
"      ,[RAZA]				= ?\n" +
"      ,[TIPO]				= ?\n" +
"      ,[FECHA_NACIMIENTO]	= ?\n" +
"      ,[EDAD]				= ?\n" +
"      ,[NO_LOTE]			= ?\n" +
"      ,[PROCEDENCIA]		= ?\n" +
"      ,[CATEGORIA]			= ?\n" +
"      ,[NO_HIJOS]			= ?\n" +
"      ,[PESO]				= ?\n" +
"      ,[PADRE]				= ?\n" +
"      ,[MADRE]				= ?\n" +
"      ,[UBICACION]			= ?\n" +
"      ,[PRECIO_COMPRA]		= ?\n" +
"      ,[PRECIO_VENTA]		= ?\n" +
"      ,[ESTADO]				= ?\n" +
"      ,[SEXO]				= ?\n" +
"      ,[FOTO]				= ?\n" +
" WHERE ID_ANIMAL = ?";
         }else{
             SQL ="UPDATE [dbo].[ANIMAL]\n" +
"   SET \n" +
"      [DESCRIPCION]		= ?\n" +
"      ,[RAZA]				= ?\n" +
"      ,[TIPO]				= ?\n" +
"      ,[FECHA_NACIMIENTO]	= ?\n" +
"      ,[EDAD]				= ?\n" +
"      ,[NO_LOTE]			= ?\n" +
"      ,[PROCEDENCIA]		= ?\n" +
"      ,[CATEGORIA]			= ?\n" +
"      ,[NO_HIJOS]			= ?\n" +
"      ,[PESO]				= ?\n" +
"      ,[PADRE]				= ?\n" +
"      ,[MADRE]				= ?\n" +
"      ,[UBICACION]			= ?\n" +
"      ,[PRECIO_COMPRA]		= ?\n" +
"      ,[PRECIO_VENTA]		= ?\n" +
"      ,[ESTADO]				= ?\n" +
"      ,[SEXO]				= ?\n" +
" WHERE ID_ANIMAL = ?";
         }
        if (conecta!= null) {
            try {
                if(Animal.getFOTO() != null){
                    PreparedStatement st = conecta.prepareStatement(SQL);
                                     st.setString(1, Animal.getDESCRIPCION());
                 st.setInt(2, Animal.getRAZA());
                 st.setString(3, Animal.getTIPO());
                 st.setString(4, Animal.getFECHA_NACIMIENTO());
                 st.setString(5, Animal.getEDAD());
                 st.setString(6, Animal.getNO_LOTE());
                 st.setString(7, Animal.getPROCEDENCIA());
                 st.setInt(8, Animal.getCATEGORIA());
                 st.setInt(9, Animal.getNO_HIJOS());
                 st.setFloat(10, Animal.getPESO());
                 st.setString(11, Animal.getPADRE());
                 st.setString(12, Animal.getMADRE());
                 st.setString(13, Animal.getUBICACION());
                 st.setFloat(14, Animal.getPRECIO_COMPRA());
                 st.setFloat(15, Animal.getPRECIO_VENTA());
                 st.setString(16, Animal.getESTADO());
                 st.setString(17, Animal.getSEXO());
                 st.setBinaryStream(18, fis, (int) image.length());
                 st.setString(19, Animal.getID_ANIMAL());
                 st.execute();
                }else{
                                        PreparedStatement st = conecta.prepareStatement(SQL);
                                     st.setString(1, Animal.getDESCRIPCION());
                 st.setInt(2, Animal.getRAZA());
                 st.setString(3, Animal.getTIPO());
                 st.setString(4, Animal.getFECHA_NACIMIENTO());
                 st.setString(5, Animal.getEDAD());
                 st.setString(6, Animal.getNO_LOTE());
                 st.setString(7, Animal.getPROCEDENCIA());
                 st.setInt(8, Animal.getCATEGORIA());
                 st.setInt(9, Animal.getNO_HIJOS());
                 st.setFloat(10, Animal.getPESO());
                 st.setString(11, Animal.getPADRE());
                 st.setString(12, Animal.getMADRE());
                 st.setString(13, Animal.getUBICACION());
                 st.setFloat(14, Animal.getPRECIO_COMPRA());
                 st.setFloat(15, Animal.getPRECIO_VENTA());
                 st.setString(16, Animal.getESTADO());
                 st.setString(17, Animal.getSEXO());
                 st.setString(18, Animal.getID_ANIMAL());
                 st.execute();
                }
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

public boolean CargarPadres2(DefaultComboBoxModel modeloCombo){
         boolean v=false;
         Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 Statement stConsulta =conecta.createStatement();
                 String sSQL =
"SELECT ID_ANIMAL+' - '+DESCRIPCION AS DESCRIPCION FROM ANIMAL WHERE SEXO = 'Macho'"; 
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
public boolean CargarMadres2(DefaultComboBoxModel modeloCombo){
         boolean v=false;
         Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 Statement stConsulta =conecta.createStatement();
                 String sSQL =
"SELECT ID_ANIMAL+' - '+DESCRIPCION AS DESCRIPCION FROM ANIMAL WHERE SEXO = 'Hembra'"; 
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
}
