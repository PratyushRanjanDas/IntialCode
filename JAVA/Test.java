import java.awt.*;
import java.awt.event.*;

public class Test implements ActionListener {
    Frame f1;
    Panel p;

    Button b1, b2;

    public Test() {
        f1 = new Frame("Jyotiraditya Sahoo.....");
        p = new Panel();

        b1 = new Button("Red");
        b2 = new Button("Yellow");

        f1.add(p);
        p.add(b1);
        p.add(b2);

        f1.setSize(500, 500);
        f1.setLocation(400, 150);
        f1.setBackground(Color.pink);
        p.setBackground(Color.cyan);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f1.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f1.dispose();
            }
        });

        f1.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            p.setBackground(Color.red);
            System.out.println("My Red button is working...");
        }
        if (e.getSource() == b2) {
            p.setBackground(Color.yellow);
            System.out.println("My Yellow button is working...");
        }
    }

    public static void main(String args[]) {
        // Use SwingUtilities to ensure GUI is created on the Event Dispatch Thread
         new Test();
    }
}
