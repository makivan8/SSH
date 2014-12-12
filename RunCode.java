//package updatelog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RunCode implements Runnable {
    private String ip;
    
    public void run(){
        try{
            File file = new File("auth2.log");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            writer.write("Nov  6 06:51:54 wala sshd[56583]: error: PAM: authentication error for illegal user support from 91.220.131.33");
            writer.write("\n");
            writer.write("Nov  6 09:40:32 wala sshd[52684]: error: PAM: authentication error for illegal user support from 193.104.41.55");
            writer.write("\n");
            writer.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
