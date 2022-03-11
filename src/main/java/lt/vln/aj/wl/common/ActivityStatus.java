package lt.vln.aj.wl.common;

import lt.vln.aj.wl.gui.MyJFrame;
import lt.vln.aj.wl.gui.ValuesForGui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityStatus {
    static boolean isActive = true;
    public static int workSeconds = 0;
    public static int idleSeconds = 0;

    public static void setActive(int sessionId) throws IOException {
        isActive = true;
//        write("onMachineUnlocked: " + sessionId);
//        System.out.println("onMachineUnlocked: " + sessionId);
    }

    public static void setIdle(int sessionId) throws IOException {
        isActive = false;
//        write("onMachineLocked: " + sessionId);
//        System.out.println("onMachineLocked: " + sessionId);
    }

    static void write(String s) throws IOException {
        Writer bufferedWriter;
        bufferedWriter = new BufferedWriter(new FileWriter("log.txt", true));
        ((BufferedWriter) bufferedWriter).newLine();
        bufferedWriter.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")) + " " + s);
        bufferedWriter.close();
    }


    public static void updateValuesForGui() {
        MyJFrame frame = MyJFrame.getInstance();
        int worHours = workSeconds / 3600;
        int worMinutes = (workSeconds - worHours * 3600) / 60;
        int worSeconds = workSeconds % 60;
        int idlHours = idleSeconds / 3600;
        int idlMinutes = (idleSeconds - idlHours * 3600) / 60;
        int idlSeconds = idleSeconds % 60;
        ValuesForGui.output = String.format("<html>Active: %d:%02d:%02d<br/>Idle: %d:%02d:%02d</html>", worHours, worMinutes, worSeconds, idlHours, idlMinutes, idlSeconds);
        String text;
        if (isActive) {
            text = "HARD WORK IN PROGRESS";
        } else {
            text = "PROCRASTINATING";
        }
        frame.setTitle(text);
        ValuesForGui.status = "<html><div style='text-align: center;'>" + text + "</div></html>";
    }
}
