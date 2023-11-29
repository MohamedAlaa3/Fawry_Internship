package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Log {
    //use log file to record the status of the system
    private static Log obj = new Log();
    private static PrintWriter writer;
private Log(){}
private static Log log = new Log();
public static Log getLogFile(){
    if (obj == null)
    {

        // To make thread safe
        synchronized (Log.class)
        {
            // check again as multiple threads
            // can reach above step
            if (obj==null) {
                obj = new Log();
                try {
                    writer = new PrintWriter(new FileWriter("log.txt", true));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
    return obj;
}
public void write(String logInfo){
        System.out.println("Write log to file: " + logInfo);
        writer.println(logInfo);
        writer.flush();
    }

}
