import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.nio.*;
import java.nio.file.Files.*;



public class ApprovePane extends javax.swing.JFrame {

	String filePath = "C:\\Users\\howard\\Desktop\\oop\\project\\approve.txt";
    File file = new File(filePath);

    public ApprovePane() {
        initComponents();
    }

	public void delete(){  
		try { 
			BufferedWriter bw = new BufferedWriter( 
			new FileWriter("ctext.txt"));
			PrintWriter pw = new PrintWriter(bw);
			for (int c_row = 0; c_row < jTable1.getRowCount(); c_row++){
				pw.println(jTable1.getValueAt(c_row,0)+","+jTable1.getValueAt(c_row,1)+","+jTable1.getValueAt(c_row,2)
							+","+jTable1.getValueAt(c_row,3)+","+jTable1.getValueAt(c_row,4));
				}
				bw.close();
				pw.close();
				if(file.exists()) file.delete();  
				new File("ctext.txt").renameTo(file);	
			} 
			catch (Exception ex) { 
				System.out.println("Exception Occurred" + ex); 
			} 				
	}
	
    @SuppressWarnings("unchecked")                      
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        approve = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Approve Pane");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Encrypted Password", "Name", "Time Created", "Current Balance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        approve.setText("Approve");

        delete.setText("Remove");

        close.setText("Close");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(approve, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approve)
                    .addComponent(delete)
                    .addComponent(close))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

		//get the file and display the record in jtable
		DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
		try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split(","); 
                model.insertRow(i,dataRow);
				
            }
			br.close();
        }catch (Exception ex) {
           System.out.print("error");
        }
		
		//Approve
		approve.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				File userrecord = new File ("C:\\Users\\howard\\Desktop\\oop\\project\\userrecord.txt");
				int i = jTable1.getSelectedRow();
				Object[] row = new Object[5];
				for(int j=0;j<row.length;j++)
					row[j] = model.getValueAt(i, j).toString();	
				model.removeRow(i);			
				try{
					BufferedWriter bw = new BufferedWriter(new FileWriter(userrecord,true));
					PrintWriter pw = new PrintWriter(bw);
					pw.println(row[0]+","+row[1]+","+row[2]+","+row[3]+","+row[4]); 
					pw.close();
					bw.close();  
					delete();
				}catch(Exception ex){
					System.out.print("Error");
				}
			}
		});
		
		//delete
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int i = jTable1.getSelectedRow();
				model.removeRow(i);
				delete();
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
            java.util.logging.Logger.getLogger(ApprovePane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApprovePane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApprovePane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApprovePane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApprovePane().setVisible(true);
            }
        });
    }
                   
    private javax.swing.JButton approve;
    private javax.swing.JButton delete;
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;               
}
