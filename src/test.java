import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class test{
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
            FileOutputStream fos = new FileOutputStream("nuser.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Nuser nuser1;
            String password;
            for (int i = 0; i < 3; i++) {
                password = MD5("nuser" + i);
                nuser1 = new Nuser("null" + i, password, "nuser", "null", "null");
                oos.writeObject(nuser1);
            }
            oos.close();
            FileInputStream fis = new FileInputStream("nuser.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Nuser> nuser2 = new ArrayList<Nuser>();
            while(fis.available() != 0){
                nuser1 = (Nuser) ois.readObject();
                nuser2.add(nuser1);
            }
            ois.close();
            for(int i = 0; i < nuser2.size(); i++){
                System.out.println(nuser2.get(i).username + " " + nuser2.get(i).password);
            }
        }catch(IOException e){
            System.out.println("Error: IOException");
        }catch(ClassNotFoundException e){
            System.out.println("Error: ClassNotFoundException");
        }
    }
}
