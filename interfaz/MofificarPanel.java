/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Contabilidad.Beneficiario;
import Contabilidad.Cat1;
import Contabilidad.Contabilidad;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MARIAJOSE
 */
public class MofificarPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public MofificarPanel() {
        initComponents();
    }
    Cat1 cat1 = new Cat1();
    Contabilidad conta1 = new Contabilidad(cat1);
    public void leerBne() throws FileNotFoundException, IOException{
    
File beneficiarios = new File ("Beneficiarios/beneficiarios.txt");
         FileReader leeBene = new FileReader (beneficiarios);
      BufferedReader bc3 = new BufferedReader  (leeBene);
      String lineaBene;
       while ( (lineaBene = bc3.readLine()) != null){
           String divB[] = lineaBene.split(",");
           String nomB = divB[0];
           String cedBene = divB[1];
           String dirB = divB[2];
           String telB = divB[3];
           Beneficiario ben = new Beneficiario (nomB, cedBene, dirB, telB);
           conta1.addBen(ben);
          
       }
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(102, 153, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel1.setText("Modificar tercero");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 30, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MODIFICAR", "Modificar nombre", "Modificar cédula/NIT", "Modificardireccíón", "Modificar teléfono" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 218, -1, -1));

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(499, 218, 120, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Nueva información");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 190, -1, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 285, -1, -1));

        jButton2.setText("Modificar información");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 287, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Ingrese el nombre del tercero  a modificar");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 94, -1, -1));

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 117, 140, 35));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 660, 290));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            leerBne();
        } catch (IOException ex) {
            Logger.getLogger(MofificarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextField2.getText();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
String ite = (String)jComboBox1.getSelectedItem();
JOptionPane.showMessageDialog(null, ite);
if (ite.equals("Modificar nombre")){
    
} else if (ite.equals("Modificar cédula/NIT")){
    
} else if (ite.equals("Modificar dirección")){
    
} else if (ite.equals("Modificaar teléfono")){
    
} else {
    JOptionPane.showMessageDialog(null, "Seleccionar dato que desea modificar");
}
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}