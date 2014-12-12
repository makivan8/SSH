//package updatelog;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import static java.util.concurrent.TimeUnit.SECONDS;

public class UpdateLog {
    
    static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(15); // no
    static ScheduledFuture<?> t;
    
    public static void main(String[] args) {
        try{
            t = executor.scheduleAtFixedRate(new RunCode(), 0, 1, SECONDS);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
