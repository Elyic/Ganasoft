/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class RegistroFertilidad extends javax.swing.JFrame {

    /**
     * Creates new form RegistroFertilidad
     */
    public RegistroFertilidad() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.CargarAnimales();
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
        jLabel2 = new javax.swing.JLabel();
        ComboAnimales = new javax.swing.JComboBox<>();
        txtCalidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCantProducida = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFechaRev = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Animal:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 60, 27));

        jLabel2.setText("Calidad: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 54, 27));

        ComboAnimales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ComboAnimales, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 210, -1));

        txtCalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCalidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 209, -1));

        jLabel3.setText("Cantidad Producida: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 120, 27));
        getContentPane().add(txtCantProducida, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 156, -1));

        jLabel4.setText("Fecha Revisión: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 113, 27));
        getContentPane().add(txtFechaRev, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 170, -1));

        jLabel5.setText("Observasiones:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 113, 27));
        getContentPane().add(txtObservaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 180, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 33)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PRODUCCION");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fertilizacion64.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

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
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 130, 40));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 130, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/azul.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 450, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(txtCalidad.getText().isEmpty() || txtCantProducida.getText().isEmpty() || txtFechaRev.getDateFormatString().isEmpty() || txtObservaciones.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos!!!!");
        }else{
            Controlador.Fertilidad F = new Controlador.Fertilidad();
            Modelo.MetodosAnimal MA = new Modelo.MetodosAnimal();
            Modelo.MetodosFertilidad MF = new Modelo.MetodosFertilidad();
          
            F.setID_ANIMAL(MA.ConsultarID((String) ComboAnimales.getSelectedItem()));
            F.setCALIDAD(txtCalidad.getText());
            F.setCANTIDAD(txtCantProducida.getText());
            F.setOBSERVACIONES(txtObservaciones.getText());
                        try {
        Date date = txtFechaRev.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        F.setFECHA_REVISION(String.valueOf(sdf.format(date)));
        } catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Escoja un fecha Valida ", "Error..!!", JOptionPane.ERROR_MESSAGE);     
                }
                        
           if(MF.IngresoRegFertilidad(F)){
                JOptionPane.showMessageDialog(null, "Registro ingresado correctamente!!!!");
            }else{
                JOptionPane.showMessageDialog(null, "Sucedio un error al ingresar el registro!!!!");
            } 
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

            public void CargarAnimales(){
        Modelo.MetodosAnimal MA = new Modelo.MetodosAnimal();
        MA.CargarAnimales((DefaultComboBoxModel)ComboAnimales.getModel());
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Fertilidad F = new Fertilidad();
        F.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCalidadActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroFertilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroFertilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroFertilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroFertilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroFertilidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboAnimales;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCalidad;
    private javax.swing.JTextField txtCantProducida;
    public com.toedter.calendar.JDateChooser txtFechaRev;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
