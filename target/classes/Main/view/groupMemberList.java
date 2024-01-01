package Main.view;

import Main.controller.GroupController;
import Main.entity.Group;
import Main.entity.GroupMember;
import Main.shareEnv.Share;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author HP-PC
 */
public class groupMemberList extends javax.swing.JFrame {

    ArrayList<GroupMember> friendRequest;
    String groupId;
    String groupName;

    /**
     * Creates new form loginForm
     */
    public groupMemberList(String idGroup) {
        initComponents();
        groupId = idGroup;

        ArrayList<Group> groupList = GroupController.apiGroupList();
        for (Group group : groupList) {
            if (group.idGroup.equals(groupId)) {
                groupName = group.nameGroup;
            }

        }

        friendRequest = GroupController.apiGroupMemberList(idGroup);
        groupNameLabel.setText(groupName);

        DefaultTableModel model = (DefaultTableModel) memberList.getModel();
        model.setRowCount(0);
        int i = 0;
        for (GroupMember friend : friendRequest) {
            ++i;
            Object[] rowData = {i, friend.getUsername(), friend.getFullname(), friend.getRole()};
            model.addRow(rowData);
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

        jPanel1 = new javax.swing.JPanel();
        groupNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberList = new javax.swing.JTable();
        backbtn = new javax.swing.JLabel();
        addMember = new javax.swing.JButton();
        renameGroup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(128, 161, 183));

        groupNameLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        groupNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        groupNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        groupNameLabel.setText("Group Member");

        memberList.setBackground(new java.awt.Color(128, 190, 183));
        memberList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        memberList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Bao", "bao", null},
                {"2", "Thai", "thai", null},
                {"3", "An", null, null},
                {"4", "Ly", "ed", null}
            },
            new String [] {
                "STT", "Full name", "Username", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        memberList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                memberListMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(memberList);

        backbtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        backbtn.setForeground(new java.awt.Color(255, 255, 255));
        backbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-back-30.png"))); // NOI18N
        backbtn.setText("Back");
        backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backbtnMousePressed(evt);
            }
        });

        addMember.setBackground(new java.awt.Color(128, 190, 183));
        addMember.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addMember.setForeground(new java.awt.Color(255, 255, 255));
        addMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-add-user-male-30.png"))); // NOI18N
        addMember.setText("Add member");
        addMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addMemberMousePressed(evt);
            }
        });

        renameGroup.setBackground(new java.awt.Color(128, 190, 183));
        renameGroup.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        renameGroup.setForeground(new java.awt.Color(255, 255, 255));
        renameGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-autograph-30.png"))); // NOI18N
        renameGroup.setText("Rename Group");
        renameGroup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                renameGroupMousePressed(evt);
            }
        });
        renameGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addMember)
                        .addGap(18, 18, 18)
                        .addComponent(renameGroup))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addComponent(groupNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(823, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(groupNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(renameGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(471, Short.MAX_VALUE)))
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

    private void memberListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberListMousePressed
        // TODO add your handling code here:
        int selectedRow = memberList.getSelectedRow();

        Object[] options = {"Invite as Admin", "Remove Member", "Cancel"};

        // Show a JOptionPane with custom options
        int choice = JOptionPane.showOptionDialog(
                null,
                "Which do you want to do?",
                "Menu Group Option",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2] // Default option is "Cancel"
        );

        switch (choice) {
            case JOptionPane.YES_OPTION -> {
                String usernameInvite = friendRequest.get(selectedRow).getUsername();
                boolean isAdmin = false;
                for (GroupMember member : friendRequest) {
                    if (Share.username.equals(member.username) && member.role.equals("admin")) {
                        isAdmin = true;
                        break;
                    }
                }

                if (isAdmin) {
                    boolean isInvited = GroupController.apiInviteAdmin(groupId, usernameInvite);
                    if (Share.username.equals(usernameInvite)) {
                        JOptionPane.showMessageDialog(null, "You cannot invite yourself" + " as Admin role!",
                                "Message", JOptionPane.OK_OPTION);
                    } else {
                        if (isInvited) {
                            JOptionPane.showMessageDialog(null, "You invited " + usernameInvite + " as Admin role!",
                                    "Message", JOptionPane.OK_OPTION);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cannot invite " + usernameInvite + " as Admin role!",
                                    "Message", JOptionPane.OK_OPTION);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You dont have permission!",
                            "Message", JOptionPane.OK_OPTION);
                }
                break;

            }
            case JOptionPane.NO_OPTION -> {
                boolean isAdmin = false;
                for (GroupMember member : friendRequest) {
                    if (Share.username.equals(member.username) && member.role.equals("admin")) {
                        isAdmin = true;
                        break;
                    }
                }

                if (isAdmin) {
                    String usernameRemoved = friendRequest.get(selectedRow).getUsername();
                    if (usernameRemoved.equals(Share.username)) {
                        JOptionPane.showMessageDialog(null, "You cannot remove yourself from group!",
                                "Message", JOptionPane.OK_OPTION);
                    } else {
                        boolean isRemoved = GroupController.apiRemoveGroupMember(friendRequest.get(selectedRow).getUsername(), groupId);
                        if (isRemoved) {
                            JOptionPane.showMessageDialog(null, "Removed Successfully!",
                                    "Message", JOptionPane.OK_OPTION);
                            dispose();
                            java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    new groupMemberList(groupId).setVisible(true);
                                }
                            });
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You dont have permission!",
                            "Message", JOptionPane.OK_OPTION);
                }
                break;
            }
            case JOptionPane.CANCEL_OPTION -> {

                break;
            }
            case JOptionPane.CLOSED_OPTION ->
                System.out.println("User closed the dialog without choosing");
        }
    }//GEN-LAST:event_memberListMousePressed

    private void backbtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backbtnMousePressed
        // TODO add your handling code here:
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chatboxGroup().setVisible(true);
            }
        });
    }//GEN-LAST:event_backbtnMousePressed

    private void addMemberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMemberMousePressed
        // TODO add your handling code here:
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new addMemberScreen(groupId).setVisible(true);
            }
        });
    }//GEN-LAST:event_addMemberMousePressed

    private void renameGroupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_renameGroupMousePressed
        // TODO add your handling code here:
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter new Group Name: ");
        JTextField textField = new JTextField(20);
        panel.add(label);
        panel.add(textField);
        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Rename Group",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        // Check if the user clicked "OK"
        if (result == JOptionPane.OK_OPTION) {
            String groupName = textField.getText();
            if (!groupName.trim().isEmpty()) {
                // Display a message with the entered name
                boolean isRenamed = GroupController.apiRenameGroup(groupName, groupId);
                if (isRenamed) {
                    groupNameLabel.setText(groupName);
                    JOptionPane.showMessageDialog(null, "You renamed group to " + groupName + " successfully!", "Rename Noti", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "You renamed group to " + groupName + " unsuccessfully!", "Rename Noti", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                // Display an error message if the user entered an empty name
                JOptionPane.showMessageDialog(null, "You didn't enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_renameGroupMousePressed

    private void renameGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameGroupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_renameGroupActionPerformed

    public static void appendUserToLabel(String name) {
    }

    public static void addFriendNoti(String noti) {
        JOptionPane.showMessageDialog(null, noti, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

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
            java.util.logging.Logger.getLogger(groupMemberList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(groupMemberList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(groupMemberList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(groupMemberList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new groupMemberList("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMember;
    private javax.swing.JLabel backbtn;
    private javax.swing.JLabel groupNameLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable memberList;
    private javax.swing.JButton renameGroup;
    // End of variables declaration//GEN-END:variables
}
