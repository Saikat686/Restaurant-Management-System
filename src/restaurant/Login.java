/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author Aupee
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Connection cn;
    public Login() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        connection();
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
        txtusername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        txtusername.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, 150, 30));

        txtPassword.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 150, 30));

        btnlogin.setBackground(new java.awt.Color(204, 204, 204));
        btnlogin.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        btnlogin.setForeground(new java.awt.Color(51, 51, 255));
        btnlogin.setIcon(new javax.swing.ImageIcon("C:\\Users\\Aupee\\Documents\\NetBeansProjects\\Restaurant\\Project Images\\login icon.png")); // NOI18N
        btnlogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255), 3));
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 60, 30));

        btnClear.setBackground(new java.awt.Color(204, 204, 204));
        btnClear.setForeground(new java.awt.Color(255, 51, 51));
        btnClear.setIcon(new javax.swing.ImageIcon("C:\\Users\\Aupee\\Documents\\NetBeansProjects\\Restaurant\\Project Images\\clear.png")); // NOI18N
        btnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51), 3));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 60, 30));

        jLabel5.setFont(new java.awt.Font("Gabriola", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Restaurant Management System");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 400, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Aupee\\Documents\\NetBeansProjects\\Restaurant\\Project Images\\login icon 2.png")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Aupee\\Documents\\NetBeansProjects\\Restaurant\\Project Images\\login cover.jpg")); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabel3.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel3.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
       txtusername.setText("");
       txtPassword.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        connection();
        String username = txtusername.getText();
        String password = txtPassword.getText();
        try
        {
        Statement st = cn.createStatement();
        String sql = "select * from tblsecurity where username like '"+username+"' and password like '"+password+"'";
        ResultSet rs = st.executeQuery(sql);
        boolean found = false;
        while (rs.next())
        {
            if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
            {
               JOptionPane.showMessageDialog(null, "Login Successfully!");
               found = true;
               new Option().setVisible(true);
               this.dispose();
            }
            if(found = false)
                JOptionPane.showMessageDialog(null, "Invalid account");
        }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnloginActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void connection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbrms", "root", "" );
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Connection is close!");
        }
    }
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
