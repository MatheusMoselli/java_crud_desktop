package br.com.loja.views;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;


public class Index extends javax.swing.JFrame {

    /**
     * Creates new form Index
     */
    public Index() {
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

        Desktop = new javax.swing.JDesktopPane();
        lblUser = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        MenuRegister = new javax.swing.JMenu();
        MenuRegisterClients = new javax.swing.JMenuItem();
        MenuRegisterOrders = new javax.swing.JMenuItem();
        MenuRegisterUsers = new javax.swing.JMenuItem();
        MenuReport = new javax.swing.JMenu();
        MenuReportServices = new javax.swing.JMenuItem();
        MenuHelp = new javax.swing.JMenu();
        MenuHelpAbout = new javax.swing.JMenuItem();
        MenuOptions = new javax.swing.JMenu();
        MenuOptionsExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUser.setText("User");

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDate.setText("Date");

        MenuRegister.setText("Register");

        MenuRegisterClients.setText("Clients");
        MenuRegisterClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRegisterClientsActionPerformed(evt);
            }
        });
        MenuRegister.add(MenuRegisterClients);

        MenuRegisterOrders.setText("Orders");
        MenuRegister.add(MenuRegisterOrders);

        MenuRegisterUsers.setText("Users");
        MenuRegisterUsers.setEnabled(false);
        MenuRegisterUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRegisterUsersActionPerformed(evt);
            }
        });
        MenuRegister.add(MenuRegisterUsers);

        Menu.add(MenuRegister);

        MenuReport.setText("Reports");
        MenuReport.setEnabled(false);

        MenuReportServices.setText("Services");
        MenuReport.add(MenuReportServices);

        Menu.add(MenuReport);

        MenuHelp.setText("Help");

        MenuHelpAbout.setText("About");
        MenuHelpAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuHelpAboutActionPerformed(evt);
            }
        });
        MenuHelp.add(MenuHelpAbout);

        Menu.add(MenuHelp);

        MenuOptions.setText("Options");

        MenuOptionsExit.setText("Exit");
        MenuOptionsExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOptionsExitActionPerformed(evt);
            }
        });
        MenuOptions.add(MenuOptionsExit);

        Menu.add(MenuOptions);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(lblUser))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblDate)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Desktop)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(lblUser)
                .addGap(48, 48, 48)
                .addComponent(lblDate)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuRegisterClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRegisterClientsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuRegisterClientsActionPerformed

    private void MenuRegisterUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRegisterUsersActionPerformed
        Users users = new Users();
        users.setVisible(true);
        Desktop.add(users);
    }//GEN-LAST:event_MenuRegisterUsersActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Date date = new Date();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.SHORT);
        lblDate.setText(formatter.format(date));
    }//GEN-LAST:event_formWindowActivated

    private void MenuOptionsExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOptionsExitActionPerformed
        int leave = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave?", "Leaving", JOptionPane.YES_NO_OPTION);
        if(leave == JOptionPane.YES_OPTION) System.exit(0);
    }//GEN-LAST:event_MenuOptionsExitActionPerformed

    private void MenuHelpAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuHelpAboutActionPerformed
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_MenuHelpAboutActionPerformed

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu MenuHelp;
    private javax.swing.JMenuItem MenuHelpAbout;
    private javax.swing.JMenu MenuOptions;
    private javax.swing.JMenuItem MenuOptionsExit;
    private javax.swing.JMenu MenuRegister;
    private javax.swing.JMenuItem MenuRegisterClients;
    private javax.swing.JMenuItem MenuRegisterOrders;
    public static javax.swing.JMenuItem MenuRegisterUsers;
    public static javax.swing.JMenu MenuReport;
    private javax.swing.JMenuItem MenuReportServices;
    private javax.swing.JLabel lblDate;
    public static javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
