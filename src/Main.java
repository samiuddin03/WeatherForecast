import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {
    public static String loc;

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JButton signupButton;
    private final JLabel messageLabel;

    public Main() {
        // Create and set up the window
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        // Create and add the components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        signupButton = new JButton("Sign up");
        signupButton.addActionListener(this);
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        messageLabel = new JLabel();



        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(signupButton);
        add(loginButton);
        add(messageLabel);

        // Display the window
        setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        // Handle the button clicks
        if (a.getSource() == loginButton) {
            // Try to log in with the given username and password
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (validateUser(username, password)) {
                // Login successful, show a message and close the window
                messageLabel.setText("Login successful!");
                messageLabel.setForeground(Color.GREEN);
                SwingUtilities.invokeLater(() -> {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    WeatherAppGUI gui = new WeatherAppGUI();
                    gui.setVisible(true);
                });
                dispose();
            } else {
                // Login failed, show an error message and clear the fields
                messageLabel.setText("Invalid username or password!");
                messageLabel.setForeground(Color.RED);
                usernameField.setText("");
                passwordField.setText("");
            }
        } else if (a.getSource() == signupButton) {
            // Open another frame to sign up
            new SignUp();
            dispose();
        }
    }

    public boolean validateUser(String username, String password) {
        // Check if the user exists in the users.txt file
        try {

            BufferedReader reader = new BufferedReader(new FileReader("D:\\NSU\\3rd Semester\\CSE215 Szz\\WeatherForecast\\users.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma and compare the username and password
                String[] tokens = line.split(",");
                System.out.println(tokens[2]);
                if (tokens[0].equals(username) && tokens[1].equals(password)) {
                    loc = tokens[2];
                    // User found, return true
                    reader.close();
                    return true;
                }
            }
            // User not found, return false
            reader.close();
            return false;
        } catch (IOException e) {
            // File error, return false
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Create and run the login frame
        new Main();
    }
}