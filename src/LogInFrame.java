package src;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

class LogInFrame extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel labelUsername, labelPassword;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JButton buttonLogin, buttonCancel;
    private boolean loginReturn = false;

    public LogInFrame() {
        this.InitializeComponents();

    }

    @SuppressWarnings("deprecation")
    public void actionPerformed(ActionEvent ae) {
        String textOfButton = ae.getActionCommand();

        if (textOfButton.equals("Login")) {
            String username = this.textUsername.getText().trim();
            String passsword = this.textPassword.getText().trim();
            db dbf = new db();
            loginReturn = dbf.pass(username, passsword);

            if (username.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your username");
            } else if (passsword.equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter your password");
            } else if (passsword.length() < 4) {
                JOptionPane.showMessageDialog(this, "Password should have at least 4 characters");
            } else {
                if (loginReturn == true) {
                    Frame1 f1 = new Frame1();
                    f1.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password.");
                }
            }
        } else if (textOfButton.equals("Cancel")) {
            System.exit(0);
        }
    }

    private void InitializeComponents() {
        this.panel = new JPanel();
        this.panel.setLayout(null);
        add(this.panel);

        this.labelUsername = new JLabel("USERNAME");
        this.labelUsername.setBounds(100, 70, 80, 20);
        this.panel.add(this.labelUsername);


        this.textUsername = new JTextField();
        this.textUsername.setBounds(180, 70, 120, 20);
        this.panel.add(this.textUsername);


        this.labelPassword = new JLabel("PASSWORD");
        this.labelPassword.setBounds(100, 100, 80, 20);
        this.panel.add(this.labelPassword);


        this.textPassword = new JPasswordField();
        this.textPassword.setBounds(180, 100, 120, 20);
        this.panel.add(this.textPassword);


        this.buttonCancel = new JButton("Cancel");
		this.buttonCancel.setBackground(Color.RED);
        this.buttonCancel.setBounds(220, 150, 80, 20);
        this.buttonCancel.addActionListener(this);
        this.panel.add(this.buttonCancel);


        this.buttonLogin = new JButton("Login");
        this.buttonLogin.setBounds(305, 150, 80, 20);
        this.buttonLogin.setBackground(Color.GREEN);
        this.buttonLogin.addActionListener(this);
        this.panel.add(this.buttonLogin);

        this.setTitle("Hotel Reservation System");
        this.setSize(500, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
