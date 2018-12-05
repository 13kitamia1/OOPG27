import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Login extends JFrame implements ActionListener {
    JButton blogin = new JButton("Login");
    JButton bexit = new JButton("Exit");
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JLabel lusername = new JLabel("Username:");
    JLabel lpassword = new JLabel("Password:");
    public Login(){
        String[] acctype = {"Normal User", "Privileged User", "Admin"};
        String sacc = (String) JOptionPane.showInputDialog(null, "Type of user?", "User Select", JOptionPane.QUESTION_MESSAGE, null, acctype, acctype[0]);
        setLayout(null);
        setTitle("Please Login");
        setPreferredSize(new Dimension(500, 300));
        setResizable(false);
        lusername.setBounds(10, 10, 75, 20);
        lpassword.setBounds(10, 30, 75, 20);
        username.setBounds(100, 10, 200, 20);
        password.setBounds(100, 30, 200, 20);
        blogin.setBounds(160, 55, 65, 20);
        bexit.setBounds(235, 55, 65, 20);
        if(sacc.compareTo(acctype[0]) == 0){
            blogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(verify("nuser.csv") != null){
                        JOptionPane.showMessageDialog(null, "Login Success!");
                        username.setText(null);
                        password.setText(null);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Username and/or Password!");
                        username.setText(null);
                        password.setText(null);
                    }
                }
            });
            bexit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(JOptionPane.showConfirmDialog(null, "Exit Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_CANCEL_OPTION){
                        System.exit(0);
                    }
                    System.exit(0);
                }
            });
            add(lusername);
            add(username);
            add(lpassword);
            add(password);
            add(blogin);
            add(bexit);
            this.setVisible(true);
            this.setSize(350, 175);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }else if(sacc.compareTo(acctype[1]) == 0){
            blogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(verify("nuser.csv") != null){
                        JOptionPane.showMessageDialog(null, "Login Success!");
                        username.setText(null);
                        password.setText(null);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Username and/or Password!");
                        username.setText(null);
                        password.setText(null);
                    }
                }
            });
            bexit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(JOptionPane.showConfirmDialog(null, "Exit Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_CANCEL_OPTION){
                        System.exit(0);
                    }
                    System.exit(0);
                }
            });
            add(lusername);
            add(username);
            add(lpassword);
            add(password);
            add(blogin);
            add(bexit);
            this.setVisible(true);
            this.setSize(350, 175);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

        }else{
            blogin.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(verify2("admin.csv")!= null){
                        JOptionPane.showMessageDialog(null, "Login Success!");
                        username.setText(null);
                        password.setText(null);
                        AdminPane.main(null);
                    }else{
                        JOptionPane.showMessageDialog(null, "Incorrect Username and/or Password!");
                        username.setText(null);
                        password.setText(null);
                    }
                }
            });
            bexit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(JOptionPane.showConfirmDialog(null, "Exit Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_CANCEL_OPTION){
                        System.exit(0);
                    }
                    System.exit(0);
                }
            });
            add(lusername);
            add(username);
            add(lpassword);
            add(password);
            add(blogin);
            add(bexit);
            this.setVisible(true);
            this.setSize(350, 175);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

        }

    }

    Nuser verify(String csv){
        try{
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line;
            ArrayList<Nuser> nuser2 = new ArrayList<Nuser>();
            while((line = br.readLine()) != null){
                String[] lines = line.split(",");
                nuser2.add(new Nuser(lines[0], lines[1], lines[2], lines[3], lines[4]));
            }
            br.close();
            String input = username.getText();
            String pinput = new String(password.getPassword());
            pinput = MD5(pinput);
            int i = 0;
            for(i = 0; i < nuser2.size(); i++){
                if(input.equals(nuser2.get(i).username)){
                    if(pinput.equals(nuser2.get(i).password)){
                        return nuser2.get(i);
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Error: IOException");
        }
        return null;
    }

    Suser verify2(String csv){
        try{
            BufferedReader br = new BufferedReader(new FileReader(csv));
            String line;
            ArrayList<Suser> nuser2 = new ArrayList<Suser>();
            while((line = br.readLine()) != null){
                String[] lines = line.split(",");
                nuser2.add(new Suser(lines[0], lines[1], lines[2], lines[3]));
            }
            br.close();
            String input = username.getText();
            String pinput = new String(password.getPassword());
            pinput = MD5(pinput);
            int i = 0;
            for(i = 0; i < nuser2.size(); i++){
                if(input.equals(nuser2.get(i).username)){
                    if(pinput.equals(nuser2.get(i).password)){
                        return nuser2.get(i);
                    }
                }
            }
        }catch(IOException e){
            System.out.println("Error: IOException");
        }
        return null;
    }
    public void actionPerformed(ActionEvent e){

    }
    public static String MD5(String md5){                               //Copied from Lab, sorry;
        if(md5 == null)
            return null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] pbytes = md5.getBytes();
            md.reset();
            byte[] digested = md.digest(pbytes);
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < digested.length; i++)
                sb.append(Integer.toHexString(0xff & digested[i]));
            return sb.toString();
        }catch(NoSuchAlgorithmException e){
            System.out.println("Fail");
        }
        return null;
    }
    public static void main(String[] args) {
        new Login();
    }
}
