package lt.vln.aj.wl.idle;

import lt.vln.aj.wl.common.ActivityStatus;
import lt.vln.aj.wl.gui.ValuesForGui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IdleManagerSingl {

    private IdleObject idleObject01 = new IdleObject(1);
    private IdleObject idleObject02 = new IdleObject(2);
    private IdleObject idleObject03 = new IdleObject(3);
    private IdleObject idleObject04 = new IdleObject(4);
    private IdleObject idleObject05 = new IdleObject(5);
    private IdleObject idleObject06 = new IdleObject(6);
    private IdleObject idleObject07 = new IdleObject(7);
    private IdleObject idleObject08 = new IdleObject(8);

    private static IdleManagerSingl ourInstance;

    static {
        try {
            ourInstance = new IdleManagerSingl();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static IdleManagerSingl getInstance() {
        return ourInstance;
    }

    private IdleManagerSingl() throws Exception {
    }

    public void addIdleToSlot(LocalDateTime startTime, int durationInSeconds) {
        int firstEmptySlot = findFirstEmptySlot();
        if (firstEmptySlot == 9) {
            shiftUp(1);
            firstEmptySlot = 8;
        }
        getIdleObject(firstEmptySlot).startTime = startTime;
        getIdleObject(firstEmptySlot).durationInSeconds = durationInSeconds;
        updateValuesForGui();
    }

    public void cancelIdleViaButton(int slotNumber) {
        shiftUp(slotNumber);
        updateValuesForGui();
    }

    public void addIdleViaButton(int slotNumber) {
        int tempSeconds = getIdleObject(slotNumber).durationInSeconds;
        ActivityStatus.workSeconds = ActivityStatus.workSeconds + tempSeconds;
        ActivityStatus.idleSeconds = ActivityStatus.idleSeconds - tempSeconds;
        shiftUp(slotNumber);
        updateValuesForGui();
    }

    private void shiftUp(int slotNumber) {
        for (int i = slotNumber; i < 8; i++) {
            getIdleObject(i).startTime = getIdleObject(i + 1).startTime;
            getIdleObject(i).durationInSeconds = getIdleObject(i + 1).durationInSeconds;
        }
        getIdleObject(8).startTime = null;
        getIdleObject(8).durationInSeconds = 0;
    }

    private int findFirstEmptySlot() {
        for (int i = 1; i < 9; i++) {
            if (getIdleObject(i).durationInSeconds == 0)
                return i;
        }
        return 9;
    }

    private IdleObject getIdleObject(int slotNumber) {
        switch (slotNumber) {
            case 1:
                return idleObject01;
            case 2:
                return idleObject02;
            case 3:
                return idleObject03;
            case 4:
                return idleObject04;
            case 5:
                return idleObject05;
            case 6:
                return idleObject06;
            case 7:
                return idleObject07;
            case 8:
                return idleObject08;
        }
        return null;
    }

    private void updateValuesForGui() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            float seconds = idleObject01.durationInSeconds;
            ValuesForGui.idle01 = idleObject01.startTime.format(formatter) + " " + Math.round(seconds / 60);
        } catch (Exception e) {
            ValuesForGui.idle01 = "";
        }

        try {
            float seconds = idleObject02.durationInSeconds;
            ValuesForGui.idle02 = idleObject02.startTime.format(formatter) + " " + Math.round(seconds / 60);
        } catch (Exception e) {
            ValuesForGui.idle02 = "";
        }

        try {
            float seconds = idleObject03.durationInSeconds;
            ValuesForGui.idle03 = idleObject03.startTime.format(formatter) + " " + Math.round(seconds / 60);
        } catch (Exception e) {
            ValuesForGui.idle03 = "";
        }

        try {
            float seconds = idleObject04.durationInSeconds;
            ValuesForGui.idle04 = idleObject04.startTime.format(formatter) + " " + Math.round(seconds / 60);
        } catch (Exception e) {
            ValuesForGui.idle04 = "";
        }

        try {
            float seconds = idleObject05.durationInSeconds;
            ValuesForGui.idle05 = idleObject05.startTime.format(formatter) + " " + Math.round(seconds / 60);
        } catch (Exception e) {
            ValuesForGui.idle05 = "";
        }
        try {
            float seconds = idleObject06.durationInSeconds;
            ValuesForGui.idle06 = idleObject06.startTime.format(formatter) + " " + Math.round(seconds / 60);
        } catch (Exception e) {
            ValuesForGui.idle06 = "";
        }
        try {
            float seconds = idleObject07.durationInSeconds;
            ValuesForGui.idle07 = idleObject07.startTime.format(formatter) + " " + Math.round(seconds / 60);
        } catch (Exception e) {
            ValuesForGui.idle07 = "";
        }
        try {
            float seconds = idleObject08.durationInSeconds;
            ValuesForGui.idle08 = idleObject08.startTime.format(formatter) + " " + Math.round(seconds / 60);
        } catch (Exception e) {
            ValuesForGui.idle08 = "";
        }
        ActivityStatus.updateValuesForGui();
    }
}