
package service;

import database.Config;
import form.JTextFieldHintUI;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class Tamu extends javax.swing.JInternalFrame {
    private String hintCari;

    public Tamu() {
        hintCari = "Silahkan Masukan Data yang ingin dicari..";
        
        initComponents();
        setColor(btn_tamu);
        showHint();
        showDataTamu();
        setVisibleComponents(false);
    }
    
    private void setColor(JPanel panel) {
        panel.setBackground(new Color(179, 201, 201));
    }
    
    private void showHint() {
        tf_cariTamu.setUI(new JTextFieldHintUI(hintCari, Color.GRAY));
    }
    
    private void setVisibleComponents(Boolean b) {
        btn_hapus.setVisible(b);
        btn_update.setVisible(b);
        tv_rincianDataTamu.setVisible(b);
        tv_rincianIdTamu.setVisible(b);
        tv_rincianNama.setVisible(b);
        tv_rincianAlamat.setVisible(b);
        tv_rincianNoTelepon.setVisible(b);
        tf_rincianIdTamu.setVisible(b);
        tf_rincianNama.setVisible(b);
        tf_rincianAlamat.setVisible(b);
        tf_rincianNoTelepon.setVisible(b);
    }
    
    public void showDataTamu() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Tamu");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("No Telepon");
        
        int no=1;
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "CALL showDataTamu();";
            
            ResultSet res = state.executeQuery(sql);
            
                    
            while (res.next()) {
                
                model.addRow(new Object [] {
                    no++,
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
                tb_tamu.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
     }
    
    public void cariData() {
        DefaultTableModel model = new DefaultTableModel();
        String cari = tf_cariTamu.getText();
        model.addColumn("No");
        model.addColumn("ID Tamu");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("No Telepon");
        
        int lengthRow = model.getRowCount();
        for (int n=0; n<lengthRow; n++) {
            model.removeRow(n);
        }
        
        int no = 1;
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT * FROM tamu WHERE nama LIKE '%"+ tf_cariTamu.getText() +"%'";
            
            ResultSet res = state.executeQuery(sql);
                    
            while (res.next()) {
                model.addRow(new Object [] {
                    no++, 
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
                tb_tamu.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        } 
    }
    
    public void updateDataTamu() {
        try {
            String sql = "UPDATE tamu SET id_tamu='" + tf_rincianIdTamu.getText() + 
                    "',nama='" + tf_rincianNama.getText() + 
                    "',alamat='" + tf_rincianAlamat.getText() + 
                    "',no_tlp='" + tf_rincianNoTelepon.getText() + 
                    "' WHERE id_tamu='" + tf_rincianIdTamu.getText() + 
                    "'";
            Connection conn = (Connection)Config.configDB();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(this, "Edit Data Berhasil");
            showDataTamu();
            setVisibleComponents(false);
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_tamu = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_data_tamu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_tamu = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        tf_cariTamu = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        tv_rincianDataTamu = new javax.swing.JLabel();
        tv_rincianIdTamu = new javax.swing.JLabel();
        tf_rincianIdTamu = new javax.swing.JTextField();
        tv_rincianNama = new javax.swing.JLabel();
        tf_rincianNama = new javax.swing.JTextField();
        tv_rincianAlamat = new javax.swing.JLabel();
        tf_rincianAlamat = new javax.swing.JTextField();
        tv_rincianNoTelepon = new javax.swing.JLabel();
        tf_rincianNoTelepon = new javax.swing.JTextField();

        setBackground(new java.awt.Color(220, 228, 228));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_panel.setBackground(new java.awt.Color(192, 212, 212));

        jLabel1.setFont(new java.awt.Font("Quicksand SemiBold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tamu");

        jLabel2.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Interface Guidelanes");

        jLabel7.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(230, 247, 248));
        jLabel7.setText("Data ");

        btn_tamu.setBackground(new java.awt.Color(192, 212, 212));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/guest_white.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Quicksand SemiBold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data Tamu");

        javax.swing.GroupLayout btn_tamuLayout = new javax.swing.GroupLayout(btn_tamu);
        btn_tamu.setLayout(btn_tamuLayout);
        btn_tamuLayout.setHorizontalGroup(
            btn_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_tamuLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_tamuLayout.setVerticalGroup(
            btn_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_tamuLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(btn_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_tamu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(side_panelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7))
                    .addGroup(side_panelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(52, 52, 52)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_tamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(441, Short.MAX_VALUE))
        );

        getContentPane().add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 200, 670));

        panel_data_tamu.setBackground(new java.awt.Color(220, 228, 228));

        tb_tamu.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        tb_tamu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "ID Tamu", "Nama", "Alamat", "No Telepon"
            }
        ));
        tb_tamu.setGridColor(new java.awt.Color(255, 255, 255));
        tb_tamu.getTableHeader().setReorderingAllowed(false);
        tb_tamu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_tamuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_tamu);

        tf_cariTamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_cariTamu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_cariTamuKeyPressed(evt);
            }
        });

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(220, 228, 228));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Quicksand SemiBold", 0, 36)); // NOI18N
        jLabel15.setText("Data Tamu");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Quicksand Light", 1, 18)); // NOI18N
        jLabel16.setText("Interface Guidlanes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(252, 252, 252))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(237, 237, 237))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel18.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        jLabel18.setText("Ketik Nama untuk Mencari Data Tamu:");

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        tv_rincianDataTamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianDataTamu.setText("Rincian Data Tamu");

        tv_rincianIdTamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianIdTamu.setText("ID Tamu");

        tf_rincianIdTamu.setBackground(new java.awt.Color(234, 246, 248));
        tf_rincianIdTamu.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        tv_rincianNama.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianNama.setText("Nama");

        tf_rincianNama.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        tv_rincianAlamat.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianAlamat.setText("Alamat");

        tf_rincianAlamat.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        tv_rincianNoTelepon.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianNoTelepon.setText("No Telepon");

        tf_rincianNoTelepon.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_rincianNoTelepon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_rincianNoTeleponKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panel_data_tamuLayout = new javax.swing.GroupLayout(panel_data_tamu);
        panel_data_tamu.setLayout(panel_data_tamuLayout);
        panel_data_tamuLayout.setHorizontalGroup(
            panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_data_tamuLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addComponent(tf_cariTamu, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_cari)))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(panel_data_tamuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panel_data_tamuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_rincianDataTamu)
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tv_rincianNama)
                            .addComponent(tv_rincianIdTamu)
                            .addComponent(tv_rincianAlamat)
                            .addComponent(tv_rincianNoTelepon))
                        .addGap(15, 15, 15)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_rincianIdTamu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rincianNama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rincianAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_rincianNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hapus)
                .addGap(57, 57, 57))
        );
        panel_data_tamuLayout.setVerticalGroup(
            panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_data_tamuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cariTamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapus)
                            .addComponent(btn_update)))
                    .addGroup(panel_data_tamuLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(tv_rincianDataTamu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tv_rincianIdTamu)
                            .addComponent(tf_rincianIdTamu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tv_rincianNama)
                            .addComponent(tf_rincianNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tv_rincianAlamat)
                            .addComponent(tf_rincianAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_data_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tv_rincianNoTelepon)
                            .addComponent(tf_rincianNoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        getContentPane().add(panel_data_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_tamuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tamuMouseClicked
        // TODO add your handling code here:
        setVisibleComponents(true);
        int baris = tb_tamu.rowAtPoint(evt.getPoint());

        String id = tb_tamu.getValueAt(baris, 1).toString();
        tf_rincianIdTamu.setText(id);
        tf_rincianIdTamu.setEditable(false);

        String nama = tb_tamu.getValueAt(baris, 2).toString();
        tf_rincianNama.setText(nama);

        String alamat = tb_tamu.getValueAt(baris, 3).toString();
        tf_rincianAlamat.setText(alamat);
        
        String noTelepon = tb_tamu.getValueAt(baris, 4).toString();
        tf_rincianNoTelepon.setText(noTelepon);
        
      
    }//GEN-LAST:event_tb_tamuMouseClicked

    private void tf_cariTamuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariTamuKeyPressed
        // TODO add your handling code here:
       cariData();
    }//GEN-LAST:event_tf_cariTamuKeyPressed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        cariData();
        if (tf_cariTamu.getText().trim().isEmpty()) {
            showDataTamu();
        }
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus Data?");
        if (opsi == JOptionPane.YES_OPTION)  {
            try {
                String sql = "DELETE FROM tamu WHERE id_tamu='"+ tf_rincianIdTamu.getText() +"'";
                Connection conn = (Connection)Config.configDB();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(this, "Hapus Data Berhasil");
                showDataTamu();
                setVisibleComponents(false);
            }
            catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak jadi dihapus");
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        if (tf_rincianNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data Nama Tidak Boleh Kosong");
        } else
            if (tf_rincianAlamat.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Alamat Tidak Boleh Kosong");
            } else
                if (tf_rincianNoTelepon.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Data No Telepon Tidak Boleh Kosong");
                } else {
                    updateDataTamu();
                }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tf_rincianNoTeleponKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rincianNoTeleponKeyPressed
        // TODO add your handling code here:
        String phoneNumber = tf_rincianNoTelepon.getText();
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            tf_rincianNoTelepon.setEditable(false);
        } else {
            tf_rincianNoTelepon.setEditable(true);
        }
        
        if (phoneNumber.length() == 12 || phoneNumber.length() == 11) {
            tf_rincianNoTelepon.setBackground(Color.GREEN);
        } else {
            tf_rincianNoTelepon.setBackground(Color.RED);
        }
    }//GEN-LAST:event_tf_rincianNoTeleponKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JPanel btn_tamu;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_data_tamu;
    private javax.swing.JPanel side_panel;
    private javax.swing.JTable tb_tamu;
    private javax.swing.JTextField tf_cariTamu;
    private javax.swing.JTextField tf_rincianAlamat;
    private javax.swing.JTextField tf_rincianIdTamu;
    private javax.swing.JTextField tf_rincianNama;
    private javax.swing.JTextField tf_rincianNoTelepon;
    private javax.swing.JLabel tv_rincianAlamat;
    private javax.swing.JLabel tv_rincianDataTamu;
    private javax.swing.JLabel tv_rincianIdTamu;
    private javax.swing.JLabel tv_rincianNama;
    private javax.swing.JLabel tv_rincianNoTelepon;
    // End of variables declaration//GEN-END:variables
}
