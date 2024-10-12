import java.awt.*;
import java.awt.event.*;

public class stopwatch implements Runnable, ActionListener {
    Frame f1;
    Thread th1;
    Label timeLabel;
    Font fnt;


    private long startTime;
    private boolean isRunning = false;

    public stopwatch() {
        th1 = new Thread(this);
        th1.start();
        f1 = new Frame("Stopwatch...");

        timeLabel = new Label("");

        fnt = new Font("Arial Black", Font.BOLD, 55);
        timeLabel.setFont(fnt);

        f1.setLayout(null);


        Button startButton = new Button("Start");
        startButton.addActionListener(this);
        f1.add(startButton);
        startButton.setBounds(100, 300, 100, 50);

        Button stopButton = new Button("Stop");
        stopButton.addActionListener(this);
        f1.add(stopButton);
        stopButton.setBounds(250, 300, 100, 50);

        Button resetButton = new Button("Reset");
        resetButton.addActionListener(this);
        f1.add(resetButton);
        resetButton.setBounds(400, 300, 100, 50);

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
        while (true) {
            if (isRunning) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                long seconds = elapsedTime / 1000 % 60;
                long minutes = elapsedTime / (1000 * 60) % 60;
                long hours = elapsedTime / (1000 * 60 * 60);
                timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }
            try {
                Thread.sleep(100); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Start":
                if (!isRunning) {
                    startTime = System.currentTimeMillis();
                    isRunning = true;
                }
                break;
            case "Stop":
                isRunning = false;
                break;
            case "Reset":
                isRunning = false;
                startTime = System.currentTimeMillis();
                timeLabel.setText("00:00:00");
                break;
        }
    }

    public static void main(String args[]) {
        new stopwatch();
    }
}