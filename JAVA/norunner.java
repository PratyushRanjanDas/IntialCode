import java.awt.*;
import java.awt.event.*;

public class norunner implements MouseListener {

    Frame f1;
    Label l1;
    Font fnt;
    Button b1, b2, b3, b4, b5, returnButton;

    public norunner() {
        f1 = new Frame();
        fnt = new Font("Arial Black", Font.BOLD, 45);
        l1 = new Label("Are you Fool ???????");

        l1.setFont(fnt);

        b1 = new Button("Yes");
        b2 = new Button("No");
        b3 = new Button("No");
        b4 = new Button("No");
        b5 = new Button("No");
        returnButton = new Button("Return"); // Add the return button

        f1.setLayout(null); // Consider using a layout manager for better organization

        l1.setBounds(100, 100, 650, 50);
        b1.setBounds(200, 190, 50, 30);
        b2.setBounds(300, 190, 50, 30);
        b3.setBounds(550, 400, 50, 30);
        b4.setBounds(10, 190, 50, 30);
        b5.setBounds(300, 450, 50, 30);
        returnButton.setBounds(400, 190, 150, 30); // Position the return button

        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);

        f1.add(l1);
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b4);
        f1.add(b5);
        f1.add(returnButton); // Add the return button to the frame

        f1.setVisible(true);
        f1.setSize(750, 500);
        f1.setLocation(200, 100);
        f1.setBackground(Color.green);

        b1.addMouseListener(this);
        b2.addMouseListener(this);
        b3.addMouseListener(this);
        b4.addMouseListener(this);
        b5.addMouseListener(this);
        returnButton.addMouseListener(this); // Add listener for return button
    }

    public void mouseExited(MouseEvent me1) {
        // No action needed here
    }

    public void mouseEntered(MouseEvent me2) {
        System.out.println("mouseEntered");

        if (me2.getSource() == b2) {
            b2.setVisible(false);
            b3.setVisible(true);
        } else if (me2.getSource() == b3) {
            b3.setVisible(false);
            b4.setVisible(true);
        } else if (me2.getSource() == b4) {
            b4.setVisible(false);
            b5.setVisible(true);
        } else if (me2.getSource() == b5) {
            b5.setVisible(false);
            b2.setVisible(true);
        }

    }

    public void mouseReleased(MouseEvent me3) {
        // No action needed here
    }

    public void mousePressed(MouseEvent me4) {
        // No action needed here
    }

    public void mouseClicked(MouseEvent me5) {
        if (me5.getSource() == b1) {
            l1.setText("Thank You for your honesty!");
        } else if (me5.getSource() == returnButton) {
            // Implement functionality for the "Return" button
            // You can reset the label text or perform other actions
            l1.setText("Are you Fool ???????");
        }
    }

    public static void main(String args[]) {
        new norunner();
    }
}