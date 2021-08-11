
package form;

import database.Config;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class FormReservasi extends javax.swing.JInternalFrame {
    private String hintTamu;

   
    public FormReservasi() {
        hintTamu = "Masukan ID Tamu..";
        
        initComponents();
        showNamaTamu();
        showIDKamar();
        disableTextField();
        showHint();
    }
    
    private void showHint() {
        tf_tamu.setUI(new JTextFieldHintUI(hintTamu, Color.GRAY));
    }
    
    private void disableTextField() {
        tf_tamu.setEditable(false);
        tf_tamu.setBackground(new Color(234,246,248,255));
    }
    
    private void clearComponents() {
        cb_nama.setSelectedIndex(0);
        tf_tamu.setText("");
        date_checkIn.setDate(null);
        date_checkOut.setDate(null);
        cb_idKamar.setSelectedIndex(0);
    }
    
    public void showNamaTamu() {
        try {
            Connection conn = (Connection) Config.configDB();

            Statement state = conn.createStatement();
            
            String sql = "CALL showNamaTamu()";
            
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()) {
                Object[] ob = new Object[1];
                ob[0] = rs.getString("nama");
                cb_nama.addItem((String) ob[0]);
            }
            rs.close();
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void showDataTamu() {
        try {
            Connection conn = (Connection) Config.configDB();
            
            Statement state = conn.createStatement();
            String sql2 = "SELECT * FROM tamu WHERE nama='"+cb_nama.getSelectedItem()+"'";
            String sql = "CALL searchNamaTamu('"+ cb_nama.getSelectedItem() +"')";
            
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()) {
                Object[] ob = new Object[1];
                ob[0] = rs.getString("id_tamu");
                
                tf_tamu.setText((String) ob[0]);
            }
            rs.close();
            state.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void showIDKamar() {
         try {
            Connection conn = (Connection) Config.configDB();

            Statement state = conn.createStatement();
            
            String sql = "CALL showIDKamar()";
            
            ResultSet rs = state.executeQuery(sql);
            
            while(rs.next()) {
                Object[] ob = new Object[1];
                ob[0] = rs.getString("id_room");
                cb_idKamar.addItem((String) ob[0]);
            }
            rs.close();
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void updateStatusKamar() {
        try {
            Connection conn = (Connection) Config.configDB();
            
            Statement state = conn.createStatement();
            String sql = "UPDATE room SET status = 'terisi' WHERE id_room='"+cb_idKamar.getSelectedItem()+"'";
            
            state.executeUpdate(sql);
       
            state.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void addDataReservasi() {
        try {
            Connection conn = (Connection) Config.configDB();
            
            Statement state = conn.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String checkIn = sdf.format(date_checkIn.getDate());
            String checkOut = sdf.format(date_checkOut.getDate());
            
            String sql = "INSERT INTO reservasi(id_tamu,  id_room, id_pegawai, check_in, check_out) VALUES('"+tf_tamu.getText() +"' , '"+ cb_idKamar.getSelectedItem() +"', 'P001', '" + checkIn + "', '"+ checkOut +"')";
            String sql2 = "UPDATE room SET id_tamu ='"+ tf_tamu.getText() +"' WHERE id_room ='"+ cb_idKamar.getSelectedItem() +"'";
            state.executeUpdate(sql);
            state.executeUpdate(sql2);
            updateStatusKamar();
            JOptionPane.showMessageDialog(null, "Data Success Added!");
            clearComponents();
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_nama = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_idKamar = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        date_checkIn = new com.toedter.calendar.JDateChooser();
        date_checkOut = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        tf_tamu = new javax.swing.JTextField();
        btn_reset = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();

        setBackground(new java.awt.Color(220, 228, 228));

        jPanel1.setBackground(new java.awt.Color(192, 212, 212));

        jLabel1.setFont(new java.awt.Font("Quicksand SemiBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Reservasi");

        jLabel2.setFont(new java.awt.Font("Quicksand Light", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(246, 249, 250));
        jLabel2.setText("Interface Guidlanes");

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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel4.setText("Atas Nama");

        cb_nama.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        cb_nama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Nama Tamu" }));
        cb_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_namaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel5.setText("Tanggal Check In");

        jLabel6.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel6.setText("ID Kamar");

        cb_idKamar.setFont(new java.awt.Font("Quicksand Medium", 0, 14)); // NOI18N
        cb_idKamar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih ID Kamar" }));

        jLabel7.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel7.setText("Tanggal Check Out");

        date_checkIn.setDateFormatString("yyyy-MM-dd");
        date_checkIn.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        date_checkOut.setDateFormatString("yyyy-MM-dd");
        date_checkOut.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel8.setText("ID Tamu");

        tf_tamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_reset)
                        .addGap(12, 12, 12)
                        .addComponent(btn_submit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_tamu)
                            .addComponent(cb_nama, 0, 406, Short.MAX_VALUE)
                            .addComponent(date_checkIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date_checkOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_idKamar, 0, 406, Short.MAX_VALUE))))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_tamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(date_checkIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(date_checkOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_idKamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_namaActionPerformed
        // TODO add your handling code here:
        showDataTamu();
        if (cb_nama.getSelectedIndex() == 0) {
            tf_tamu.setText("");
        }
    }//GEN-LAST:event_cb_namaActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        clearComponents();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        addDataReservasi();
    }//GEN-LAST:event_btn_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox<String> cb_idKamar;
    private javax.swing.JComboBox<String> cb_nama;
    private com.toedter.calendar.JDateChooser date_checkIn;
    private com.toedter.calendar.JDateChooser date_checkOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tf_tamu;
    // End of variables declaration//GEN-END:variables
}
