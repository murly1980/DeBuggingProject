/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.quiz;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UploadIF extends javax.swing.JInternalFrame {

  File file;
     String name;
    public UploadIF() {
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

        uploadLabel2 = new javax.swing.JLabel();
        filePathFld = new javax.swing.JTextField();
        uploadBtn2 = new javax.swing.JButton();
        chooseBtn2 = new javax.swing.JButton();

        uploadLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        uploadLabel2.setText("Upload .csv or .json file");

        uploadBtn2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        uploadBtn2.setText("UPLOAD");
        uploadBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtn2ActionPerformed(evt);
            }
        });

        chooseBtn2.setText("...");
        chooseBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(uploadLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(uploadBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(filePathFld, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chooseBtn2)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(uploadLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePathFld)
                    .addComponent(chooseBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(uploadBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtn2ActionPerformed
      
        if(filePathFld.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(this,"NO FILE SELECTED");
           
        }
       else if(name.endsWith(".csv"))
        {
            QuestionService service=new QuestionService();
            service.readCsvFile();
            
            JOptionPane.showMessageDialog(this,"Successfully added in database.");
          
        }
        else if(name.endsWith(".json"))
        {
            
            QuestionService service=new QuestionService();
            service.readJsonFile();
   
            JOptionPane.showMessageDialog(this,"Successfully Added in Database");
        }
       
  
        else{
           JOptionPane.showMessageDialog(this,"Only .csv and .json files are allowed.");
         
        }
         filePathFld.setText("");
          
    }//GEN-LAST:event_uploadBtn2ActionPerformed

    private void chooseBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseBtn2ActionPerformed
        FileNameExtensionFilter fnef=new FileNameExtensionFilter("csv","json");
        JFileChooser chooser=new JFileChooser();
        chooser.addChoosableFileFilter(fnef);
        chooser.showOpenDialog(null);
        file=chooser.getSelectedFile();
        if(file!=null){
            String fileName=file.getAbsolutePath();
            filePathFld.setText(fileName);
            name=file.getName();
        }

    }//GEN-LAST:event_chooseBtn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseBtn2;
    private javax.swing.JTextField filePathFld;
    private javax.swing.JButton uploadBtn2;
    private javax.swing.JLabel uploadLabel2;
    // End of variables declaration//GEN-END:variables
}