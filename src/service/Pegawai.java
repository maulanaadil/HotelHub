
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


public class Pegawai extends javax.swing.JInternalFrame {
    String hintIdPegawai;
    String hintNama;
    String hintAlamat;
    String hintCari;
    
   
    public Pegawai() {
        hintIdPegawai = "Masukan ID Pegawai..";
        hintNama = "Masukan Nama..";
        hintAlamat = "Masukan Alamat..";
        hintCari = "Silahkan Masukan Data yang ingin dicari..";
        
        
        initComponents();
        showHint();
        showDataPegawai();
        panel_data_pegawai.setVisible(true);
        panel_form_pegawai.setVisible(false);
        setVisibleComponent(false);
       
    }
    
    private void setColor(JPanel panel) {
        panel.setBackground(new Color(179, 201, 201));
    }
    
    private void resetColor(JPanel panel) {
        panel.setBackground(new Color(192,212,212));
    }
    
    private void showHint() {
        tf_idPegawai.setUI(new JTextFieldHintUI(hintIdPegawai, Color.GRAY));
        tf_nama.setUI(new JTextFieldHintUI(hintNama, Color.GRAY));
        tf_alamat.setUI(new JTextFieldHintUI(hintAlamat, Color.GRAY));
        tf_cariPegawai.setUI(new JTextFieldHintUI(hintCari, Color.GRAY));
    }
    
     private void setVisibleComponent(Boolean b) {
        tf_idPegawaiUpdate.setVisible(b);
        tf_namaUpdate.setVisible(b);
        tf_alamatUpdate.setVisible(b);
        cb_jkUpdate.setVisible(b);
        tv_rincianDataPegawai.setVisible(b);
        btn_update.setVisible(b);
        btn_hapus.setVisible(b);
        tv_rincianIdPegawai.setVisible(b);
        tv_rincianNama.setVisible(b);
        tv_rincianAlamat.setVisible(b);
        tv_rincianJk.setVisible(b);
    }
    
    private void clearComponents() {
        tf_idPegawai.setText("");
        tf_nama.setText("");
        cb_jk.setSelectedIndex(0);
        tf_alamat.setText("");
    }
    
