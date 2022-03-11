package lt.vln.aj.wl.idle;

import java.time.LocalDateTime;

public class IdleObject {

    public int durationInSeconds;
    public LocalDateTime startTime;
    public final int slot;


    public IdleObject(int slot) throws Exception {
        if ((slot <= 0) || (slot > 8)) {
            throw new Exception("Slot number not valid: " + slot);
        }
        this.slot = slot;
    }
}
