import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.nio.*;
import java.nio.file.Files.*;

/**
 *
 * @author howard
 */
public class UserRecord extends javax.swing.JFrame {

    public UserRecord() {
        initComponents();
    }

    @SuppressWarnings("unchecked")                       
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UserID = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        Current_Balance = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        close = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UserID.setText("User ID");

        Password.setText("Encrypted Password");

        Name.setText("Name");

        Time.setText("Time Created");

        Current_Balance.setText("Current Balance");


        add.setText("Add");

        update.setText("Update");

        delete.setText("Delete");

        clear.setText("Clear");

        close.setText("Close");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UserID)
                    .addComponent(Password)
                    .addComponent(Name)
                    .addComponent(Time)
                    .addComponent(Current_Balance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jTextField1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserID)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Password)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(update)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(delete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Time)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clear)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Current_Balance)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(close))))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Encrypted Password", "Name", "Time Created", "Current Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setText("User Record Pane");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel6))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

		
		//get the file and display the record in jtable
		String filePath = "C:\\Users\\howard\\Desktop\\oop\\project\\userrecord.txt";
        File file = new File(filePath);
		
		DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
		try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(","); 
                model.insertRow(i,dataRow);
            }
			br.close();
        } catch (Exception ex) {
           System.out.print("error");
        }
	
		//display selected row 
		jTable1.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
            int i = jTable1.getSelectedRow();
            jTextField1.setText(model.getValueAt(i, 0).toString());
            jTextField2.setText(model.getValueAt(i, 1).toString());
            jTextField3.setText(model.getValueAt(i, 2).toString());
            jTextField4.setText(model.getValueAt(i, 3).toString());
			jTextField5.setText(model.getValueAt(i, 4).toString());
        }});
		
		
		//Add Button Function
		Object[] row = new Object[5];
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				row[0] = jTextField1.getText();
                row[1] = jTextField2.getText();
                row[2] = jTextField3.getText();
                row[3] = jTextField4.getText();
				row[4] = jTextField5.getText();
				model.addRow(row);
				try { 
					BufferedWriter bw = new BufferedWriter( 
								  new FileWriter(file,true));
					PrintWriter pw = new PrintWriter(bw);
					pw.println(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[4]); 
					bw.close(); 
					pw.close();
				} 
				catch (IOException ex) { 
					System.out.println("Exception Occurred" + ex); 
				} 				
			}
		});
		
		//Update Button Function
        update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int i = jTable1.getSelectedRow();
                model.setValueAt(jTextField1.getText(), i, 0);
                model.setValueAt(jTextField2.getText(), i, 1);
                model.setValueAt(jTextField3.getText(), i, 2);
                model.setValueAt(jTextField4.getText(), i, 3);
				model.setValueAt(jTextField5.getText(), i, 4);
				
				BufferedReader br = null;
				PrintWriter pw = null;

				try{
					 br = new BufferedReader(new FileReader(file));
					 pw = new PrintWriter(new FileWriter("ctext.txt"));
					 String temp;
					 int j=0;
					 Object[] row = new Object[5];
					 row[0] = jTextField1.getText();
					 row[1] = jTextField2.getText();
					 row[2] = jTextField3.getText();
					 row[3] = jTextField4.getText();
					 row[4] = jTextField5.getText();
					 while((temp = br.readLine()) != null){
						if(i==j) pw.println(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[4]);
					    else pw.println(temp);
						j++;
						pw.flush();
					 }				   
					br.close();
					pw.close();
					if(file.exists()) file.delete();  
					new File("ctext.txt").renameTo(file);
					
					
				}catch(Exception ex){
					   System.out.println("Update Error");
				}
				  
            }
        });
		
		//delete
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int i = jTable1.getSelectedRow();
				model.removeRow(i);
				try { 
					BufferedWriter bw = new BufferedWriter( 
								  new FileWriter("ctext.txt",false));
					PrintWriter pw = new PrintWriter(bw);
					for (int row = 0; row < jTable1.getRowCount(); row++){
						pw.println(jTable1.getValueAt(row,0)+","+jTable1.getValueAt(row,1)+","+jTable1.getValueAt(row,2)
									+","+jTable1.getValueAt(row,3)+","+jTable1.getValueAt(row,4));
					}
					bw.close();
					pw.close();
					if(file.exists()) file.delete();  
					new File("ctext.txt").renameTo(file);
					
				} 
				catch (IOException ex) { 
					System.out.println("Exception Occurred" + ex); 
				} 				
			}
		});

		//clear
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
			}
		});
		
		//close the window
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		
		pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRecord().setVisible(true);
            }
        });
    }
                  
    private javax.swing.JLabel Current_Balance;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel UserID;
    private javax.swing.JButton add;
    private javax.swing.JButton update;
    private javax.swing.JButton delete;
    private javax.swing.JButton clear;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;                
}