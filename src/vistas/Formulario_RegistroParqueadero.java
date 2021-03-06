/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.bind.DatatypeConverter;
import modelo.Conectar;
import modelo.Parqueadero;
import modelo.Usuario;

/**
 *
 * @author Myrian Chica
 */
public class Formulario_RegistroParqueadero extends javax.swing.JFrame {
    
    Boolean nuevo = true;

    public Boolean getNuevo() {
        return nuevo;
    }

    public void setNuevo(Boolean nuevo) {
        this.nuevo = nuevo;
    }
    

    public JTextField getTf_p_direccion() {
        return tf_direccion;
    }

    public void setTf_p_direccion(JTextField tf_p_direccion) {
        this.tf_direccion = tf_p_direccion;
    }

    public JTextField getTf_p_email() {
        return tf_email;
    }

    public void setTf_p_email(JTextField tf_p_email) {
        this.tf_email = tf_p_email;
    }

    public JTextField getTf_p_nombre() {
        return tf_nombre;
    }

    public void setTf_p_nombre(JTextField tf_p_nombre) {
        this.tf_nombre = tf_p_nombre;
    }

    public JTextField getTf_p_telefono() {
        return tf_telefono;
    }

    public void setTf_p_telefono(JTextField tf_p_telefono) {
        this.tf_telefono = tf_p_telefono;
    }
    
    public void llenarFormParqueadero(){
        Parqueadero p = new Parqueadero();
        p = p.getParqueadero(p.GetIdParquedero());
        this.tf_nombre.setText(p.getNombre());
        this.tf_direccion.setText(p.getDireccion());
        this.tf_telefono.setText(String.valueOf(p.getTelefono()));
        this.tf_email.setText(p.getEmail());
        this.setNuevo(false);
        
    }

    /**
     * Creates new form ingreso_datos_parquedero
     */
    public Formulario_RegistroParqueadero() {
        initComponents();
        this.setTitle("Registro de Parqueadero");
        URL url=getClass().getResource("/ASSETS/bigIcon.png");
        ImageIcon ima=new ImageIcon(url);
        setIconImage(ima.getImage());
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation( tamañoPantalla.width - 420 ,tamañoPantalla.height-329);

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        tf_direccion = new javax.swing.JTextField();
        tf_telefono = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        btn_p_guardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Direccion:");

        jLabel3.setText("Telefono:");

        jLabel4.setText("Email:");

        tf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreActionPerformed(evt);
            }
        });

        tf_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_direccionActionPerformed(evt);
            }
        });

        tf_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_telefonoActionPerformed(evt);
            }
        });

        btn_p_guardar.setText("Guardar");
        btn_p_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_p_guardarActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                            .addComponent(tf_direccion)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_p_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(tf_email))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(tf_telefono)))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(tf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(tf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_p_guardar)
                        .addComponent(jButton1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombreActionPerformed

    private void tf_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_direccionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tf_telefono.setText("");
        tf_email.setText("");
        tf_nombre.setText("");
        tf_direccion.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

//    public void ConexionBD() {
//        Conectar con = new Conectar();
//        Connection reg = con.conexion();
//        String nombre, email, telefono, direccion;
//        String sql, sql_parking_id;
//
//        nombre = tf_p_nombre.getText();
//        email = tf_p_email.getText();
//        telefono = tf_p_telefono.getText();
//        direccion = tf_p_direccion.getText();
//        sql = "INSERT INTO `parquedero`( `nombre`, `direccion`, `telefono`, `email`) VALUES (?,?,?,?)";
//
//        try {
//            PreparedStatement pst = reg.prepareStatement(sql);
//            pst.setString(1, nombre);
//            pst.setString(2, direccion);
//            pst.setString(3, telefono);
//            pst.setString(4, email);
//            int n = pst.executeUpdate();
//            if (n > 0) {
//                JOptionPane.showMessageDialog(null, "Registrado con exito BITCH");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ingreso_datos_parquedero.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private void btn_p_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_p_guardarActionPerformed
        // TODO add your handling code here:

        
        Parqueadero parqueadero=new Parqueadero(tf_nombre.getText(), tf_direccion.getText(), Integer.parseInt(tf_telefono.getText()), tf_email.getText(), null, null, null, null);
        parqueadero.registrarParqueadero();
        int idparqueadero = parqueadero.GetIdParquedero();
//        System.out.println("el id del parking> "+idparqueadero); 
        Formulario_RegistroUsuarios formularioRegistroUsuarios = new Formulario_RegistroUsuarios();
        formularioRegistroUsuarios.recibirId(idparqueadero);
        //si lo que voy a guardar es de un usuario nuevo 
        if (this.nuevo == false) {
            
            formularioRegistroUsuarios.llenarFormUsuario();
            formularioRegistroUsuarios.setVisible(true);
        }
        else{
            formularioRegistroUsuarios.setNuevo(true);
            formularioRegistroUsuarios.setVisible(true);
        }
        
        dispose();
        
//            sql_parking_id="SELECT * FROM Parquedero";
//            PreparedStatement pst2= reg.prepareStatement(sql_parking_id);
//            Statement stmt= reg.createStatement();
//            ResultSet resultado=stmt.executeQuery(sql_parking_id);
//            
//            while(resultado.next()){
//                String id =resultado.getString("idParquedero");
//                
//                //System.out.println(id);
//            }

            //System.out.println(""+resultado);
        // ResultSet resultado= pst_p_id.executeQuery(sql_parking_id);
            //System.out.println(resultado);
           // System.out.println(tf_p_nombre.getText());
        //Formulario f=new Formulario();
        //f.setVisible(true);

    }//GEN-LAST:event_btn_p_guardarActionPerformed

    private void tf_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_telefonoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Formulario_Admin form_A = new Formulario_Admin();
        form_A.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Formulario_RegistroParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario_RegistroParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario_RegistroParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario_RegistroParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario_RegistroParqueadero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_p_guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tf_direccion;
    private javax.swing.JTextField tf_email;
    private javax.swing.JTextField tf_nombre;
    private javax.swing.JTextField tf_telefono;
    // End of variables declaration//GEN-END:variables
}
