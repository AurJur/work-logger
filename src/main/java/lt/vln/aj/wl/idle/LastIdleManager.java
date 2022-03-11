package lt.vln.aj.wl.idle;

import java.time.Duration;
import java.time.LocalDateTime;

public class LastIdleManager {

    public static LocalDateTime lastLockTime;
    static LocalDateTime lastUnlockTime;
    public static Duration diff;

    public static void setLastLockTime(LocalDateTime time) {
        lastLockTime = time;
    }

    public static void setLastUnlockTime(LocalDateTime time) {
        lastUnlockTime = time;
    }

    public static void calculateDiff (){
        diff = Duration.between(lastLockTime, lastUnlockTime);
    }

    public static void reset() {
        lastLockTime = null;
        lastUnlockTime = null;
        diff = null;
    }
}