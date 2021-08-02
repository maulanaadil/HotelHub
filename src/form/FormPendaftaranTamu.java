
package form;

import database.Config;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class FormPendaftaranTamu extends javax.swing.JInternalFrame {
    private String hintIdTamu;
    private String hintNama;
    private String hintAlamat;
    private String hintNoTelepon;
   
    public FormPendaftaranTamu() {
        hintIdTamu = "Masukan ID Tamu..";
        hintNama = "Masukan Nama..";
        hintAlamat = "Masukan Alamat..";
        hintNoTelepon = "Masukan Alamat..";
        
        
        initComponents();
        showHint();
    }    
    
    public void addDataTamu() {
        try {
            Connection conn = (Connection) Config.configDB();
            
            Statement state = conn.createStatement();
            
            String sql = "INSERT INTO tamu VALUES('"+ tf_idTamu.getText() +"' , '"+ tf_nama.getText() +"', '" + tf_alamat.getText() + "', '"+ tf_noTelepon.getText() +"')";
            state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Success Added!");
            clearComponents();
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    private void clearComponents() {
        tf_idTamu.setText("");
        tf_nama.setText("");
        tf_alamat.setText("");
        tf_noTelepon.setText("");
        tf_noTelepon.setBackground(Color.WHITE);
    }
    
    private void showHint() {     
        
        tf_idTamu.setUI(new JTextFieldHintUI(hintIdTamu, Color.GRAY));
        tf_nama.setUI(new JTextFieldHintUI(hintNama, Color.GRAY));
        tf_alamat.setUI(new JTextFieldHintUI(hintAlamat, Color.GRAY));
        tf_noTelepon.setUI(new JTextFieldHintUI(hintNoTelepon, Color.GRAY));
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_idTamu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_alamat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_noTelepon = new javax.swing.JTextField();
        btn_reset = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();

        setBackground(new java.awt.Color(220, 228, 228));

        jPanel1.setBackground(new java.awt.Color(192, 212, 212));

        jLabel1.setFont(new java.awt.Font("Quicksand SemiBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Pendaftaran Tamu");

        jLabel2.setFont(new java.awt.Font("Quicksand Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(246, 249, 250));
        jLabel2.setText("Interface Guidelanes");

        jLabel3.setFont(new java.awt.Font("Quicksand", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("V1.0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2))
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel4.setText("ID Tamu");

        tf_idTamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_idTamu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_idTamuKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel5.setText("Nama");

        tf_nama.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel6.setText("Alamat");

        tf_alamat.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel7.setText("No Telepon");

        tf_noTelepon.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        tf_noTelepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_noTeleponKeyTyped(evt);
            }
        });

        btn_reset.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_submit.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tf_idTamu, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_alamat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_noTelepon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_reset)
                .addGap(18, 18, 18)
                .addComponent(btn_submit)
                .addGap(184, 184, 184))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_idTamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_noTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reset)
                    .addComponent(btn_submit))
                .addGap(0, 181, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_noTeleponKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_noTeleponKeyTyped
        // TODO add your handling code here:
        String phoneNumber = tf_noTelepon.getText();
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            tf_noTelepon.setEditable(false);
        } else {
            tf_noTelepon.setEditable(true);
        }
        
        if (phoneNumber.length() == 12 || phoneNumber.length() == 11) {
            tf_noTelepon.setBackground(Color.GREEN);
        } else {
            tf_noTelepon.setBackground(Color.RED);
        }
    }//GEN-LAST:event_tf_noTeleponKeyTyped

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        clearComponents();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        if (tf_idTamu.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data ID Tamu Tidak Boleh Kosong");
        } else 
            if (tf_nama.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Nama Tidak Boleh Kosong");
            } else
                if (tf_alamat.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data Alamat Tidak Boleh Kosong");
                } else 
                    if (tf_noTelepon.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Data No Telepon Tidak Boleh Kosong");
                    } else {
                        addDataTamu();
                    }   
    }//GEN-LAST:event_btn_submitActionPerformed

    private void tf_idTamuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_idTamuKeyPressed
        // TODO add your handling code here:
        String idTamu = tf_idTamu.getText();
        
        int length = idTamu.length();
        if ( length < 4 ) {
            tf_idTamu.setEditable(true);
        } else 
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ) {
                tf_idTamu.setEditable(true);
            } 
        else {
            tf_idTamu.setEditable(false);
        }
    }//GEN-LAST:event_tf_idTamuKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tf_alamat;
    private javax.swing.JTextField tf_idTamu;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_noTelepon;
    // End of variables declaration//GEN-END:variables
}
