package br.com.loja.views;

import java.sql.*;
import br.com.loja.dal.ConnectionModule;
import javax.swing.JOptionPane;

public class Users extends javax.swing.JInternalFrame {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Users() {
        initComponents();
        connection = ConnectionModule.connector();
    }
    
    private void clearFields() {
        txtUsername.setText(null);
        txtPhone.setText(null);
        txtEmail.setText(null);
        txtPassword.setText(null);
        comboProfile.setSelectedIndex(0);
    }
    
    private boolean isFieldsEmpty() {
        return (txtUsername.getText().isEmpty() 
                || txtPhone.getText().isEmpty() 
                || txtEmail.getText().isEmpty() 
                ||(new String(txtPassword.getPassword())).isEmpty());
    }
    
    private void add() {
        try {
            if(isFieldsEmpty()) throw new Exception("Please, fill in all the fields");
            
            String sql = 
                "INSERT INTO users (username, phone, email, password, profile)"
                    + "VALUES (?,?,?,?,?);";
            
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtUsername.getText());
            ps.setString(2, txtPhone.getText());
            ps.setString(3, txtEmail.getText());
            ps.setString(4, new String(txtPassword.getPassword()));
            ps.setString(5, comboProfile.getSelectedItem().toString());
            int result = ps.executeUpdate();
            
            switch(result) {
                case 1:
                    clearFields();
                    JOptionPane.showMessageDialog(null, "User successfully created!");
                    break;
                default:
                    clearFields();
                    throw new Exception("Something went wrong, please try again later");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void update() {
                try {
            String sql = "SELECT id FROM users WHERE email = ?";
            
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtEmail.getText());
            rs = ps.executeQuery();
            
            if (!rs.next()) throw new Exception("User not found");
            
            String id = rs.getString(1);
            sql = "UPDATE users SET "
                    + "username=?, "
                    + "phone=?, "
                    + "password=?, "
                    + "profile=? "
                    + "WHERE id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtUsername.getText());
            ps.setString(2, txtPhone.getText());
            ps.setString(3, new String(txtPassword.getPassword()));
            ps.setString(4, comboProfile.getSelectedItem().toString());
            ps.setString(5, id);
            int result = ps.executeUpdate();
            
            switch(result) {
                case 1:
                    clearFields();
                    JOptionPane.showMessageDialog(null, "User successfully updated!");
                    break;
                default:
                    clearFields();
                    throw new Exception("Something went wrong, please try again later");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            clearFields();
        }
    }
    
    private void remove() {
        try {
            String sql = "SELECT id FROM users WHERE email = ?";
            
            ps = connection.prepareStatement(sql);
            ps.setString(1, txtEmail.getText());
            rs = ps.executeQuery();
            
            if (!rs.next()) throw new Exception("User not found");
            
            String id = rs.getString(1);
            sql = "DELETE FROM users WHERE id = " + id;
            ps = connection.prepareStatement(sql);
            int result = ps.executeUpdate();
            
            switch(result) {
                case 1:
                    clearFields();
                    JOptionPane.showMessageDialog(null, "User successfully deleted!");
                    break;
                default:
                    clearFields();
                    throw new Exception("Something went wrong, please try again later");
            }
            
            JOptionPane.showMessageDialog(null, "User successfully created!");
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            clearFields();
        }
    }
    
    private void selectByEmail() {
        try {
            String sql = 
                "SELECT * FROM users WHERE email LIKE '%" + 
                txtEmail.getText() + 
                "%'";
            
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if (!rs.next()) throw new Exception("User not found");
            
            txtUsername.setText(rs.getString(2));
            txtPhone.setText(rs.getString(3));
            txtEmail.setText(rs.getString(4));
            txtPassword.setText(rs.getString(5));
            comboProfile.setSelectedIndex(
                "ADMIN".equals(rs.getString(6).toUpperCase()) 
                    ? 1 
                    : 0
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            clearFields();
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        comboProfile = new javax.swing.JComboBox<>();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSelect = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Insert Users");

        jLabel2.setText("Username:");

        jLabel3.setText("Phone:");

        jLabel4.setText("Email:");

        jLabel5.setText("Password:");

        jLabel6.setText("Profile Type:");

        comboProfile.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icons/create.png"))); // NOI18N
        btnCreate.setToolTipText("Create");
        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icons/delete.png"))); // NOI18N
        btnDelete.setToolTipText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setPreferredSize(new java.awt.Dimension(80, 80));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icons/read.png"))); // NOI18N
        btnSelect.setToolTipText("Search");
        btnSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelect.setPreferredSize(new java.awt.Dimension(80, 80));
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/loja/icons/update.png"))); // NOI18N
        btnEdit.setToolTipText("Update");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(txtPhone)
                            .addComponent(txtEmail)
                            .addComponent(txtPassword)
                            .addComponent(comboProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        add();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        selectByEmail();
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        remove();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        update();
    }//GEN-LAST:event_btnEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox<String> comboProfile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
