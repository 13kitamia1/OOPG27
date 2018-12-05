import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;


class AdminPane implements ActionListener{
	
	JFrame f;
	JButton b1,b2,b3,b4,b5,b6;
	
	public static void main(String[] args){
		new AdminPane();
	}
	
	public AdminPane(){
		f = new JFrame("AdminPane");
		Container cp = f.getContentPane();
		cp.setLayout(new GridLayout(2,0));
		
		b1 = new JButton("Approve Pane");
		b1.setToolTipText("to approve registration");
		b1.addActionListener(this);
		cp.add(b1);
		
		b2 = new JButton("User Record");
		b2.setToolTipText("to check user records");
		b2.addActionListener(this);
		cp.add(b2);
		
		b3 = new JButton("Task Record");
		b3.setToolTipText("to check task records");
		b3.addActionListener(this);
		cp.add(b3);
		
		b4 = new JButton("Logout");
		b4.setToolTipText("to return homepage");
		b4.addActionListener(this);
		cp.add(b4);
		
		b5 = new JButton("Current Balance");
		b5.setToolTipText("check the current balance of all users");
		b5.addActionListener(this);
		cp.add(b5);
		
		b6 = new JButton("Negative Balance Account");
		b6.setToolTipText("check the user accounts with negative balance");
		b6.addActionListener(this);
		cp.add(b6);
		
		f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		/*f.addWindowListener(new WindowAdapter() {					// alert: close application
			public void windowClosing(WindowEvent e) {
				int result=JOptionPane.showConfirmDialog(f,
						   "Exit?",
						   "Warning",
						   JOptionPane.YES_NO_OPTION,
						   JOptionPane.WARNING_MESSAGE);
				if (result==JOptionPane.YES_OPTION) {System.exit(0);}
			}    
		});*/

		f.setSize(800,800);
		f.setVisible(true);	
	}
	
	
	public void actionPerformed(ActionEvent e) {
		File file = new File("C:\\Users\\howard\\Desktop\\oop\\project\\userrecord.txt");
		if(e.getSource()==b1){
			JOptionPane.showMessageDialog(f,
				"You press " + e.getActionCommand(),
				"message",JOptionPane.INFORMATION_MESSAGE);
			new ApprovePane().setVisible(true);
			}
			
			else if(e.getSource()==b2){
				JOptionPane.showMessageDialog(f,
					"You press " + e.getActionCommand(),
					"message",JOptionPane.INFORMATION_MESSAGE);
				new UserRecord().setVisible(true);
				}
				
				else if(e.getSource()==b3){
						JOptionPane.showMessageDialog(f,
							"You press " + e.getActionCommand(), 
							"message",JOptionPane.INFORMATION_MESSAGE);
						new TaskRecord().setVisible(true);
						}
						
						else if(e.getSource()==b4){
							JOptionPane.showMessageDialog(f,
								"You press "+e.getActionCommand(),
								"message",JOptionPane.INFORMATION_MESSAGE);  
							//back to login frame
							f.dispose();
							}
							
							else if(e.getSource()==b5){
									int accumulated = 0;
									try{
										BufferedReader br = new BufferedReader(new FileReader(file));
										Object[] tableLines = br.lines().toArray();
										for(int i = 0; i < tableLines.length; i++) {
											String line = tableLines[i].toString().trim();
											String[] dataRow = line.split(","); 
											accumulated = accumulated + Integer.valueOf((String) dataRow[4]);	
											}
											br.close();
										}
										catch(Exception ex){
											System.out.print("error");
										};
										JOptionPane.showMessageDialog(f,
											"The current balance of all users is "+accumulated,
											"message",JOptionPane.INFORMATION_MESSAGE);
										}
										
										else if(e.getSource()==b6){
												int j = 0;
												String negbal[][] = new String[10][]; //array for storing records with negative balance
												try{
													BufferedReader br = new BufferedReader(new FileReader(file));
													Object[] tableLines = br.lines().toArray();
													for(int i = 0; i < tableLines.length; i++){
														String line = tableLines[i].toString().trim();
														String[] dataRow = line.split(",");
														if(Integer.valueOf(dataRow[4]).compareTo(0)==-1){
															negbal[j] = dataRow;
															j++;
														}
													}
													br.close();
													String negativebal[][] = new String[j][];
													for(int a=0;a<j;a++)
														negativebal[a] = negbal[a]; 
													JOptionPane.showMessageDialog(f,
														"The records with negative balance are "+Arrays.deepToString(negativebal),
														"message",JOptionPane.INFORMATION_MESSAGE);													
												}catch(Exception ex){
													System.out.print("error");
												};

										}
									
    }
}





