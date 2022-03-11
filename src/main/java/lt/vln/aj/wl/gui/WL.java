package lt.vln.aj.wl.gui;

import lt.vln.aj.wl.common.ActivityStatus;
import lt.vln.aj.wl.common.StarterStopper;
import lt.vln.aj.wl.idle.IdleManagerSingl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class WL implements Runnable {
    private JPanel panel1;
    private JLabel output;
    private JLabel status;
    private JTextField modifyTextField;
    private JButton addTime;
    private JButton subtractTime;
    private JButton setTime;
    private JLabel idle01;
    private JLabel idle02;
    private JLabel idle03;
    private JLabel idle04;
    private JLabel idle05;
    private JLabel idle06;
    private JLabel idle07;
    private JLabel idle08;
    private JButton idle01Add;
    private JButton idle02Add;
    private JButton idle03Add;
    private JButton idle04Add;
    private JButton idle05Add;
    private JButton idle06Add;
    private JButton idle07Add;
    private JButton idle08Add;
    private JButton idle01Cancel;
    private JButton idle02Cancel;
    private JButton idle03Cancel;
    private JButton idle04Cancel;
    private JButton idle05Cancel;
    private JButton idle06Cancel;
    private JButton idle07Cancel;
    private JButton idle08Cancel;
    private JButton startBreak;
    private JButton endBreak;


    Timer t = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            idle01.setText(ValuesForGui.idle01);
            idle02.setText(ValuesForGui.idle02);
            idle03.setText(ValuesForGui.idle03);
            idle04.setText(ValuesForGui.idle04);
            idle05.setText(ValuesForGui.idle05);
            idle06.setText(ValuesForGui.idle06);
            idle07.setText(ValuesForGui.idle07);
            idle08.setText(ValuesForGui.idle08);
            output.setText(ValuesForGui.output);
            status.setText(ValuesForGui.status);
        }
    });


    public WL() {
        addTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivityStatus.workSeconds = ActivityStatus.workSeconds + (Integer.parseInt(modifyTextField.getText()) * 60);
                modifyTextField.setText("");
            }
        });
        subtractTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivityStatus.workSeconds = ActivityStatus.workSeconds - (Integer.parseInt(modifyTextField.getText()) * 60);
                modifyTextField.setText("");
            }
        });
        setTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActivityStatus.workSeconds = Integer.parseInt(modifyTextField.getText()) * 60;
                modifyTextField.setText("");
            }
        });
        idle01Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().addIdleViaButton(1);
            }
        });
        idle01Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().cancelIdleViaButton(1);
            }
        });
        idle02Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().addIdleViaButton(2);
            }
        });
        idle02Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().cancelIdleViaButton(2);
            }
        });
        idle03Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().addIdleViaButton(3);
            }
        });
        idle03Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().cancelIdleViaButton(3);
            }
        });
        idle04Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().addIdleViaButton(4);
            }
        });
        idle04Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().cancelIdleViaButton(4);
            }
        });
        idle05Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().addIdleViaButton(5);
            }
        });
        idle05Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().cancelIdleViaButton(5);
            }
        });
        idle06Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().addIdleViaButton(6);
            }
        });
        idle06Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().cancelIdleViaButton(6);
            }
        });
        idle07Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().addIdleViaButton(7);
            }
        });
        idle07Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().cancelIdleViaButton(7);
            }
        });
        idle08Add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().addIdleViaButton(8);
            }
        });
        idle08Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdleManagerSingl.getInstance().cancelIdleViaButton(8);
            }
        });
        startBreak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code here
                try {
                    new StarterStopper().startBreak(999);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        endBreak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new StarterStopper().stopBreak(999);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void start() {
        t.start();
    }

    JFrame frame = MyJFrame.getInstance();

    @Override
    public void run() {
//        URL iconURL = getClass().getResource("/resources/Watch.png");
        URL iconURL = getClass().getResource("/Watch.png");
        ImageIcon img = new ImageIcon(iconURL);
        frame.setTitle("WL");
        WL wl = new WL();
        frame.setContentPane(wl.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(404, 357);
        frame.setVisible(true);
        frame.setIconImage(img.getImage());
        wl.start();
    }
}
