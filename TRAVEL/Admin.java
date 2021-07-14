/*
 * POLITEKNIK CALTEX RIAU
 * 1 TEKNIK KOMPUTER
 */
package TRAVEL;

import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Dicky Arjuna Ginting Suka <2056401008>
 */
public class Admin extends javax.swing.JFrame {

    java.sql.Connection con;
    java.sql.PreparedStatement pstm;
    
    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        TampilData();
        clear();
    }

    public void clear(){
    NIK.setText(null);
    Nama.setText(null);
    Umur.setText(null);
    Email.setText(null);
    Telepon.setText(null);
    buttonGroup1.clearSelection();
    Rute.setSelectedIndex(0);
    Kendaraan.setSelectedIndex(0);
    }
    
    public void cariData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("NIK");
        model.addColumn("Nama");
        model.addColumn("Umur");
        model.addColumn("Kelamin");
        model.addColumn("Email");
        model.addColumn("Rute");
        model.addColumn("Kendaraan");
        model.addColumn("Telepon");
        model.addColumn("Status");
        try {
            int no = 1;
            String sql = "select * from status where NIK like '%" + search.getText() + "%'"
                    + "or Nama like '%" + search.getText() + "%'"
                    + "or Umur like '%" + search.getText() + "%'"
                    + "or Kelamin like '%" + search.getText() + "%'"
                    + "or Email like '%" + search.getText() + "%'"
                    + "or Rute like '%" + search.getText() + "%'"
                    + "or Kendaraan like '%" + search.getText() + "%'"
                    + "or Telepon like '%" + search.getText() + "%'"
                    + "or Status like '%" + search.getText() + "%'"
                    ;
            java.sql.Connection conn = (Connection) konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9)});
            }
            tabel.setModel(model);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public void TampilData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("NIK");
        model.addColumn("Nama");
        model.addColumn("Umur");
        model.addColumn("Kelamin");
        model.addColumn("Email");
        model.addColumn("Rute");
        model.addColumn("Kendaraan");
        model.addColumn("Telepon");
        model.addColumn("Status");
        try {
            int no = 1;
            String sql = "select * from status";
            java.sql.Connection conn = (Connection) konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                    no++,
                    res.getString(1),
                    res.getString(2),
                    res.getString(3),
                    res.getString(4),
                    res.getString(5),
                    res.getString(6),
                    res.getString(7),
                    res.getString(8),
                    res.getString(9)});
            }
            tabel.setModel(model);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    public void ubahPesanan(){
        if (NIK.getText().isEmpty() || Nama.getText().isEmpty() || Umur.getText().isEmpty() || Email.getText().isEmpty() || Telepon.getText().isEmpty()
                || !laki.isSelected() && !wanita.isSelected() || Rute.getSelectedItem().equals("Pilih Rute Anda") 
                || Kendaraan.getSelectedItem().equals("Pilih Jenis Kendaraan yang tersedia"))
        {
            JOptionPane.showMessageDialog(null, "Data belum lengkap, Silahkan lengkapi formulir");
        }
        else {
            try {
                String sql = "update status set NIK='" + NIK.getText() + "',Nama='"
                        + Nama.getText() + "',Umur='" 
                        + Umur.getText() + "',Kelamin='" 
                        + buttonGroup1.getSelection().getActionCommand() + "',Email='"
                        + Email.getText() + "',Rute='"
                        + Rute.getSelectedItem() + "',Kendaraan='"
                        + Kendaraan.getSelectedItem() + "',Telepon='"
                        + Telepon.getText() + "' where NIK='" + NIK.getText() + "'";
                        
                con = (Connection) konfig.configDB();
                pstm = con.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Data Pesanan berhasil dirubah");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                JOptionPane.showMessageDialog(null, "Data Pesanan gagal dirubah");
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel15 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        TerimaPesanan14 = new javax.swing.JButton();
        TolakPesanan14 = new javax.swing.JButton();
        HapusPesanan14 = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        cek = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NIK = new javax.swing.JTextField();
        Nama = new javax.swing.JTextField();
        Umur = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        Telepon = new javax.swing.JTextField();
        laki = new javax.swing.JRadioButton();
        wanita = new javax.swing.JRadioButton();
        Rute = new javax.swing.JComboBox<>();
        Kendaraan = new javax.swing.JComboBox<>();
        exit = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        cetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("TABEL STATUS");

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tabel);

        TerimaPesanan14.setText("TERIMA");
        TerimaPesanan14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerimaPesanan14ActionPerformed(evt);
            }
        });

        TolakPesanan14.setText("TOLAK");
        TolakPesanan14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TolakPesanan14ActionPerformed(evt);
            }
        });

        HapusPesanan14.setText("HAPUS");
        HapusPesanan14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusPesanan14ActionPerformed(evt);
            }
        });

        ubah.setText("UBAH");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        cek.setText("CEK");
        cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekActionPerformed(evt);
            }
        });

        jLabel1.setText("NIK");

        jLabel2.setText("Nama");

        jLabel3.setText("Umur");

        jLabel4.setText("Kelamin");

        jLabel5.setText("Email");

        jLabel6.setText("Rute");

        jLabel7.setText("Kendaraan");

        jLabel8.setText("Telepon");

        buttonGroup1.add(laki);
        laki.setText("Laki-Laki");
        laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lakiActionPerformed(evt);
            }
        });

        buttonGroup1.add(wanita);
        wanita.setText("Perempuan");
        wanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wanitaActionPerformed(evt);
            }
        });

        Rute.setBackground(new java.awt.Color(153, 153, 153));
        Rute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Rute Anda", "Padang", "Pekanbaru", "Medan" }));

        Kendaraan.setBackground(new java.awt.Color(153, 153, 153));
        Kendaraan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Kendaraan yang tersedia", "Avanza", "Panther", "Ferrari" }));

        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Cari");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        cetak.setText("CETAK");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(33, 33, 33)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Umur, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NIK, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel15Layout.createSequentialGroup()
                                            .addComponent(laki)
                                            .addGap(31, 31, 31)
                                            .addComponent(wanita)))
                                    .addGap(100, 100, 100)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                    .addGap(33, 33, 33)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Telepon, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                                        .addComponent(Rute, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Kendaraan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TerimaPesanan14, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(TolakPesanan14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HapusPesanan14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TerimaPesanan14)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(NIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Rute)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(TolakPesanan14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Kendaraan)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HapusPesanan14)
                        .addComponent(jLabel3)
                        .addComponent(Umur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubah)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(Telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laki)
                    .addComponent(wanita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cek)
                .addGap(2, 2, 2)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(exit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cetak)))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekActionPerformed
        // TODO add your handling code here:
        TampilData();
    }//GEN-LAST:event_cekActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // nik, nama, umur, kelamin, email, rute, kendaraan, telepon
        int baris = tabel.rowAtPoint(evt.getPoint());
        NIK.setText(tabel.getValueAt(baris, 1).toString());
        Nama.setText(tabel.getValueAt(baris, 2).toString());
        Umur.setText(tabel.getValueAt(baris, 3).toString());
        if (tabel.getValueAt(baris, 4).toString().equals(laki.getText())){
            laki.setSelected(true);
            wanita.setSelected(false);
        }
        else {
            wanita.setSelected(true);
            laki.setSelected(false);
        }
        Email.setText(tabel.getValueAt(baris, 5).toString());
        if (tabel.getValueAt(baris, 6).toString().equals("Padang"))
        {
            Rute.setSelectedIndex(1);
        }
        else if (tabel.getValueAt(baris, 6).toString().equals("Pekanbaru"))
        {
            Rute.setSelectedIndex(2);
        }
        else if (tabel.getValueAt(baris, 6).toString().equals("Medan"))
        {
            Rute.setSelectedIndex(3);
        }
        
        if (tabel.getValueAt(baris, 7).toString().equals("Avanza"))
        {
            Kendaraan.setSelectedIndex(1);
        }
        else if (tabel.getValueAt(baris, 7).toString().equals("Panther"))
        {
            Kendaraan.setSelectedIndex(2);
        }
        else if (tabel.getValueAt(baris, 7).toString().equals("Ferrari"))
        {
            Kendaraan.setSelectedIndex(3);
        }
        Telepon.setText(tabel.getValueAt(baris, 8).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void lakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lakiActionPerformed
        // TODO add your handling code here:
        laki.setActionCommand(laki.getText());
    }//GEN-LAST:event_lakiActionPerformed

    private void wanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wanitaActionPerformed
        // TODO add your handling code here:
        wanita.setActionCommand(wanita.getText());
    }//GEN-LAST:event_wanitaActionPerformed

    private void HapusPesanan14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusPesanan14ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "delete from status where NIK='"+NIK.getText()+"'";
            con = (Connection) konfig.configDB();
            pstm = con.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
            clear();
            TampilData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        }
    }//GEN-LAST:event_HapusPesanan14ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
       // TODO add your handling code here:
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        ubahPesanan();
        clear();
        TampilData();
    }//GEN-LAST:event_ubahActionPerformed

    private void TerimaPesanan14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerimaPesanan14ActionPerformed
        // TODO add your handling code here:
        if (NIK.getText().isEmpty() || Nama.getText().isEmpty() || Umur.getText().isEmpty() || Email.getText().isEmpty() || Telepon.getText().isEmpty()
                || !laki.isSelected() && !wanita.isSelected() || Rute.getSelectedItem().equals("Pilih Rute Anda") 
                || Kendaraan.getSelectedItem().equals("Pilih Jenis Kendaraan yang tersedia"))
        {
            JOptionPane.showMessageDialog(null, "Tidak ada data dipilih!");
        }
        else {
        String terima = "Pesanan Diterima";
        try {
            String sql = "update status set Status ='" + terima + "' where NIK='" + NIK.getText() + "'";
            con = (Connection) konfig.configDB();
            pstm = con.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Konfirmasi Pesanan");
            clear();
            TampilData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            JOptionPane.showMessageDialog(null, "Status gagal di Update");
        }}
    }//GEN-LAST:event_TerimaPesanan14ActionPerformed

    private void TolakPesanan14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TolakPesanan14ActionPerformed
        // TODO add your handling code here:
        if (NIK.getText().isEmpty() || Nama.getText().isEmpty() || Umur.getText().isEmpty() || Email.getText().isEmpty() || Telepon.getText().isEmpty()
                || !laki.isSelected() && !wanita.isSelected() || Rute.getSelectedItem().equals("Pilih Rute Anda") 
                || Kendaraan.getSelectedItem().equals("Pilih Jenis Kendaraan yang tersedia"))
        {
            JOptionPane.showMessageDialog(null, "Tidak ada data dipilih!");
        }
        else {
        String tolak = "Pesanan Ditolak";
        try {
            String sql = "update status set Status ='" + tolak + "' where NIK='" + NIK.getText() + "'";
            con = (Connection) konfig.configDB();
            pstm = con.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Konfirmasi Pesanan");
            clear();
            TampilData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
            JOptionPane.showMessageDialog(null, "Status gagal di Update");
        }}
    }//GEN-LAST:event_TolakPesanan14ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            cariData();
        }
    }//GEN-LAST:event_searchKeyPressed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        // TODO add your handling code here:
        try {
            File namafile = new File("src/Laporan/travelData.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, konfig.configDB());
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } catch (SQLException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cetakActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JButton HapusPesanan14;
    private javax.swing.JComboBox<String> Kendaraan;
    private javax.swing.JTextField NIK;
    private javax.swing.JTextField Nama;
    private javax.swing.JComboBox<String> Rute;
    private javax.swing.JTextField Telepon;
    private javax.swing.JButton TerimaPesanan14;
    private javax.swing.JButton TolakPesanan14;
    private javax.swing.JTextField Umur;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cek;
    private javax.swing.JButton cetak;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JRadioButton laki;
    private javax.swing.JTextField search;
    private javax.swing.JTable tabel;
    private javax.swing.JButton ubah;
    private javax.swing.JRadioButton wanita;
    // End of variables declaration//GEN-END:variables
}
