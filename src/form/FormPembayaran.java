
package form;

import database.Config;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;


public class FormPembayaran extends javax.swing.JInternalFrame {
    private String rupiah;
    private String totalHarga;
    private String seperator;

    
    public FormPembayaran() {
        rupiah = "Rp. 0.00";
        totalHarga = "0.00";
        seperator = "-";
        initComponents();
        showNamaTamu();
        disableTextField();
    }
    
    private void clearComponents() {
            cb_nama.setSelectedIndex(0);
            tf_idTamu.setText("");
            tv_tipeKamar.setText(seperator);
            tv_harga.setText(rupiah);
            tv_pajak.setText(rupiah);
            tv_totalHarga.setText(totalHarga);
    }
    
    public void disableTextField() {
        tf_idTamu.setEditable(false);
        tf_idTamu.setBackground(new Color(234,246,248,255));
    }
    
    public void showNamaTamu() {
        try {
            Connection conn = (Connection) Config.configDB();

            Statement state = conn.createStatement();
            
            String sql = "SELECT nama FROM tamu ORDER BY id_tamu ASC";
            
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
            String sql = "SELECT * FROM tamu WHERE nama='"+cb_nama.getSelectedItem()+"'";
            
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()) {
                Object[] ob = new Object[5];
                ob[0] = rs.getString("id_tamu");
                
                tf_idTamu.setText((String) ob[0]);
            }
            showDataRincian();
            rs.close();
            state.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void showDataRincian() {
        try {
            Connection conn = (Connection) Config.configDB();
            
            Statement state = conn.createStatement();
            String sql = "SELECT * FROM room WHERE id_tamu='"+tf_idTamu.getText()+"'";
            
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()) {
                Object[] ob = new Object[5];
                ob[1] = rs.getString("tipe_room");
                ob[2] = rs.getString("harga");
                
                tv_tipeKamar.setText((String) ob[1]);
                tv_harga.setText("Rp. " + (String) ob[2]);
                
                Double pajak = Double.parseDouble((String) ob[2]) * 0.01;
                tv_pajak.setText("Rp. " + String.valueOf(pajak));
                
                Double temp = pajak + Double.parseDouble((String) ob[2]);
                int totalHarga = (int)Math.round(temp);
                tv_totalHarga.setText(String.valueOf(totalHarga));
            }
            rs.close();
            state.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void addDataPembayaran() {
        try {
            Connection conn = (Connection) Config.configDB();
            
            Statement state = conn.createStatement();
            Calendar cal = Calendar.getInstance(); 
            cal.getTime(); 
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
            String tanggal = sdf.format(cal.getTime());
            
            String sql = "INSERT INTO pembayaran(total_harga,  tanggal, id_tamu) VALUES('"+tv_totalHarga.getText() +"' , '"+ tanggal +"', '" + tf_idTamu.getText() +"')";
            state.executeUpdate(sql);
            
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
        tf_idTamu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tv_tipeKamar = new javax.swing.JLabel();
        tv_harga = new javax.swing.JLabel();
        tv_totalHarga = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tv_pajak = new javax.swing.JLabel();
        btn_bayar = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        tv_rp = new javax.swing.JLabel();

        setBackground(new java.awt.Color(220, 228, 228));

        jPanel1.setBackground(new java.awt.Color(192, 212, 212));

        jLabel1.setFont(new java.awt.Font("Quicksand SemiBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Pembayaran");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(19, Short.MAX_VALUE))
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
        jLabel5.setText("ID Tamu");

        tf_idTamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel6.setText("Rincian Reservasi");

        jLabel7.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel7.setText("Tipe Kamar");

        jLabel8.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel8.setText("Harga");

        jLabel9.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel9.setText("Pajak");

        tv_tipeKamar.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        tv_tipeKamar.setText("-");

        tv_harga.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        tv_harga.setText("Rp. 0.00");

        tv_totalHarga.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        tv_totalHarga.setText("0.00");

        jLabel10.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel10.setText("Total Harga");

        tv_pajak.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        tv_pajak.setText("Rp. 0.00");

        btn_bayar.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        btn_bayar.setText("Bayar");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        btn_cancel.setText("Batal");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        tv_rp.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        tv_rp.setText("Rp.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cb_nama, 0, 350, Short.MAX_VALUE)
                        .addComponent(tf_idTamu))
                    .addComponent(tv_tipeKamar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tv_harga, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tv_pajak, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(203, 203, 203))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(345, 345, 345)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_cancel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_bayar)
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tv_rp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tv_totalHarga)
                                .addGap(23, 23, 23)))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_idTamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tv_tipeKamar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tv_harga))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tv_pajak))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tv_totalHarga)
                    .addComponent(tv_rp))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_bayar)
                    .addComponent(btn_cancel))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_namaActionPerformed
        // TODO add your handling code here:
        showDataTamu();
        if (cb_nama.getSelectedIndex() == 0) {
            clearComponents();
        }
    }//GEN-LAST:event_cb_namaActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        clearComponents();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        // TODO add your handling code here:
        addDataPembayaran();
    }//GEN-LAST:event_btn_bayarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JComboBox<String> cb_nama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tf_idTamu;
    private javax.swing.JLabel tv_harga;
    private javax.swing.JLabel tv_pajak;
    private javax.swing.JLabel tv_rp;
    private javax.swing.JLabel tv_tipeKamar;
    private javax.swing.JLabel tv_totalHarga;
    // End of variables declaration//GEN-END:variables
}
