import java.awt.*;
import java.awt.event.*;
public class loginclose  implements WindowListener{
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
                System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    Panel p;
    Frame f;
    Button b1, b2,b3,b4;
    public loginclose() {
        f = new Frame("Yokasha ");
        p = new Panel();
        b1 = new Button("cyan");
        b2 = new Button("blue");
        b3 = new Button("red");
        b4 = new Button("yellow");



        p.setLayout(new FlowLayout());


        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);


        f.add(p);

        f.setSize(300, 400);
        f.setLocation(500, 50);
        f.setVisible(true);
        f.setBackground(Color.lightGray);


        b1.addActionListener(e -> f.setBackground(Color.cyan));
        b2.addActionListener(e -> f.setBackground(Color.blue));
        b3.addActionListener(e -> f.setBackground(Color.red));
        b4.addActionListener(e -> f.setBackground(Color.yellow));


        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new loginclose();
    }
}
