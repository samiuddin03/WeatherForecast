
// Sign up class
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class SignUp {

    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JTextField locationField;
    private final JLabel messageLabel;
    JFrame frame = new JFrame("Sign Up");
    public SignUp() {
        // Create and set up the window

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create and add the components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel locationLabel = new JLabel("Location:");
        locationField = new JTextField();
        JButton signUpButton = new JButton("Sign Up");
        messageLabel = new JLabel("");
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(locationLabel);
        panel.add(locationField);
        panel.add(signUpButton);
        panel.add(messageLabel);
        frame.add(panel);

        // Add action listener to the button
        signUpButton.addActionListener(e -> signUp());

        // Display the window
        frame.setVisible(true);
    }

    // Method to sign up a new user
    private void signUp() {
        // Get the username and password from the fields
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String location = locationField.getText();

        // Check if the username and password are valid
        if (username.isEmpty() || password.isEmpty() || location.isEmpty()) {
            messageLabel.setText("Please enter your username, password and location");
            return;
        }

        // Check if the username already exists in the file
        try {
            Scanner scanner = new Scanner(new File("D:\\NSU\\3rd Semester\\CSE215 Szz\\WeatherForecast\\users.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                if (tokens[0].equals(username)) {
                    messageLabel.setText("Username already exists");
                    return;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Append the username and password to the file
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("D:\\NSU\\3rd Semester\\CSE215 Szz\\WeatherForecast\\users.txt", true));
            writer.println(username + "," + password + "," + location);
            writer.close();


            new Main();
            frame.dispose();

        } catch (IOException e) {
            e.printStackTrace();
            messageLabel.setText("Sign up failed");
        }
    }

}
