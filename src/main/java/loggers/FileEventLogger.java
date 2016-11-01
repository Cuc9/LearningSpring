package loggers;

import beans.Event;
import org.apache.commons.io.FileUtils;
import sun.text.normalizer.UTF16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by arpi on 01.11.2016.
 */
public class FileEventLogger implements IEventLogger {
    //private String fileName;
    private File logFile;
    boolean append;

    public FileEventLogger(File logFile) {
        //this.fileName = fileName;
        this.logFile = logFile;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(logFile,event.toString(),"UTF-8",append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
