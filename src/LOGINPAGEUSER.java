
import java.sql.*;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anu_n
 */
public class LOGINPAGEUSER extends javax.swing.JFrame {

    /**
     * Creates new form LOGINPAGEUSER
     */
    public LOGINPAGEUSER() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        USERNAME1 = new javax.swing.JTextField();
        PASSWORD1 = new javax.swing.JPasswordField();
        GO1 = new javax.swing.JButton();
        ADMINLOGIN = new javax.swing.JButton();
        NEWUSER = new javax.swing.JButton();
        LOGINTEXTBOX1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        USERNAME1.setText("username");

        PASSWORD1.setText("password");

        GO1.setText("GO");
        GO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GO1ActionPerformed(evt);
            }
        });

        ADMINLOGIN.setText("ADMIN LOGIN");
        ADMINLOGIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADMINLOGINActionPerformed(evt);
            }
        });

        NEWUSER.setText("NEW USER");
        NEWUSER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NEWUSERActionPerformed(evt);
            }
        });

        LOGINTEXTBOX1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        LOGINTEXTBOX1.setText("USER LOGIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LOGINTEXTBOX1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ADMINLOGIN)
                        .addGap(26, 26, 26)
                        .addComponent(NEWUSER))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PASSWORD1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                            .addComponent(USERNAME1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GO1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(LOGINTEXTBOX1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(USERNAME1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GO1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(PASSWORD1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ADMINLOGIN)
                    .addComponent(NEWUSER))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GO1ActionPerformed

        int uid= Integer.parseInt(USERNAME1.getText());
        String psw = new String (PASSWORD1.getPassword());
        
    try {
            Connection conn = null;
    
    Class.forName("com.mysql.jdbc.Driver");
    
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
    Statement s = conn.createStatement();
    String q = "select password from customer where customer_id ="+uid+";";
    
    
    
    
   ResultSet rs =s.executeQuery(q);
   rs.first();
   String mysql_psw = rs.getString("password");
    System.out.println(psw);
    System.out.println(mysql_psw);
   if(mysql_psw.equals(psw))
   {
       new Post_user_login().setVisible(true);
       dispose();
   }
   else
       JOptionPane.showMessageDialog(null,"Wrong username / password combo");
   
   
}
catch (Exception ex) {
    
    JOptionPane.showMessageDialog(null,ex);
    // handle any errors
    
}
        

        // TODO add your handling code here:
    }//GEN-LAST:event_GO1ActionPerformed

    private void ADMINLOGINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADMINLOGINActionPerformed

        new LOGINPAGEADMIN().setVisible(true);
        dispose();

        


        // TODO add your handling code here:
    }//GEN-LAST:event_ADMINLOGINActionPerformed

    private void NEWUSERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NEWUSERActionPerformed

        new USERREG().setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_NEWUSERActionPerformed

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
            java.util.logging.Logger.getLogger(LOGINPAGEUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGINPAGEUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGINPAGEUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGINPAGEUSER.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGINPAGEUSER().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADMINLOGIN;
    private javax.swing.JButton GO1;
    private javax.swing.JLabel LOGINTEXTBOX1;
    private javax.swing.JButton NEWUSER;
    private javax.swing.JPasswordField PASSWORD1;
    private javax.swing.JTextField USERNAME1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
