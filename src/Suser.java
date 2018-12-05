import java.io.Serializable;

public class Suser implements Serializable {
    public String userid;
    public String password;
    public String username;
    public String time;
    Suser(){
    }
    Suser(String userid, String password, String username, String time){
        this.userid = userid;
        this.password = password;
        this.username = username;
        this.time = time;
    }
}

