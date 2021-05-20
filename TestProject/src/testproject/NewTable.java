/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anuja
 */
public class NewTable {
    public static void main(String args[])
    {
           DefaultTableModel tableModel = new DefaultTableModel();
      JTable table = new JTable(tableModel);
      tableModel.addColumn("Languages");
      tableModel.insertRow(0, new Object[] { "CSS" });
      tableModel.insertRow(0, new Object[] { "HTML5" });
      tableModel.insertRow(0, new Object[] { "JavaScript" });
      tableModel.insertRow(0, new Object[] { "jQuery" });
      tableModel.insertRow(0, new Object[] { "AngularJS" });
      // adding a new row
      tableModel.insertRow(tableModel.getRowCount(), new Object[] { "ExpressJS" });
      JFrame f = new JFrame();
      f.setSize(550, 350);
      f.add(new JScrollPane(table));
      f.setVisible(true);
    }
}