    public void addDataPegawai() {
        String jenis_kelamin = null;
        try {
            Connection conn = (Connection) Config.configDB();
            
            Statement state = conn.createStatement();
            
            if (cb_jk.getSelectedIndex() == 1) {
                jenis_kelamin = "L";
            } else 
                if (cb_jk.getSelectedIndex() == 2) {
                    jenis_kelamin = "P";
                }
            
            String sql = "INSERT INTO pegawai VALUES('"+ tf_idPegawai.getText() +"', '"+ tf_nama.getText() +"', '" + jenis_kelamin + "', '" + tf_alamat.getText() +"')";
            
            state.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Success Added");
            clearComponents();
            state.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    public void showDataPegawai() {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("No");
        model.addColumn("ID Pegawai");
        model.addColumn("Nama");
        model.addColumn("Jenis kelamin");
        model.addColumn("Alamat");
        
        int no = 1;
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "SELECT * FROM pegawai ORDER BY id_pegawai ASC";
            
            ResultSet res = state.executeQuery(sql);
            
                    
            while (res.next()) {
                
                model.addRow(new Object [] {
                    no++,
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
                tb_pegawai.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }
    
    
    public void cariData() {
        DefaultTableModel model = new DefaultTableModel();
        String cari = tf_cariPegawai.getText();
        model.addColumn("No");
        model.addColumn("ID Pegawai");
        model.addColumn("Nama");
        model.addColumn("Jenis kelamin");
        model.addColumn("Alamat");
        
        int lengthRow = model.getRowCount();
        for (int n=0; n<lengthRow; n++) {
            model.removeRow(n);
        }
        int no = 1;
        try {
            Connection conn = (Connection) Config.configDB();
            Statement state = conn.createStatement();
            String sql = "CALL searchNamaPegawai('"+ tf_cariPegawai.getText() + "')";
            
            ResultSet res = state.executeQuery(sql);
            
                    
            while (res.next()) {
                model.addRow(new Object [] {
                    no++,
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4)
                });
                tb_pegawai.setModel(model);
            }
            state.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        } 
    }
    
   
    
    public void updateDataPegawai() {
        try {
            String sql = "UPDATE pegawai SET id_pegawai='" + tf_idPegawaiUpdate.getText() + 
                    "',nama='" + tf_namaUpdate.getText() + 
                    "',jk='" + cb_jkUpdate.getSelectedItem() + 
                    "',alamat='" + tf_alamatUpdate.getText() + 
                    "' WHERE id_pegawai='" + tf_idPegawaiUpdate.getText() + 
                    "'";
            Connection conn = (Connection)Config.configDB();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(this, "Edit Data Berhasil...");
            showDataPegawai();
            setVisibleComponent(false);
            
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
        btn_pegawai = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_form_pegawai = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tf_idPegawai = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cb_jk = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        tf_alamat = new javax.swing.JTextField();
        btn_reset = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        panel_data_pegawai = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_pegawai = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        tf_cariPegawai = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        tv_rincianDataPegawai = new javax.swing.JLabel();
        tv_rincianIdPegawai = new javax.swing.JLabel();
        tv_rincianNama = new javax.swing.JLabel();
        tv_rincianJk = new javax.swing.JLabel();
        tv_rincianAlamat = new javax.swing.JLabel();
        tf_namaUpdate = new javax.swing.JTextField();
        tf_idPegawaiUpdate = new javax.swing.JTextField();
        tf_alamatUpdate = new javax.swing.JTextField();
        cb_jkUpdate = new javax.swing.JComboBox<>();
        btn_update = new javax.swing.JButton();

        setBackground(new java.awt.Color(220, 228, 228));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        side_panel.setBackground(new java.awt.Color(192, 212, 212));

        jLabel1.setFont(new java.awt.Font("Quicksand SemiBold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pegawai");
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
        jLabel6.setText("Tambah Pegawai");

        javax.swing.GroupLayout btn_tambahLayout = new javax.swing.GroupLayout(btn_tambah);
        btn_tambah.setLayout(btn_tambahLayout);
        btn_tambahLayout.setHorizontalGroup(
            btn_tambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_tambahLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(34, Short.MAX_VALUE))
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

        btn_pegawai.setBackground(new java.awt.Color(192, 212, 212));
        btn_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_pegawaiMousePressed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/people_white.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Quicksand SemiBold", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Data Pegawai");

        javax.swing.GroupLayout btn_pegawaiLayout = new javax.swing.GroupLayout(btn_pegawai);
        btn_pegawai.setLayout(btn_pegawaiLayout);
        btn_pegawaiLayout.setHorizontalGroup(
            btn_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_pegawaiLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_pegawaiLayout.setVerticalGroup(
            btn_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_pegawaiLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(btn_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        javax.swing.GroupLayout side_panelLayout = new javax.swing.GroupLayout(side_panel);
        side_panel.setLayout(side_panelLayout);
        side_panelLayout.setHorizontalGroup(
            side_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_tambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_pegawai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(btn_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
        );

        getContentPane().add(side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 200, 640));

        panel_form_pegawai.setBackground(new java.awt.Color(220, 228, 228));
        panel_form_pegawai.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel10.setText("ID Pegawai");
        panel_form_pegawai.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        tf_idPegawai.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_idPegawai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_idPegawaiKeyPressed(evt);
            }
        });
        panel_form_pegawai.add(tf_idPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 350, -1));

        jLabel11.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel11.setText("Jenis Kelamin");
        panel_form_pegawai.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        tf_nama.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        panel_form_pegawai.add(tf_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 350, -1));

        jLabel12.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel12.setText("Nama");
        panel_form_pegawai.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        cb_jk.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        cb_jk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Kelamin", "Laki-laki", "Perempuan" }));
        panel_form_pegawai.add(cb_jk, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, -1));

        jLabel13.setFont(new java.awt.Font("Quicksand Medium", 1, 14)); // NOI18N
        jLabel13.setText("Alamat");
        panel_form_pegawai.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        tf_alamat.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        panel_form_pegawai.add(tf_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 350, -1));

        btn_reset.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });
        panel_form_pegawai.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, -1));

        btn_submit.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        panel_form_pegawai.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        jLabel14.setFont(new java.awt.Font("Quicksand SemiBold", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Form Pegawai");
        panel_form_pegawai.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        getContentPane().add(panel_form_pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 640, 590));

        panel_data_pegawai.setBackground(new java.awt.Color(220, 228, 228));

        tb_pegawai.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        tb_pegawai.setModel(new javax.swing.table.DefaultTableModel(
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
                "No", "Nama", "Jenis Kelamin", "Alamat"
            }
        ));
        tb_pegawai.setGridColor(new java.awt.Color(255, 255, 255));
        tb_pegawai.getTableHeader().setReorderingAllowed(false);
        tb_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_pegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_pegawai);

        tf_cariPegawai.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tf_cariPegawai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_cariPegawaiKeyPressed(evt);
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
        jLabel15.setText("Data Pegawai");

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
        jLabel18.setText("Ketik Nama Pegawai untuk Mencari Data Pegawai:");

        tv_rincianDataPegawai.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianDataPegawai.setText("Rincian Data Pegawai");

        tv_rincianIdPegawai.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianIdPegawai.setText("ID Pegawai");

        tv_rincianNama.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianNama.setText("Nama");

        tv_rincianJk.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianJk.setText("Jenis Kelamin");

        tv_rincianAlamat.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N
        tv_rincianAlamat.setText("Alamat");

        tf_namaUpdate.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        tf_idPegawaiUpdate.setBackground(new java.awt.Color(234, 246, 248));
        tf_idPegawaiUpdate.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        tf_alamatUpdate.setFont(new java.awt.Font("Quicksand SemiBold", 0, 12)); // NOI18N

        cb_jkUpdate.setFont(new java.awt.Font("Quicksand Medium", 0, 12)); // NOI18N
        cb_jkUpdate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L", "P" }));

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_data_pegawaiLayout = new javax.swing.GroupLayout(panel_data_pegawai);
        panel_data_pegawai.setLayout(panel_data_pegawaiLayout);
        panel_data_pegawaiLayout.setHorizontalGroup(
            panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_data_pegawaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hapus)
                .addGap(57, 57, 57))
            .addGroup(panel_data_pegawaiLayout.createSequentialGroup()
                .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_data_pegawaiLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(panel_data_pegawaiLayout.createSequentialGroup()
                                .addComponent(tf_cariPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_cari))))
                    .addGroup(panel_data_pegawaiLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tv_rincianDataPegawai)
                            .addGroup(panel_data_pegawaiLayout.createSequentialGroup()
                                .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tv_rincianNama)
                                    .addComponent(tv_rincianIdPegawai)
                                    .addComponent(tv_rincianJk)
                                    .addComponent(tv_rincianAlamat))
                                .addGap(29, 29, 29)
                                .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_idPegawaiUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_namaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_alamatUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_jkUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(panel_data_pegawaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panel_data_pegawaiLayout.setVerticalGroup(
            panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_data_pegawaiLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cariPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cari))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_hapus)
                    .addComponent(btn_update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tv_rincianDataPegawai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_rincianIdPegawai)
                    .addComponent(tf_idPegawaiUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_rincianNama)
                    .addComponent(tf_namaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_rincianJk)
                    .addComponent(cb_jkUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_data_pegawaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tv_rincianAlamat)
                    .addComponent(tf_alamatUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(panel_data_pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMousePressed
        // TODO add your handling code here:
        setColor(btn_tambah);
        panel_form_pegawai.setVisible(true);
        panel_data_pegawai.setVisible(false);
        resetColor(btn_pegawai);
    }//GEN-LAST:event_btn_tambahMousePressed

    private void btn_pegawaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pegawaiMousePressed
        // TODO add your handling code here:
        showDataPegawai();
        setColor(btn_pegawai);
        panel_form_pegawai.setVisible(false);
        panel_data_pegawai.setVisible(true);
        resetColor(btn_tambah);
    }//GEN-LAST:event_btn_pegawaiMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        resetColor(btn_tambah);
        
        resetColor(btn_pegawai);
    }//GEN-LAST:event_jLabel1MousePressed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        clearComponents();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void tf_idPegawaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_idPegawaiKeyPressed
        // TODO add your handling code here:
        String idTamu = tf_idPegawai.getText();
        
        int length = idTamu.length();
        if ( length < 4 ) {
            tf_idPegawai.setEditable(true);
        } else 
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ) {
                tf_idPegawai.setEditable(true);
            } 
        else {
            tf_idPegawai.setEditable(false);
        }
    }//GEN-LAST:event_tf_idPegawaiKeyPressed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        if (tf_nama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data Nama Tidak Boleh Kosong");
        } else 
            if (tf_alamat.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Alamat Tidak Boleh Kosong");
            }
            else {
                addDataPegawai();
            }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
        cariData();
        setVisibleComponent(false);
    }//GEN-LAST:event_btn_cariActionPerformed

    private void tf_cariPegawaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariPegawaiKeyPressed
        // TODO add your handling code here:
        cariData();
        setVisibleComponent(false);
        if (!"".equals(tf_cariPegawai.getText())) {
        } else {
            showDataPegawai();
        }
    }//GEN-LAST:event_tf_cariPegawaiKeyPressed

    private void tb_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_pegawaiMouseClicked
        // TODO add your handling code here:
        setVisibleComponent(true);
        int baris = tb_pegawai.rowAtPoint(evt.getPoint());
        
        String id = tb_pegawai.getValueAt(baris, 1).toString();
        tf_idPegawaiUpdate.setText(id);
        tf_idPegawaiUpdate.setEditable(false);
        
        String nama = tb_pegawai.getValueAt(baris, 2).toString();
        tf_namaUpdate.setText(nama);
        
        String jenisKelamin = tb_pegawai.getValueAt(baris, 3).toString();
        cb_jkUpdate.setSelectedItem(jenisKelamin);
        
        String alamat = tb_pegawai.getValueAt(baris, 4).toString();
        tf_alamatUpdate.setText(alamat);
    }//GEN-LAST:event_tb_pegawaiMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus Data?");
        if (opsi == JOptionPane.YES_OPTION)  {
            try {
                String sql = "DELETE FROM pegawai WHERE id_pegawai='"+ tf_idPegawaiUpdate.getText() +"'";
                Connection conn = (Connection)Config.configDB();
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(this, "Hapus Data Berhasil...");
                showDataPegawai();
                setVisibleComponent(false);
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
        if (tf_namaUpdate.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data Nama Tidak Boleh Kosong");
        } else 
            if (tf_alamatUpdate.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Data Alamat Tidak Boleh Kosong");
            }
            else {
                updateDataPegawai();
            }
    }//GEN-LAST:event_btn_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JPanel btn_pegawai;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_submit;
    private javax.swing.JPanel btn_tambah;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> cb_jk;
    private javax.swing.JComboBox<String> cb_jkUpdate;
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
    private javax.swing.JPanel panel_data_pegawai;
    private javax.swing.JPanel panel_form_pegawai;
    private javax.swing.JPanel side_panel;
    private javax.swing.JTable tb_pegawai;
    private javax.swing.JTextField tf_alamat;
    private javax.swing.JTextField tf_alamatUpdate;
    private javax.swing.JTextField tf_cariPegawai;
    private javax.swing.JTextField tf_idPegawai;
    private javax.swing.JTextField tf_idPegawaiUpdate;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_namaUpdate;
    private javax.swing.JLabel tv_rincianAlamat;
    private javax.swing.JLabel tv_rincianDataPegawai;
    private javax.swing.JLabel tv_rincianIdPegawai;
    private javax.swing.JLabel tv_rincianJk;
    private javax.swing.JLabel tv_rincianNama;
    // End of variables declaration//GEN-END:variables
}
