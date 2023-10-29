import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WeatherAppGUI extends JFrame implements ActionListener {

    private final JTextField cityTextField;
    private final JLabel descriptionLabel;
    private final JLabel temperatureLabel;
    private final JLabel pressureLabel;
    private final JLabel humidityLabel;
    private final JLabel windLabel;
    private final JLabel visibilityLabel;
    private final JLabel cloudinessLabel;

    public WeatherAppGUI() {

        setTitle("Weather Forecast App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("Enter the city name: "));
        cityTextField = new JTextField(Main.loc);
        panel.add(cityTextField);

        JButton fetchButton = new JButton("Fetch Weather");
        fetchButton.addActionListener(this);
        panel.add(fetchButton);
        panel.add(new JLabel());

        panel.add(new JLabel("Description: "));
        descriptionLabel = new JLabel();
        panel.add(descriptionLabel);

        panel.add(new JLabel("Temperature: "));
        temperatureLabel = new JLabel();
        panel.add(temperatureLabel);

        panel.add(new JLabel("Pressure: "));
        pressureLabel = new JLabel();
        panel.add(pressureLabel);

        panel.add(new JLabel("Humidity: "));
        humidityLabel = new JLabel();
        panel.add(humidityLabel);

        panel.add(new JLabel("Wind: "));
        windLabel = new JLabel();
        panel.add(windLabel);

        panel.add(new JLabel("Visibility: "));
        visibilityLabel = new JLabel();
        panel.add(visibilityLabel);

        panel.add(new JLabel("Cloudiness: "));
        cloudinessLabel = new JLabel();
        panel.add(cloudinessLabel);

        add(panel);


        String cityName = cityTextField.getText();
        String apiUrl = WeatherApp.buildApiUrl(cityName);

        try {
            String jsonResponse = WeatherApp.sendHttpRequest(apiUrl);
            WeatherApp.displayWeatherInformation(cityName, jsonResponse, this, WeatherApp.TemperatureUnit.CELSIUS);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: Unable to fetch weather data.");
        }


    }

    public void setDescriptionLabel(String description) {
        descriptionLabel.setText(description);
    }

    public void setTemperatureLabel(String temperature) {
        temperatureLabel.setText(temperature);
    }

    public void setPressureLabel(String pressure) {
        pressureLabel.setText(pressure);
    }

    public void setHumidityLabel(String humidity) {
        humidityLabel.setText(humidity);
    }

    public void setWindLabel(String wind) {
        windLabel.setText(wind);
    }

    public void setVisibilityLabel(String visibility) {
        visibilityLabel.setText(visibility);
    }

    public void setCloudinessLabel(String cloudiness) {
        cloudinessLabel.setText(cloudiness);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cityName = cityTextField.getText();
        String apiUrl = WeatherApp.buildApiUrl(cityName);

        try {
            String jsonResponse = WeatherApp.sendHttpRequest(apiUrl);
            WeatherApp.displayWeatherInformation(cityName, jsonResponse, this, WeatherApp.TemperatureUnit.CELSIUS);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error: Unable to fetch weather data.");
        }
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            try {
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            WeatherAppGUI gui = new WeatherAppGUI();
//            gui.setVisible(true);
//        });
//    }
}
