/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Elyic
 */
public class RegistroAnimal extends javax.swing.JFrame {

    /**
     * Creates new form RegistroAnimal
     */
    File fichero;
    boolean foto = false;
    public RegistroAnimal() {
        initComponents();
        CargarRaza();
        CargarCategoria();
        CargarPadres();
        CargarMadres();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        NoRegistro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NoLote = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Procedencia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ComboPadre = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        ComboMadre = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        Tipo = new javax.swing.JTextField();
        FechaNac = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        NoPartos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Peso = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ComboRaza = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        ComboCategoria = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        PrecioCompra = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        PrecioVenta = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Ubicacion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Descripcion = new javax.swing.JTextField();
        ComboSexo = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        ComboEstado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Foto = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("No. Registro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        getContentPane().add(NoRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 159, -1));

        jLabel2.setText("No. Lote");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        getContentPane().add(NoLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 70, -1));

        jLabel3.setText("Fecha de Nacimiento:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jLabel4.setText("Procedencia:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));
        getContentPane().add(Procedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 166, -1));

        jLabel6.setText("Padre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        ComboPadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 194, -1));

        jLabel7.setText("Madre");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        ComboMadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 191, -1));

        jLabel8.setText("Tipo:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        getContentPane().add(Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 140, -1));
        getContentPane().add(FechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 116, -1));

        jLabel9.setText("No. de Partos");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));
        getContentPane().add(NoPartos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 120, -1));

        jLabel10.setText("Peso");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));
        getContentPane().add(Peso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 80, -1));

        jLabel11.setText("Raza");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        getContentPane().add(ComboRaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 126, -1));

        jLabel12.setText("Categoria");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        getContentPane().add(ComboCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 130, -1));

        jLabel13.setText("Precio Compra");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));
        getContentPane().add(PrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 111, -1));

        jLabel14.setText("Precio Venta");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, -1, -1));
        getContentPane().add(PrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 116, -1));

        jLabel15.setText("Ubicación");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, -1));
        getContentPane().add(Ubicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 140, -1));

        jLabel16.setText("Descripcion");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));
        getContentPane().add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 290, -1));

        ComboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Hembra" }));
        getContentPane().add(ComboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 126, -1));

        jLabel17.setText("Sexo");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        jLabel18.setText("Estado");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, -1));

        ComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Muerto", "Vendido" }));
        getContentPane().add(ComboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 90, -1));

        jLabel5.setText("Foto");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        Foto.setText("Seleccionar....");
        Foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FotoActionPerformed(evt);
            }
        });
        getContentPane().add(Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 130, -1));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Comic Sans MS", 1, 33)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("REGISTRO");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, -1));

        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setText("Generar QR");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, 160, 40));

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 130, 40));

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setText("Volver");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 130, 40));
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Controlador.Animal Animal = new Controlador.Animal();
        Modelo.MetodosAnimal MA = new Modelo.MetodosAnimal();
        Modelo.MetodosRaza MR = new Modelo.MetodosRaza();
        Modelo.MetodosCategoria MC = new Modelo.MetodosCategoria();
        String fnacim = "";
        if(NoRegistro.getText().isEmpty() || NoLote.getText().isEmpty() || FechaNac.getDate().toString().isEmpty()
           || Procedencia.getText().isEmpty() ){
            
        }else{
            HacerQR();
            if(MA.VerificarID(NoRegistro.getText())){
                JOptionPane.showMessageDialog(null, "El No de Registro "+NoRegistro.getText()+" ya esta en uso!!!");
            }else{
            Animal.setID_ANIMAL(NoRegistro.getText());
            Animal.setNO_LOTE(NoLote.getText());
        try {
        Date date = FechaNac.getDate();
        String formato = FechaNac.getDateFormatString();
            System.out.println(formato);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fnacim = String.valueOf(sdf.format(date));
        System.out.println(fnacim);
        } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Escoja un fecha Valida ", "Error..!!", JOptionPane.ERROR_MESSAGE);
}
                    Animal.setFECHA_NACIMIENTO(fnacim);
            Animal.setPROCEDENCIA(Procedencia.getText());
//                  JFileChooser fileChooser = new JFileChooser();
//int seleccion = fileChooser.showOpenDialog(Foto);
//if (seleccion == fileChooser.APPROVE_OPTION)
//{
//    fichero = fileChooser.getSelectedFile();
//    System.out.println(fichero.getAbsolutePath());
//}            try{
        if(foto){
                          if(fichero.getAbsolutePath() != null){
            Animal.setFOTO(fichero.getAbsolutePath());
                }  
        }
            if(!"".equals((String) ComboPadre.getSelectedItem())){
                Animal.setPADRE(MA.ConsultarID((String) ComboPadre.getSelectedItem()));
            }
            if(!"".equals((String) ComboMadre.getSelectedItem())){ 
            Animal.setMADRE(MA.ConsultarID((String) ComboMadre.getSelectedItem()));
            }
            Animal.setTIPO(Tipo.getText());
            if(!NoPartos.getText().isEmpty()){
             Animal.setNO_HIJOS(Integer.parseInt(NoPartos.getText()));
            }
            if(!Peso.getText().isEmpty()){
            Animal.setPESO(Float.parseFloat(Peso.getText()));
            }

            Animal.setRAZA(MR.ConsultarID((String) ComboRaza.getSelectedItem()));
            Animal.setSEXO((String) ComboSexo.getSelectedItem());
            Animal.setCATEGORIA(MC.ConsultarID((String) ComboCategoria.getSelectedItem()));
            if(!PrecioCompra.getText().isEmpty()){
            Animal.setPRECIO_COMPRA(Float.parseFloat(PrecioCompra.getText()));    
            }
            if(!PrecioVenta.getText().isEmpty()){
                Animal.setPRECIO_VENTA(Float.parseFloat(PrecioVenta.getText()));
            }
            
            Animal.setUBICACION(Ubicacion.getText());
            Animal.setDESCRIPCION(Descripcion.getText());
            Animal.setESTADO((String) ComboEstado.getSelectedItem());
            if(MA.IngresoAnimal(Animal)){
                JOptionPane.showMessageDialog(null, "Ingresado correctamente!!!!");
            }else{
                JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar!!!!");
            }    
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void FotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FotoActionPerformed
        // TODO add your handling code here:
      JFileChooser fileChooser = new JFileChooser();
int seleccion = fileChooser.showOpenDialog(Foto);
if (seleccion == fileChooser.APPROVE_OPTION)
{
    fichero = fileChooser.getSelectedFile();
    System.out.println(fichero.getAbsolutePath());
    foto = true;
}
    }//GEN-LAST:event_FotoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed
    public void CargarRaza(){
     Modelo.MetodosRaza MR = new Modelo.MetodosRaza();
     MR.CargarRazas((DefaultComboBoxModel)ComboRaza.getModel());
    }
    public void CargarCategoria(){
        Modelo.MetodosCategoria MC = new Modelo.MetodosCategoria();
        MC.CargarCategoria((DefaultComboBoxModel) ComboCategoria.getModel());
    }
    public void CargarPadres(){
        Modelo.MetodosAnimal MA = new Modelo.MetodosAnimal();
        MA.CargarPadres((DefaultComboBoxModel)ComboPadre.getModel());
    }
    public void CargarMadres(){
        Modelo.MetodosAnimal MA = new Modelo.MetodosAnimal();
        MA.CargarMadres((DefaultComboBoxModel)ComboMadre.getModel());
    }
    
    public void HacerQR(){
    Modelo.MetodosReportes QR= new Modelo.MetodosReportes();
        String fnacim;
        Date date = FechaNac.getDate();
        String formato = FechaNac.getDateFormatString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fnacim = String.valueOf(sdf.format(date));
        QR.ID=NoRegistro.getText();
        QR.Datos="No. de Registro:"+NoRegistro.getText()+"\n"
                +"Raza:"+ComboRaza.getSelectedItem()+"\n"
                +"Categoría:"+ComboCategoria.getSelectedItem()+"\n"
                +"Fecha de Nac.:"+fnacim+"\n"                    //Debo meter la fecha aqui pero no se como
                +"Precio: Q."+PrecioVenta.getText()+"\n";                
        
        try {
            QR.crearQR(QR.Datos);
        } catch (IOException ex) {
            Logger.getLogger(RegistroAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            QR.crearPDF();
        } catch (DocumentException ex) {
            Logger.getLogger(RegistroAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
        QR.mostrarPDF(QR.ID);
    }
    /**
     * @param args the command line arguments
     */

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAnimal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboCategoria;
    private javax.swing.JComboBox<String> ComboEstado;
    private javax.swing.JComboBox<String> ComboMadre;
    private javax.swing.JComboBox<String> ComboPadre;
    private javax.swing.JComboBox<String> ComboRaza;
    private javax.swing.JComboBox<String> ComboSexo;
    private javax.swing.JTextField Descripcion;
    private com.toedter.calendar.JDateChooser FechaNac;
    private javax.swing.JButton Foto;
    private javax.swing.JTextField NoLote;
    private javax.swing.JTextField NoPartos;
    private javax.swing.JTextField NoRegistro;
    private javax.swing.JTextField Peso;
    private javax.swing.JTextField PrecioCompra;
    private javax.swing.JTextField PrecioVenta;
    private javax.swing.JTextField Procedencia;
    private javax.swing.JTextField Tipo;
    private javax.swing.JTextField Ubicacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
