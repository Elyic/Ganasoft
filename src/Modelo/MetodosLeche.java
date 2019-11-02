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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class MetodosLeche {
    private Modelo.Conexion conexion = new Modelo.Conexion();
    
    
    //Este metodo llena el ingreso de leche
    //FALTA EL INGRESO DE REVISIÓN DE FECHA
    public boolean IngresoRegLeche (Controlador.Leche L)
    {
        boolean v = false;
        Connection conecta = conexion.getConexion();
         if (conecta!=null) {
             try {
                 String SQL = "INSERT INTO Leche(ID_ANIMAL, CALIDAD, CANTIDAD_PRODUCIDA, FECHA_REVISION, OBSERVACIONES)"
                         +" values(?,?,?,?,?)";
                 PreparedStatement preparedStmt = conecta.prepareStatement(SQL);
//                 File image = new File(ruta);
//                 FileInputStream fis = new FileInputStream(image);
                 preparedStmt.setString(1, L.getID_ANIMAL());
                 preparedStmt.setString(2, L.getCALIDAD());
                 preparedStmt.setString(3, L.getCANTIDAD_PRODUCIDA());
                 preparedStmt.setString(4, L.getFECHA_REVISION());
                 preparedStmt.setString(5, L.getOBSERVACIONES());
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

        public boolean BorrarRegistro (int id){
            boolean v = false;
         Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
        if (conecta!= null) {
            try {
                PreparedStatement st = conecta.prepareStatement("DELETE FROM LECHE WHERE ID_LECHE = ?");
                    st.setInt(1, id);
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
        
    public void CargarTabla(DefaultTableModel tableModel, String ID){
        //String sql ="Select * from persona";
        Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
        try {
            ResultSet resultado = null;
            tableModel.setRowCount(0);
            tableModel.setColumnCount(0);
           // PreparedStatement st = conecta.prepareStatement(sql);
            PreparedStatement st = conecta.prepareStatement("SELECT\n" +
"ID_LECHE AS CORRELATIVO\n" +
",ID_ANIMAL AS 'No. REGISTRO'\n" +
",CALIDAD\n" +
",CANTIDAD_PRODUCIDA AS 'CANTIDAD PRODUCIDA'\n" +
",FECHA_REVISION AS 'FECHA REVISION'\n" +
",OBSERVACIONES\n" +
" FROM LECHE\n" +
" WHERE ID_ANIMAL = ?");
            //PreparedStatement st = conecta.prepareStatement("select * from persona where id = ?");
                  st.setString(1, ID);                  
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

    public boolean Actualizar(Controlador.Leche L){
         Modelo.Conexion conexion = new Modelo.Conexion();
         Connection conecta = conexion.getConexion();
         boolean v  = false;
        if (conecta!= null) {
            try {
                PreparedStatement st = conecta.prepareStatement("UPDATE [dbo].[LECHE]\n" +
"   SET \n" +
"       [CALIDAD]			= ?\n" +
"      ,[CANTIDAD_PRODUCIDA] = ?\n" +
"      ,[FECHA_REVISION]		= ?\n" +
"      ,[OBSERVACIONES]		= ?\n" +
" WHERE ID_LECHE = ?");
            //PreparedStatement st = conecta.prepareStatement("select * from persona where id = ?");

                 st.setString(1, L.getCALIDAD());
                 st.setString(2, L.getCANTIDAD_PRODUCIDA());
                 st.setString(3, L.getFECHA_REVISION());
                 st.setString(4, L.getOBSERVACIONES());
                 st.setInt(5, L.getID_LECHE());
                  st.execute();
                  v = true;
            } catch (SQLException ex) {
                Logger.getLogger(MetodosFertilidad.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                try {
                    conecta.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MetodosFertilidad.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return v;
    }

}
