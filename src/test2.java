import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class test2{
    public static String MD5(String md5){
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
        try {
            PrintWriter pw = new PrintWriter("nuser.csv");
            String sb;
            String password;
            int j = 0;
            for(int i = 0; i < 2; i++) {
                password = MD5("c");
                sb = "c" + (i + 1) + ',' + password + '\n';
                pw.write(sb);
            }
            pw.close();
            BufferedReader br = new BufferedReader(new FileReader("admin.csv"));
            String line;
            ArrayList<Nuser> nuser2 = new ArrayList<Nuser>();
            while((line = br.readLine()) != null){
                String[] lines = line.split(",");
                nuser2.add(new Nuser(lines[0], lines[1], lines[2], lines[3], lines[4]));
            }
            br.close();
        }catch(IOException e){
            System.out.println("Error: IOException");
        }
    }
}
