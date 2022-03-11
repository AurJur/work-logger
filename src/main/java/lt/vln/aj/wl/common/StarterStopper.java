package lt.vln.aj.wl.common;

import lt.vln.aj.wl.idle.IdleManagerSingl;
import lt.vln.aj.wl.idle.LastIdleManager;

import java.io.IOException;
import java.time.LocalDateTime;

public class StarterStopper {

    private static boolean breakStarted = false;

    public void startBreak(int sessionId) throws IOException {
        if (sessionId == 999) {
            ActivityStatus.write("Start break button pressed.");
            System.out.println("Start break button pressed.");
        } else {
            ActivityStatus.write("PC locked.");
            System.out.println("PC locked.");
        }
        if (!breakStarted) {
            breakStarted = true;
            ActivityStatus.setIdle(sessionId);
            LastIdleManager.setLastLockTime(LocalDateTime.now());
        } else {
            ActivityStatus.write("Break has already been started.");
            System.out.println("Break has already been started.");
        }
    }

    public void stopBreak(int sessionId) throws IOException {
        if (sessionId == 999) {
            ActivityStatus.write("Stop break button pressed.");
            System.out.println("Stop break button pressed.");
        } else {
            ActivityStatus.write("PC unlocked.");
            System.out.println("PC unlocked.");
        }
        if (breakStarted) {
            breakStarted = false;
            ActivityStatus.setActive(sessionId);
            LastIdleManager.setLastUnlockTime(LocalDateTime.now());
            LastIdleManager.calculateDiff();
            IdleManagerSingl.getInstance().addIdleToSlot(LastIdleManager.lastLockTime, Math.round((LastIdleManager.diff.toMillis()) / 1000));
            LastIdleManager.reset();
        } else {
            ActivityStatus.write("Break has already been stopped.");
            System.out.println("Break has already been stopped.");
        }
    }

}
