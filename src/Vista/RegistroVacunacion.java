/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class RegistroVacunacion extends javax.swing.JFrame {

    /**
     * Creates new form RegistroVacunacion
     */
    public RegistroVacunacion() {
        initComponents();
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
        txtIdAnimal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMedicina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantMedicina = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaVacuna = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Id Animal:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 110, 80, 27));
        getContentPane().add(txtIdAnimal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 209, -1));

        jLabel2.setText("Medicina:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 140, 80, 27));
        getContentPane().add(txtMedicina, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 209, -1));

        jLabel3.setText("Cantidad Medicina:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 140, 27));
        getContentPane().add(txtCantMedicina, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 180, -1));

        jLabel4.setText("Fecha Vacunación:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 113, 27));
        getContentPane().add(txtFechaVacuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 180, -1));

        jLabel5.setText("Observasiones:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 113, 27));
        getContentPane().add(txtObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 200, -1));

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar-documento-icono-7840-32.png"))); // NOI18N
        jButton2.setText("Guardar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 130, 40));

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/espalda.png"))); // NOI18N
        jButton1.setText("Volver");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 130, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("VACUNACION");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/jeringa64.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/azul.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 450, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        Controlador.Animal Animal = new Controlador.Animal();
//        Modelo.MetodosAnimal MA = new Modelo.MetodosAnimal();
//        Modelo.MetodosRaza MR = new Modelo.MetodosRaza();
//        Modelo.MetodosCategoria MC = new Modelo.MetodosCategoria();
//        String fnacim = "";
//        if(NoRegistro.getText().isEmpty() || NoLote.getText().isEmpty() || FechaNac.getDate().toString().isEmpty()
//            || Procedencia.getText().isEmpty() ){
//
//        }else{
//            if(MA.VerificarID(NoRegistro.getText())){
//                JOptionPane.showMessageDialog(null, "El No de Registro "+NoRegistro.getText()+" ya esta en uso!!!");
//            }else{
//                Animal.setID_ANIMAL(NoRegistro.getText());
//                Animal.setNO_LOTE(NoLote.getText());
//                try {
//                    Date date = FechaNac.getDate();
//                    String formato = FechaNac.getDateFormatString();
//                    System.out.println(formato);
//                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                    fnacim = String.valueOf(sdf.format(date));
//                    System.out.println(fnacim);
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "Escoja un fecha Valida ", "Error..!!", JOptionPane.ERROR_MESSAGE);
//                }
//                Animal.setFECHA_NACIMIENTO(fnacim);
//                Animal.setPROCEDENCIA(Procedencia.getText());
//                //                  JFileChooser fileChooser = new JFileChooser();
//                //int seleccion = fileChooser.showOpenDialog(Foto);
//                //if (seleccion == fileChooser.APPROVE_OPTION)
//                //{
//                    //    fichero = fileChooser.getSelectedFile();
//                    //    System.out.println(fichero.getAbsolutePath());
//                    //}            try{
//                    if(foto){
//                        if(fichero.getAbsolutePath() != null){
//                            Animal.setFOTO(fichero.getAbsolutePath());
//                        }
//                    }
//                    if(!"".equals((String) ComboPadre.getSelectedItem())){
//                        Animal.setPADRE(MA.ConsultarID((String) ComboPadre.getSelectedItem()));
//                    }
//                    if(!"".equals((String) ComboMadre.getSelectedItem())){
//                        Animal.setMADRE(MA.ConsultarID((String) ComboMadre.getSelectedItem()));
//                    }
//                    Animal.setTIPO(Tipo.getText());
//                    if(!NoPartos.getText().isEmpty()){
//                        Animal.setNO_HIJOS(Integer.parseInt(NoPartos.getText()));
//                    }
//                    if(!Peso.getText().isEmpty()){
//                        Animal.setPESO(Float.parseFloat(Peso.getText()));
//                    }
//
//                    Animal.setRAZA(MR.ConsultarID((String) ComboRaza.getSelectedItem()));
//                    Animal.setSEXO((String) ComboSexo.getSelectedItem());
//                    Animal.setCATEGORIA(MC.ConsultarID((String) ComboCategoria.getSelectedItem()));
//                    if(!PrecioCompra.getText().isEmpty()){
//                        Animal.setPRECIO_COMPRA(Float.parseFloat(PrecioCompra.getText()));
//                    }
//                    if(!PrecioVenta.getText().isEmpty()){
//                        Animal.setPRECIO_VENTA(Float.parseFloat(PrecioVenta.getText()));
//                    }
//
//                    Animal.setUBICACION(Ubicacion.getText());
//                    Animal.setDESCRIPCION(Descripcion.getText());
//                    Animal.setESTADO((String) ComboEstado.getSelectedItem());
//                    if(MA.IngresoAnimal(Animal)){
//                        JOptionPane.showMessageDialog(null, "Ingresado correctamente!!!!");
//                    }else{
//                        JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar!!!!");
//                    }
//                }
//            }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroVacunacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVacunacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVacunacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVacunacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVacunacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCantMedicina;
    public com.toedter.calendar.JDateChooser txtFechaVacuna;
    private javax.swing.JTextField txtIdAnimal;
    private javax.swing.JTextField txtMedicina;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
