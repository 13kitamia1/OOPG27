import javax.swing.*;
import java.io.*;

public class Task{
    String record;
    String uid;
    String time;
    String descrip;
    String fee;
    String cb;
    public void write(Task task){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("task.csv", true));
            String stask = task.record + "," + task.uid + "," + task.time + "," + task.descrip + "," + task.fee;
            bw.write(stask);
            bw.close();
        }catch(IOException e){

        }
    }
    String charged(String f, String cb){
        int fee, balance;
        String Cb;
        fee = Integer.parseInt(f);
        balance = Integer.parseInt(cb);
        if(balance > fee){
            Cb = String.valueOf(balance - fee);
            write(this);
            return Cb;
        }else{
            JOptionPane.showMessageDialog(null, "Not enough money, ask mommy 4 moor");
            return cb;
        }

    }
    Task(String uid, String time, String descrip, String fee, String cb) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("task"));
            String record, line;
            record = "0";
            while((line = br.readLine()) != null){
                String[] lines = line.split(",");
                this.uid = lines[0];
            }
            if(record == null)
                record = "0";
        }catch(IOException e){

        }
        this.record = record;
        this.uid = uid;
        this.time = time;
        this.descrip = descrip;
        this.fee = fee;
        this.cb = charged(fee, cb);
    }
}
