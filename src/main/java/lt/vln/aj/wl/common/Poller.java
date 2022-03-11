package lt.vln.aj.wl.common;

import lt.vln.aj.wl.gui.ValuesForGui;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Poller implements Runnable {

    private int i = 0;

    public Poller() {
    }

    @Override
    public void run() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (ActivityStatus.isActive) {
                    ActivityStatus.workSeconds = ActivityStatus.workSeconds + 1;
                } else {
                    ActivityStatus.idleSeconds = ActivityStatus.idleSeconds + 1;
                }
                ActivityStatus.updateValuesForGui();
                i++;
                if (i % 60 == 0) {
                    i = 0;
                    try {
                        ActivityStatus.write(ValuesForGui.output
                                .replace("<html>", "")
                                .replace("<br/>", " ")
                                .replace("</html>", ".")
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Timer timer = new Timer();
        long delay = 0;
        long intervalPeriod = 1000;

        timer.scheduleAtFixedRate(task, delay, intervalPeriod);
    }
}
