package lt.vln.aj.wl.gui;

import javax.swing.*;

// Singleton
public class MyJFrame extends JFrame {

    // static variable single_instance of type Singleton
    private static MyJFrame single_instance = null;

    // private constructor restricted to this class itself
    private MyJFrame() {
        super();
    }

    // static method to create instance of Singleton class
    public static MyJFrame getInstance() {
        if (single_instance == null)
            single_instance = new MyJFrame();

        return single_instance;
    }
}
