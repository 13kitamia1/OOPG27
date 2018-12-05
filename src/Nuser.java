import java.io.Serializable;

public class Nuser extends Suser implements Serializable {
    String balance;
    Nuser(String userid, String password, String username, String time, String balance){
        this.userid = userid;
        this.password = password;
        this.username = username;
        this.time = time;
        this.balance = balance;
    }
}
