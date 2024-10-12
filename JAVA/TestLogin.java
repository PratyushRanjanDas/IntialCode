import java.awt.*;

class TestLogin {

    Frame f1;
    Panel p1;
    Label label1, label2, label3, label4, label5;
    TextField tf1, tf2, tf3, tf4, tf5;
    Button b1, b2;

    TestLogin() {
        f1 = new Frame("Login Page");
        p1 = new Panel();

        label1 = new Label("Username");
        label2 = new Label("Password");
        label3 = new Label("Confirm Password");
        label4 = new Label("Phone Number");
        label5 = new Label("Email");


        tf1 = new TextField(20);
        tf2 = new TextField(20);
        tf2.setEchoChar('*');
        tf3 = new TextField(20);
        tf3.setEchoChar('*');
        tf4 = new TextField(20);
        tf5 = new TextField(20);


        b1 = new Button("Login");
        b2 = new Button("Reset");


        p1.setLayout(new GridLayout(6, 2, 10, 10));


        p1.add(label1);
        p1.add(tf1);
        p1.add(label2);
        p1.add(tf2);
        p1.add(label3);
        p1.add(tf3);
        p1.add(label4);
        p1.add(tf4);
        p1.add(label5);
        p1.add(tf5);
        p1.add(b1);
        p1.add(b2);

        f1.setLayout(new FlowLayout(FlowLayout.CENTER));
        f1.add(p1);
        f1.setSize(400, 300);
        f1.setLocation(190, 100);
        f1.setBackground(Color.cyan);
        f1.setVisible(true);
    }

    public static void main(String[] args) {
        new TestLogin();
    }
}