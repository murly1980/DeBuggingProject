/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.quiz;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.DefaultTableModel;
//import static project.quiz.SearchTableIF.questionTable;

/**
 *
 * @author anuja
 */
public class SearchQuestionIF extends javax.swing.JInternalFrame {

    /**
     * Creates new form SearchQuestionIF
     */
    Connection con=null;
    Statement stmt=null;
    DefaultTableModel defaultTableModel;
    public SearchQuestionIF() {
        initComponents();
        setClosable(true);
       setMaximizable(true);
       setResizable(true);
       setIconifiable(true);
       setVisible(true);
       
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questnDescriptionFld = new javax.swing.JTextField();
        questnDescriptionLabel = new javax.swing.JLabel();
        option1Label = new javax.swing.JLabel();
        option2Label = new javax.swing.JLabel();
        option3Label = new javax.swing.JLabel();
        option4Label = new javax.swing.JLabel();
        option1Fld = new javax.swing.JTextField();
        option2Fld = new javax.swing.JTextField();
        option3Fld = new javax.swing.JTextField();
        questnIDLabel = new javax.swing.JLabel();
        option4Fld = new javax.swing.JTextField();
        questnIDFld = new javax.swing.JTextField();
        closeBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questnDescriptionArea = new javax.swing.JTextArea();

        questnDescriptionLabel.setText("Questn. Description");

        option1Label.setText("Option 1");

        option2Label.setText("Option 2");

        option3Label.setText("Option 3");

        option4Label.setText("Option 4");

        option2Fld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2FldActionPerformed(evt);
            }
        });

        option3Fld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3FldActionPerformed(evt);
            }
        });

        questnIDLabel.setText("Question ID");

        closeBtn.setText("CLOSE");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        searchBtn.setText("SEARCH");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("SEARCH");

        questnDescriptionArea.setColumns(20);
        questnDescriptionArea.setRows(5);
        jScrollPane1.setViewportView(questnDescriptionArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(option1Label)
                            .addComponent(option2Label)
                            .addComponent(option3Label)
                            .addComponent(option4Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(option3Fld, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(option2Fld)
                                .addComponent(option1Fld))
                            .addComponent(option4Fld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(closeBtn)
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(questnDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(questnIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(questnIDFld)
                                    .addComponent(jScrollPane1))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(questnIDFld, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(questnIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(questnDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(option1Label)
                        .addGap(18, 18, 18)
                        .addComponent(option2Label)
                        .addGap(18, 18, 18)
                        .addComponent(option3Label)
                        .addGap(32, 32, 32)
                        .addComponent(option4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(option1Fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(option2Fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(option3Fld, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(option4Fld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(closeBtn)))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
    this.dispose();
        Question question=new Question();
      if(!questnIDFld.getText().trim().isEmpty()){
          question.setQuestionId(Integer.parseInt(questnIDFld.getText()));
      }
        
        
        question.setQuestion(questnDescriptionArea.getText());
       
        question.setOption1(option1Fld.getText());
         
        question.setOption2(option2Fld.getText());
         
        question.setOption3(option3Fld.getText());
        //System.out.println(opt3);
      
        question.setOption4(option4Fld.getText());
        List<Question> questions= QuestionService.searchQuestion(question);
        
       
        SearchTableIF table=new SearchTableIF(questions);
        
        BlankDesktopPane.desktopPane.add(table);
       
        
        
       
        
    }//GEN-LAST:event_searchBtnActionPerformed

    private void option3FldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3FldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option3FldActionPerformed

    private void option2FldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2FldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option2FldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField option1Fld;
    private javax.swing.JLabel option1Label;
    public javax.swing.JTextField option2Fld;
    private javax.swing.JLabel option2Label;
    public javax.swing.JTextField option3Fld;
    private javax.swing.JLabel option3Label;
    public javax.swing.JTextField option4Fld;
    private javax.swing.JLabel option4Label;
    public javax.swing.JTextArea questnDescriptionArea;
    private javax.swing.JTextField questnDescriptionFld;
    private javax.swing.JLabel questnDescriptionLabel;
    public javax.swing.JTextField questnIDFld;
    private javax.swing.JLabel questnIDLabel;
    private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
