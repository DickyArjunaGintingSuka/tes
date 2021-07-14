/*
 * POLITEKNIK CALTEX RIAU
 * 1 TEKNIK KOMPUTER
 */
package TRAVEL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Dicky Arjuna Ginting Suka <2056401008>
 */
public class Register extends javax.swing.JFrame {

    ResultSet rs;
    java.sql.PreparedStatement pstm;
    java.sql.Connection con;
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        clear();
    }

    public void clear(){
        username.setText(null);
        password.setText(null);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        cek = new javax.swing.JButton();
        daftar = new javax.swing.JButton();
        login = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("REGISTRASI AKUN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("USERNAME");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("PASSWORD");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        cek.setText("CEK KETERSEDIAAN USERNAME");
        cek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekActionPerformed(evt);
            }
        });

        daftar.setText("DAFTAR");
        daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarActionPerformed(evt);
            }
        });

        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(cek)
                        .addGap(248, 248, 248))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(daftar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cek))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daftar)
                    .addComponent(login))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarActionPerformed
        // TODO add your handling code here:
        try {
            String adm = "select uAdmin from admin";
            con = (Connection) konfig.configDB();
            pstm = con.prepareStatement(adm);
            pstm.execute();
            rs = pstm.executeQuery();
            if (rs.next()) {
                if (username.getText().equals(rs.getString("uAdmin"))) {
                    JOptionPane.showMessageDialog(null, "Username yang anda masukkan tidak tersedia!");
                }
                else {
                if (!username.getText().equals("") && !password.getText().equals("")) {
                    try {
                        String sql = "insert into akun values ('" + username.getText() + "',"
                                + "'" + password.getText() + "');";
                        con = (Connection) konfig.configDB();
                        pstm = con.prepareStatement(sql);
                        pstm.execute();
                        JOptionPane.showMessageDialog(null, "Akun Berhasil Dibuat");
                        clear();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Username yang anda masukkan tidak tersedia!");
                    }
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong!");
                }
            }
            } 
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_daftarActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_loginActionPerformed

    private void cekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekActionPerformed
        try {
            String adm = "select uAdmin from admin where uAdmin='"+username.getText()+"'";
            con = (Connection) konfig.configDB();
            pstm = con.prepareStatement(adm);
            pstm.execute();
            rs = pstm.executeQuery();
            if (rs.next()){
                if (username.getText().equals(rs.getString("uAdmin"))){
                    JOptionPane.showMessageDialog(null, "Username tidak tersedia");
                }
            }
            else {
                try {
                    String sql = "select * from akun where Username='" + username.getText() + "'";
                    con = (Connection) konfig.configDB();
                    pstm = con.prepareStatement(sql);
                    pstm.execute();
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        if (username.getText().equals(rs.getString("Username"))) {
                            JOptionPane.showMessageDialog(null, "Username tidak tersedia");
                        }
                    } else {
                        if (!username.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Username tersedia");
                        } else {
                            JOptionPane.showMessageDialog(null, "Kolom Username tidak boleh kosong");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_cekActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cek;
    private javax.swing.JButton daftar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}