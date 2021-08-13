
package service;

import database.Config;
import form.JTextFieldHintUI;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Ruangan extends javax.swing.JInternalFrame {
    private String hintIdRuangan;
    private String hintHarga;
    private String hintCari;
    
    public Ruangan() {
        hintIdRuangan = "Masukan ID Ruangan..";
        hintHarga = "Masukan Harga..";
        hintCari = "Silahkan Masukan Data yang ingin dicari..";        
        
        initComponents();
        showHint();
        showDataRuangan();
        panel_data_ruangan.setVisible(true);
        panel_form_ruangan.setVisible(false);
        setVisibleComponents(false);
    }
    
    private void setColor(JPanel panel) {
        panel.setBackground(new Color(179, 201, 201));
    }
    
    private void resetColor(JPanel panel) {
        panel.setBackground(new Color(192,212,212));
    }
    
    private void showHint() {
        tf_idRuangan.setUI(new JTextFieldHintUI(hintIdRuangan, Color.GRAY));
        tf_harga.setUI(new JTextFieldHintUI(hintHarga, Color.GRAY));
        tf_cariRuangan.setUI(new JTextFieldHintUI(hintCari, Color.GRAY));
    }
    
    private void setVisibleComponents(Boolean b) {
        tf_rincianIdRuangan.setVisible(b);
        tf_rincianHarga.setVisible(b);
        cb_rincianTipeRuangan.setVisible(b);
        cb_rincianStatus.setVisible(b);
        tv_rincianDataRuangan.setVisible(b);
        tv_rincianHarga.setVisible(b);
        tv_rincianIdRuangan.setVisible(b);
        tv_rincianJk.setVisible(b);
        tv_rincianStatus.setVisible(b);
        btn_hapus.setVisible(b);
        btn_update.setVisible(b);
    }
    
    private void clearComponents() {
        tf_idRuangan.setText("");
        tf_harga.setText("");
        cb_statusRuangan.setSelectedIndex(0);
        cb_tipeRuangan.setSelectedIndex(0);
    }
    
    public void addDataRuangan() {
        String tipeRuangan = null;
        String status = null;
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            
            String sql = "INSERT INTO room(id_room, harga, tipe_room, status) VALUES('"+ tf_idRuangan.getText()+"', '"+ 
                    tf_harga.getText() +"', '"+ cb_tipeRuangan.getSelectedIndex()+"', '" + cb_statusRuangan.getSelectedIndex()+"')";
            state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Success Added");
            clearComponents();
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e.getMessage());
        }
    }
    
    public void showDataRuangan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Ruangan");
        model.addColumn("Harga");
        model.addColumn("Tipe Ruangan");
        model.addColumn("Status");
        
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT * FROM room ORDER BY id_room ASC";
            
            ResultSet res = state.executeQuery(sql);
            
                    
            while (res.next()) {
                
                model.addRow(new Object [] {
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
                tb_ruangan.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void cariData() {
        DefaultTableModel model = new DefaultTableModel();
        String cari = tf_cariRuangan.getText();
        
        model.addColumn("ID Ruangan");
        model.addColumn("Harga");
        model.addColumn("Tipe Ruangan");
        model.addColumn("Status");
        
        int lengthRow = model.getRowCount();
        for (int n=0; n<lengthRow; n++) {
            model.removeRow(n);
        }
        
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT * FROM room WHERE tipe_room LIKE'%"+ tf_cariRuangan.getText() +"%'";
            
            ResultSet res = state.executeQuery(sql);    
            while (res.next()) {
                model.addRow(new Object [] {
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
                tb_ruangan.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        } 
    }
    
    public void updateDataRuangan() {
        try {
            String sql = "UPDATE room SET id_room='" + tf_rincianIdRuangan.getText() + 
                    "',harga='" + tf_rincianHarga.getText() + 
                    "',tipe_room='" + cb_rincianTipeRuangan.getSelectedItem() + 
                    "',status='" + cb_rincianStatus.getSelectedItem()+ 
                    "' WHERE id_room='" + tf_rincianIdRuangan.getText() + 
                    "'";
            Connection conn = (Connection)Config.configDB();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(this, "Edit Data Berhasil...");
            showDataRuangan();
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
        jLabel4 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_ruangan = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_data_ruangan = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ruangan = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        tf_cariRuangan = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tv_rincianDataRuangan = new javax.swing.JLabel();
        tv_rincianIdRuangan = new javax.swing.JLabel();
        tv_rincianHarga = new javax.swing.JLabel();
        tv_rincianJk = new javax.swing.JLabel();
        tv_rincianStatus = new javax.swing.JLabel();
        tf_rincianHarga = new javax.swing.JTextField();
        tf_rincianIdRuangan = new javax.swing.JTextField();
        cb_rincianTipeRuangan = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();
        cb_rincianStatus = new javax.swing.JComboBox<>();
        panel_form_ruangan = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tf_idRuangan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_harga = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cb_statusRuangan = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cb_tipeRuangan = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(220, 228, 228));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_panel.setBackground(new java.awt.Color(192, 212, 212));

        jLabel1.setFont(new java.awt.Font("Quicksand SemiBold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ruangan");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Interface Guidelanes");

        jLabel4.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(230, 247, 248));
        jLabel4.setText("Form ");

        btn_tambah.setBackground(new java.awt.Color(192, 212, 212));
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_tambahMousePressed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_white.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Quicksand SemiBold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tambah Ruangan");

        javax.swing.GroupLayout btn_tambahLayout = new javax.swing.GroupLayout(btn_tambah);
        btn_tambah.setLayout(btn_tambahLayout);
        btn_tambahLayout.setHorizontalGroup(
            btn_tambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_tambahLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        btn_tambahLayout.setVerticalGroup(
            btn_tambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_tambahLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(btn_tambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Quicksand", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(230, 247, 248));
        jLabel7.setText("Data ");

        btn_ruangan.setBackground(new java.awt.Color(192, 212, 212));
        btn_ruangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ruanganMousePressed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/king_bed_white.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Quicksand SemiBold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data Ruangan");

        javax.swing.GroupLayout btn_ruanganLayout = new javax.swing.GroupLayout(btn_ruangan);
        btn_ruangan.setLayout(btn_ruanganLayout);
        btn_ruanganLayout.setHorizontalGroup(
            btn_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ruanganLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_ruanganLayout.setVerticalGroup(
            btn_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_ruanganLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(btn_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_tambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_ruangan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        side_panelLayout.setVerticalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_panelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ruangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        getContentPane().add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 200, 600));

        panel_data_ruangan.setBackground(new java.awt.Color(220, 228, 228));

        tb_ruangan.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        tb_ruangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Ruangan", "Harga", "Tipe Ruangan", "Status"
            }
        ));
        tb_ruangan.setGridColor(new java.awt.Color(255, 255, 255));
        tb_ruangan.getTableHeader().setReorderingAllowed(false);
        tb_ruangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ruanganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ruangan);

        tf_cariRuangan.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_cariRuangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_cariRuanganKeyPressed(evt);
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
        jLabel15.setText("Data Ruangan");

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Quicksand Light", 1, 18)); // NOI18N
        jLabel16.setText("Interface Guidlanes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(252, 252, 252))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        jLabel18.setText("Ketik Tipe Ruangan untuk Mencari Data Ruangan:");

        tv_rincianDataRuangan.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianDataRuangan.setText("Rincian Data Ruangan");

        tv_rincianIdRuangan.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianIdRuangan.setText("ID Ruangan");

        tv_rincianHarga.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianHarga.setText("Harga");

        tv_rincianJk.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianJk.setText("TIpe Ruangan");

        tv_rincianStatus.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianStatus.setText("Status");

        tf_rincianHarga.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_rincianHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_rincianHargaKeyPressed(evt);
            }
        });

        tf_rincianIdRuangan.setBackground(new java.awt.Color(234, 246, 248));
        tf_rincianIdRuangan.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        cb_rincianTipeRuangan.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        cb_rincianTipeRuangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "standard", "superior", "deluxe" }));

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        cb_rincianStatus.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        cb_rincianStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kosong", "terisi" }));

        javax.swing.GroupLayout panel_data_ruanganLayout = new javax.swing.GroupLayout(panel_data_ruangan);
        panel_data_ruangan.setLayout(panel_data_ruanganLayout);
        panel_data_ruanganLayout.setHorizontalGroup(
            panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_data_ruanganLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hapus)
                .addGap(57, 57, 57))
            .addGroup(panel_data_ruanganLayout.createSequentialGroup()
                .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_data_ruanganLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(panel_data_ruanganLayout.createSequentialGroup()
                                .addComponent(tf_cariRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_cari))))
                    .addGroup(panel_data_ruanganLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tv_rincianDataRuangan)
                            .addGroup(panel_data_ruanganLayout.createSequentialGroup()
                                .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tv_rincianHarga)
                                    .addComponent(tv_rincianIdRuangan)
                                    .addComponent(tv_rincianJk)
                                    .addComponent(tv_rincianStatus))
                                .addGap(29, 29, 29)
                                .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_rincianIdRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_rincianHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_rincianTipeRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_rincianStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(panel_data_ruanganLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panel_data_ruanganLayout.setVerticalGroup(
            panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_data_ruanganLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cariRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hapus)
                    .addComponent(btn_update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tv_rincianDataRuangan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_rincianIdRuangan)
                    .addComponent(tf_rincianIdRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_rincianHarga)
                    .addComponent(tf_rincianHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_rincianJk)
                    .addComponent(cb_rincianTipeRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_ruanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tv_rincianStatus)
                    .addComponent(cb_rincianStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(panel_data_ruangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, 600));

        panel_form_ruangan.setBackground(new java.awt.Color(220, 228, 228));
        panel_form_ruangan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel10.setText("ID Ruangan");
        panel_form_ruangan.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        tf_idRuangan.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_idRuangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_idRuanganKeyPressed(evt);
            }
        });
        panel_form_ruangan.add(tf_idRuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 350, -1));

        jLabel11.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel11.setText("Tipe Ruangan");
        panel_form_ruangan.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        tf_harga.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_harga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_hargaKeyTyped(evt);
            }
        });
        panel_form_ruangan.add(tf_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 350, -1));

        jLabel12.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel12.setText("Harga");
        panel_form_ruangan.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        cb_statusRuangan.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        cb_statusRuangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Status Ruangan", "kosong", "terisi" }));
        panel_form_ruangan.add(cb_statusRuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 150, -1));

        jLabel13.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel13.setText("Status");
        panel_form_ruangan.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        btn_reset.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        panel_form_ruangan.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, -1));

        btn_submit.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        panel_form_ruangan.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        jLabel14.setFont(new java.awt.Font("Quicksand SemiBold", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Form Ruangan");
        panel_form_ruangan.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        cb_tipeRuangan.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        cb_tipeRuangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tipe Ruangan", "standard", "superior", "deluxe", " " }));
        panel_form_ruangan.add(cb_tipeRuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, -1));

        getContentPane().add(panel_form_ruangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 660, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        resetColor(btn_tambah);

        resetColor(btn_ruangan);
    }//GEN-LAST:event_jLabel1MousePressed

    private void btn_tambahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMousePressed
        // TODO add your handling code here:
        setColor(btn_tambah);
        panel_form_ruangan.setVisible(true);
        panel_data_ruangan.setVisible(false);
        resetColor(btn_ruangan);
    }//GEN-LAST:event_btn_tambahMousePressed

    private void btn_ruanganMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ruanganMousePressed
        // TODO add your handling code here:
        showDataRuangan();
        setColor(btn_ruangan);
        panel_form_ruangan.setVisible(false);
        panel_data_ruangan.setVisible(true);
        resetColor(btn_tambah);
    }//GEN-LAST:event_btn_ruanganMousePressed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        clearComponents();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void tb_ruanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ruanganMouseClicked
        // TODO add your handling code here:
        setVisibleComponents(true);
        int baris = tb_ruangan.rowAtPoint(evt.getPoint());

        String id = tb_ruangan.getValueAt(baris, 0).toString();
        tf_rincianIdRuangan.setText(id);
        tf_rincianIdRuangan.setEditable(false);

        String harga = tb_ruangan.getValueAt(baris, 1).toString();
        tf_rincianHarga.setText(harga);

        String tipeRuangan = tb_ruangan.getValueAt(baris, 2).toString();
        cb_rincianTipeRuangan.setSelectedItem(tipeRuangan);
        
        String status = tb_ruangan.getValueAt(baris, 3).toString();
        cb_rincianStatus.setSelectedItem(status);
        
    }//GEN-LAST:event_tb_ruanganMouseClicked

    private void tf_cariRuanganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariRuanganKeyPressed
        // TODO add your handling code here:
        cariData();
        setVisibleComponents(false);
        if ("".equals(tf_cariRuangan.getText())) {
            showDataRuangan();
        }
    }//GEN-LAST:event_tf_cariRuanganKeyPressed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        cariData();
        setVisibleComponents(false);
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus Data?");
        if (opsi == JOptionPane.YES_OPTION)  {
            try {
                String sql = "DELETE FROM room WHERE id_room='"+ tf_rincianIdRuangan.getText() +"'";
                Connection conn = (Connection)Config.configDB();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(this, "Hapus Data Berhasil...");
                showDataRuangan();
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
        if (tf_rincianHarga.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data Harga Tidak Boleh Kosong");
        } else {
            updateDataRuangan();
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        if (cb_statusRuangan.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Data Status Ruangan Tidak Boleh Kosong");
        } else
            if (cb_tipeRuangan.getSelectedIndex() == 0 ) {
                JOptionPane.showMessageDialog(null, "Data Tipe Ruangan Tidak Boleh Kosong");
            } else {
                addDataRuangan();
            }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void tf_idRuanganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_idRuanganKeyPressed
        // TODO add your handling code here:
        String idRuangan = tf_idRuangan.getText();
        
        int length = idRuangan.length();
        if ( length < 4 ) {
            tf_idRuangan.setEditable(true);
        } else 
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ) {
                tf_idRuangan.setEditable(true);
            } 
        else {
            tf_idRuangan.setEditable(false);
        }
    }//GEN-LAST:event_tf_idRuanganKeyPressed

    private void tf_hargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_hargaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            tf_harga.setEditable(false);
        } else {
            tf_harga.setEditable(true);
        }
    }//GEN-LAST:event_tf_hargaKeyTyped

    private void tf_rincianHargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_rincianHargaKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            tf_rincianHarga.setEditable(false);
        } else {
            tf_rincianHarga.setEditable(true);
        }
    }//GEN-LAST:event_tf_rincianHargaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_reset;
    private javax.swing.JPanel btn_ruangan;
    private javax.swing.JButton btn_submit;
    private javax.swing.JPanel btn_tambah;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_rincianStatus;
    private javax.swing.JComboBox<String> cb_rincianTipeRuangan;
    private javax.swing.JComboBox<String> cb_statusRuangan;
    private javax.swing.JComboBox<String> cb_tipeRuangan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_data_ruangan;
    private javax.swing.JPanel panel_form_ruangan;
    private javax.swing.JPanel side_panel;
    private javax.swing.JTable tb_ruangan;
    private javax.swing.JTextField tf_cariRuangan;
    private javax.swing.JTextField tf_harga;
    private javax.swing.JTextField tf_idRuangan;
    private javax.swing.JTextField tf_rincianHarga;
    private javax.swing.JTextField tf_rincianIdRuangan;
    private javax.swing.JLabel tv_rincianDataRuangan;
    private javax.swing.JLabel tv_rincianHarga;
    private javax.swing.JLabel tv_rincianIdRuangan;
    private javax.swing.JLabel tv_rincianJk;
    private javax.swing.JLabel tv_rincianStatus;
    // End of variables declaration//GEN-END:variables
}
