import java.awt.*;

public class Test0 implements Runnable {
    Frame f1;
    Thread th1;
    Label timeLabel;
    Font fnt;

    public Test0() {
        th1 = new Thread(this);
        th1.start();
        f1 = new Frame("Digital Clock...");

        timeLabel = new Label("");

        fnt = new Font("Arial Black", Font.BOLD, 55);
        timeLabel.setFont(fnt);

        f1.setLayout(null);

        f1.add(timeLabel);

        timeLabel.setBounds(100, 150, 400, 50);

        f1.setVisible(true);
        f1.setSize(600, 400);
        f1.setLocation(200, 100);
        f1.setBackground(Color.black);
        timeLabel.setBackground(Color.black);
        timeLabel.setForeground(Color.green);

        f1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent winEvt) {
                System.exit(0);
            }
        });
    }

    public void run() {
        try {
            for (int h = 0; h < 24; h++) {
                for (int m = 0; m < 60; m++) {
                    for (int s = 0; s < 60; s++) {
                        th1.sleep(1000);
                        timeLabel.setText(String.format("%02d:%02d:%02d", h, m, s));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Test0();
    }
}
