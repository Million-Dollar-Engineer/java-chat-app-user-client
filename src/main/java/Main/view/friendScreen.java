/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main.view;
import Main.entity.Friend;
import Main.controller.friendController;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP-PC
 */
public class friendScreen extends javax.swing.JFrame {

    /**
     * Creates new form boxChat
     */
    public friendScreen() {
        initComponents();
        ArrayList<Friend> listFriend = friendController.apiFriendList();
        DefaultTableModel model = (DefaultTableModel) friendListTable.getModel();
        model.setRowCount(0);
        int i = 0;
        for (Friend friend : listFriend) {
            ++i;
            Object[] rowData = {i, friend.getUsername(), friend.getFullname()};
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

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        home = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        friendListTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        chatLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        chatLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        chatLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        chatLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        chatLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        chatLabel11 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jLabel5.setText("jLabel5");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        home.setBackground(new java.awt.Color(128, 161, 183));
        home.setAutoscrolls(true);

        friendListTable.setBackground(new java.awt.Color(128, 190, 183));
        friendListTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        friendListTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        friendListTable.setForeground(new java.awt.Color(255, 255, 255));
        friendListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "1", null}
            },
            new String [] {
                "No.", "Username", "Full Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        friendListTable.setToolTipText("");
        friendListTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        friendListTable.setGridColor(new java.awt.Color(255, 255, 255));
        friendListTable.setRowHeight(30);
        friendListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        friendListTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        friendListTable.setShowGrid(true);
        friendListTable.setUpdateSelectionOnSort(false);
        jScrollPane2.setViewportView(friendListTable);

        jButton1.setBackground(new java.awt.Color(128, 190, 183));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-online-30.png"))); // NOI18N
        jButton1.setText("Online Friend Only");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                onlyFriendMousePress(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Friend List");

        jButton2.setBackground(new java.awt.Color(128, 190, 183));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-add-user-male-30.png"))); // NOI18N
        jButton2.setText("Add Friend");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2onlyFriendMousePress(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                        .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(homeLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(128, 190, 183));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-paper-plane-message-100.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ZALU");

        jPanel2.setBackground(new java.awt.Color(128, 190, 183));

        chatLabel3.setBackground(new java.awt.Color(128, 190, 183));
        chatLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chatLabel3.setForeground(new java.awt.Color(255, 255, 255));
        chatLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chatLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-home-30.png"))); // NOI18N
        chatLabel3.setText("Home");
        chatLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatLabel3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(128, 190, 183));

        chatLabel7.setBackground(new java.awt.Color(128, 190, 183));
        chatLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chatLabel7.setForeground(new java.awt.Color(255, 255, 255));
        chatLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chatLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-chat-30.png"))); // NOI18N
        chatLabel7.setText("Chat Box");
        chatLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatLabel7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chatboxMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(128, 190, 183));

        chatLabel8.setBackground(new java.awt.Color(128, 190, 183));
        chatLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chatLabel8.setForeground(new java.awt.Color(255, 255, 255));
        chatLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chatLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-group-30.png"))); // NOI18N
        chatLabel8.setText("Group Chat");
        chatLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatLabel8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                groupchatMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(128, 161, 183));

        chatLabel9.setBackground(new java.awt.Color(128, 190, 183));
        chatLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chatLabel9.setForeground(new java.awt.Color(255, 255, 255));
        chatLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chatLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-star-30.png"))); // NOI18N
        chatLabel9.setText("Friend");
        chatLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatLabel9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chatLabel9MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(128, 190, 183));

        chatLabel10.setBackground(new java.awt.Color(128, 190, 183));
        chatLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chatLabel10.setForeground(new java.awt.Color(255, 255, 255));
        chatLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chatLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-setting-30.png"))); // NOI18N
        chatLabel10.setText("Others");
        chatLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatLabel10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                otherScreenMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(128, 190, 183));

        chatLabel11.setBackground(new java.awt.Color(128, 190, 183));
        chatLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chatLabel11.setForeground(new java.awt.Color(255, 255, 255));
        chatLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chatLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Main/icon/icons8-logout-30.png"))); // NOI18N
        chatLabel11.setText("Log out");
        chatLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chatLabel11MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chatLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chatLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chatLabel3MouseClicked

    private void homeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMousePressed
        // TODO add your handling code here:
                dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new homeScreen().setVisible(true);
            }
        });
    }//GEN-LAST:event_homeMousePressed

    private void chatLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatLabel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chatLabel7MouseClicked

    private void chatboxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatboxMousePressed
        // TODO add your handling code here:
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chatbox().setVisible(true);
            }
        });
    }//GEN-LAST:event_chatboxMousePressed

    private void chatLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chatLabel8MouseClicked

    private void groupchatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupchatMousePressed
        // TODO add your handling code here:
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new groupchat().setVisible(true);
            }
        });
    }//GEN-LAST:event_groupchatMousePressed

    private void chatLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatLabel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chatLabel9MouseClicked

    private void chatLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatLabel9MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_chatLabel9MousePressed

    private void chatLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatLabel10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chatLabel10MouseClicked

    private void otherScreenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_otherScreenMousePressed
        // TODO add your handling code here:
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new otherScreen().setVisible(true);
            }
        });
    }//GEN-LAST:event_otherScreenMousePressed

    private void chatLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chatLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chatLabel11MouseClicked

    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
        // TODO add your handling code here:
        dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }//GEN-LAST:event_logoutMousePressed

    private void onlyFriendMousePress(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onlyFriendMousePress
        ArrayList<Friend> listFriend = friendController.apiFriendListOnline();
        DefaultTableModel model = (DefaultTableModel) friendListTable.getModel();
        model.setRowCount(0);
        int i = 0;
        for (Friend friend : listFriend) {
            ++i;
            Object[] rowData = {i, friend.getUsername(), friend.getFullname()};
            model.addRow(rowData);
        }
    }//GEN-LAST:event_onlyFriendMousePress

    private void jButton2onlyFriendMousePress(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2onlyFriendMousePress
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2onlyFriendMousePress

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    void setColor(JPanel label) {
        label.setBackground(new Color(128, 161, 183));
    }

    void resetColor(JPanel label) {
        label.setBackground(new Color(128, 190, 183));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new friendScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel chatLabel10;
    private javax.swing.JLabel chatLabel11;
    private javax.swing.JLabel chatLabel3;
    private javax.swing.JLabel chatLabel7;
    private javax.swing.JLabel chatLabel8;
    private javax.swing.JLabel chatLabel9;
    public javax.swing.JTable friendListTable;
    private javax.swing.JPanel home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}