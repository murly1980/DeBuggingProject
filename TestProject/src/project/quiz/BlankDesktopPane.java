/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.quiz;

import java.io.File;

/**
 *
 * @author anuja
 */
public class BlankDesktopPane extends javax.swing.JFrame {

    /**
     * Creates new form AdminBlankBlank
     */
    File file;
    String name;

    public BlankDesktopPane() {
        initComponents();
        //chooseFile.setClosable(true);
        // chooseFile.setResizable(true);
        //chooseFile.setMaximizable(true);
        //chooseFile.setIconifiable(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        quizMenu = new javax.swing.JMenu();
        addMenuItem = new javax.swing.JMenuItem();
        editMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        searchMenuItem = new javax.swing.JMenuItem();
        uploadMenuItem = new javax.swing.JMenuItem();
        closeMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );

        quizMenu.setText("Quiz");
        quizMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizMenuActionPerformed(evt);
            }
        });

        addMenuItem.setText("Add");
        addMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMenuItemMouseClicked(evt);
            }
        });
        addMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenuItemActionPerformed(evt);
            }
        });
        quizMenu.add(addMenuItem);

        editMenuItem.setText("Edit");
        editMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuItemActionPerformed(evt);
            }
        });
        quizMenu.add(editMenuItem);

        deleteMenuItem.setText("Delete");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        quizMenu.add(deleteMenuItem);

        searchMenuItem.setText("Search");
        searchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMenuItemActionPerformed(evt);
            }
        });
        quizMenu.add(searchMenuItem);

        uploadMenuItem.setText("Upload");
        uploadMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadMenuItemActionPerformed(evt);
            }
        });
        quizMenu.add(uploadMenuItem);

        closeMenuItem.setText("Close");
        closeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeMenuItemActionPerformed(evt);
            }
        });
        quizMenu.add(closeMenuItem);

        menuBar.add(quizMenu);
        menuBar.add(jMenu2);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMenuItemMouseClicked

    }//GEN-LAST:event_addMenuItemMouseClicked

    private void addMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenuItemActionPerformed
        desktopPane.removeAll();
        desktopPane.updateUI();
        //SearchQuestionIF search=new SearchQuestionIF();
     //SearchQuestionIFdispose();
      // search.setVisible(false);
       //search.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AddQuestionInternalFrame addQuestionInternalFrame = new AddQuestionInternalFrame();
        // BlankDesktopPane admin=new BlankDesktopPane();
        desktopPane.add(addQuestionInternalFrame);
        addQuestionInternalFrame.setVisible(true);
        addQuestionInternalFrame.show();
        addQuestionInternalFrame.setResizable(true);
        addQuestionInternalFrame.setMaximizable(true);
        addQuestionInternalFrame.setIconifiable(true);
        //addQuestionInternalFrame.setLocation(100, 50);
        addQuestionInternalFrame.setClosable(true);
        

    }//GEN-LAST:event_addMenuItemActionPerformed

    private void editMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuItemActionPerformed
        desktopPane.removeAll();
        desktopPane.updateUI();
        SearchQuestionIF edit = new SearchQuestionIF();
        // BlankDesktopPane pane=new BlankDesktopPane();
        desktopPane.add(edit);
        edit.setVisible(true);
        edit.setClosable(true);
        edit.setIconifiable(true);
        edit.setMaximizable(true);
        edit.setResizable(true);
    }//GEN-LAST:event_editMenuItemActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
        desktopPane.removeAll();
        desktopPane.updateUI();
        SearchQuestionIF delete = new SearchQuestionIF();
        //BlankDesktopPane pane=new BlankDesktopPane();
        desktopPane.add(delete);

        delete.show();
        delete.setClosable(true);
        delete.setResizable(true);
        delete.setMaximizable(true);
        delete.setIconifiable(true);
    }//GEN-LAST:event_deleteMenuItemActionPerformed

    private void searchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMenuItemActionPerformed
        desktopPane.removeAll();
        desktopPane.updateUI();
        //BlankDesktopPane admin=new BlankDesktopPane();
        SearchQuestionIF search = new SearchQuestionIF();
        desktopPane.add(search);
        search.show();
        search.setClosable(true);
        search.setMaximizable(true);
        search.setIconifiable(true);
        search.setResizable(true);
    }//GEN-LAST:event_searchMenuItemActionPerformed

    private void uploadMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadMenuItemActionPerformed
        desktopPane.removeAll();
        desktopPane.updateUI();
        UploadIF upload = new UploadIF();
        desktopPane.add(upload);
        upload.setVisible(true);
        upload.setClosable(true);
        upload.setMaximizable(true);
        upload.show();
        upload.setIconifiable(true);
        upload.setResizable(true);
        upload.setLocation(100, 100);
    }//GEN-LAST:event_uploadMenuItemActionPerformed

    private void quizMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizMenuActionPerformed
        // chooseFile.setVisible(true);
        //chooseFile.show();
    }//GEN-LAST:event_quizMenuActionPerformed

    private void closeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeMenuItemActionPerformed
        //BlankDesktopPane pane=new BlankDesktopPane();
        this.dispose();
        // pane.setVisible(false);
    }//GEN-LAST:event_closeMenuItemActionPerformed
    public void editdeletesearchupdate() {
     //  SearchQuestionFrame search=new SearchQuestionFrame();
        //  search.setVisible(true);

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
            java.util.logging.Logger.getLogger(BlankDesktopPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlankDesktopPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlankDesktopPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlankDesktopPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlankDesktopPane().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JMenuItem addMenuItem;
    private javax.swing.JMenuItem closeMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem editMenuItem;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu quizMenu;
    private javax.swing.JMenuItem searchMenuItem;
    private javax.swing.JMenuItem uploadMenuItem;
    // End of variables declaration//GEN-END:variables
}