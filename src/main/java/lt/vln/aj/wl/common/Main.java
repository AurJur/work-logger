package lt.vln.aj.wl.common;

import lt.vln.aj.wl.gui.WL;

public class Main {

    public static void main(String[] args) {

        Thread poller = new Thread(new Poller());
        Thread win32WindowDemo = new Thread(new Win32WindowDemoStarter());
        Thread gui = new Thread(new WL());

        poller.start();
        win32WindowDemo.start();
        gui.start();
    }
}
