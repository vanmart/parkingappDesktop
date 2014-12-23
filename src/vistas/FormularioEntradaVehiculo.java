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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import modelo.Conectar;
import modelo.Parqueadero;
import modelo.Usuario;

/**
 *
 * @author JP
 */
public class FormularioEntradaVehiculo extends javax.swing.JFrame {
Date fecha_Entrada;
    Date fecha_Salida;
    Usuario usuario;
    /**
     * Creates new form FormularioEntradaVehiculo
     */
    public FormularioEntradaVehiculo() {
        initComponents();
        this.setTitle("Registro de entrada de vehiculo");
        URL url=getClass().getResource("/ASSETS/bigIcon.png");
        ImageIcon ima=new ImageIcon(url);
        setIconImage(ima.getImage());
        java.util.Date fecha_entrada =new java.util.Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MMM-YYYY");
        SimpleDateFormat formatoHora = new SimpleDateFormat("h:mm a");
        fecha_Entrada= new Date(fecha_entrada.getTime());
        tf_hora.setText(formatoHora.format(fecha_Entrada));
        tf_fecha.setText(formatoFecha.format(fecha_Entrada));
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation( tamañoPantalla.width - 472 ,tamañoPantalla.height-259);
        consultaTipoVehiculos();
    }
    public void modificarLabels(Usuario user)
    {
        Parqueadero par = new Parqueadero();
        par = par.getParqueadero(par.GetIdParquedero());
        jLbl_nombreParqueadero.setText(par.getNombre());
        jLbl_nombreUsuario.setText(user.getNombre());
        // jl_nombreParqueadero.setText(par.getNombre());
       // jl_nombreUsuario.setText(user.getNombre());
    }
    
public void consultaTipoVehiculos()
{
     Conectar con = new Conectar();
     try{
            Connection reg = con.conexion();
            Statement st = reg.createStatement();
            //ResultSet rs = st.executeQuery("select * from usuario where email like .com");
            ResultSet rs = st.executeQuery("select * from tipo_vehiculo ");
            DefaultComboBoxModel cmd=new DefaultComboBoxModel();
            while (rs.next()) 
            {
                //cmd.addElement("Seleccione");
                cmd.addElement(rs.getString("nombre"));
                cB_TV.setModel(cmd);
                
            }
            //cmd.addElement("Seleccione");
             rs.close();
            st.close();
            reg.close();
     }catch(Exception e) {
            e.printStackTrace();
        }
}

  public void recibirUsuario(Usuario admin){
        this.usuario=admin;
        System.out.println(admin.getNombre());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_fecha = new javax.swing.JTextField();
        tf_hora = new javax.swing.JTextField();
        tf_placa = new javax.swing.JTextField();
        Jlabel_Placa = new javax.swing.JLabel();
        Jlabel_fecha = new javax.swing.JLabel();
        cB_TV = new javax.swing.JComboBox();
        cB_TC = new javax.swing.JComboBox();
        Jlabel_Hora = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLbl_nombreParqueadero = new javax.swing.JLabel();
        jLbl_nombreUsuario = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tf_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_fechaActionPerformed(evt);
            }
        });

        tf_hora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_horaActionPerformed(evt);
            }
        });

        tf_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_placaActionPerformed(evt);
            }
        });

        Jlabel_Placa.setText("Placa:");

        Jlabel_fecha.setText("Fecha:");

        cB_TV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo Vehiculo" }));
        cB_TV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cB_TVActionPerformed(evt);
            }
        });

        cB_TC.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de Cobro", "hora", "dia", "semana", "quincenal", "mes", "anual" }));

        Jlabel_Hora.setText("Hora:");

        jButton1.setText("Guardar ticket");

        jLbl_nombreParqueadero.setText("Nombre Parqueadero");

        jLbl_nombreUsuario.setText("Nombre usuario");

        jButton2.setText("Cerrar");
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
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jlabel_Placa)
                    .addComponent(Jlabel_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cB_TV, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cB_TC, 0, 103, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tf_fecha)
                                .addGap(18, 18, 18)
                                .addComponent(Jlabel_Hora)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_hora, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLbl_nombreUsuario))
                    .addComponent(jLbl_nombreParqueadero))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLbl_nombreParqueadero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLbl_nombreUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jlabel_Placa)
                    .addComponent(cB_TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cB_TC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jlabel_Hora)
                    .addComponent(tf_hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jlabel_fecha)
                    .addComponent(tf_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_horaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_horaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_horaActionPerformed

    private void cB_TVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cB_TVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cB_TVActionPerformed

    private void tf_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_placaActionPerformed

    private void tf_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_fechaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
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
            java.util.logging.Logger.getLogger(FormularioEntradaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioEntradaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioEntradaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioEntradaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioEntradaVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jlabel_Hora;
    private javax.swing.JLabel Jlabel_Placa;
    private javax.swing.JLabel Jlabel_fecha;
    private javax.swing.JComboBox cB_TC;
    private javax.swing.JComboBox cB_TV;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLbl_nombreParqueadero;
    private javax.swing.JLabel jLbl_nombreUsuario;
    private javax.swing.JTextField tf_fecha;
    private javax.swing.JTextField tf_hora;
    private javax.swing.JTextField tf_placa;
    // End of variables declaration//GEN-END:variables
}
