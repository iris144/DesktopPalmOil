package oil;

import javax.swing.*;
import java.awt.*;


public class Application extends JFrame {

    public Application() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setTitle("Palm oil translator");
        setIconImage(new ImageIcon("src/oil/orangutan.png").getImage());
        setLocationRelativeTo(null);

        CustomPanel customPanel = new CustomPanel(new Color(49, 163, 118));
        customPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0); // Adjust the vertical spacing

        JPanel mainPanel = createMainPanel();
        JPanel textPanel = createTextPanel();
        JPanel buttonPanel = createButtonPanel();


        JLabel nameLabel = createNameLabel();
        JLabel description = createDescriptionLabel();
        JButton startButton = createStartButton();

        textPanel.add(nameLabel, BorderLayout.NORTH);
        mainPanel.add(description, BorderLayout.CENTER);
        buttonPanel.add(startButton, BorderLayout.SOUTH);

        customPanel.add(textPanel, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0); // Reset insets for less spacing
        customPanel.add(mainPanel, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0); // Reset insets for less spacing
        customPanel.add(buttonPanel, gbc);

        setContentPane(customPanel);
        setVisible(true);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBackground(new Color(49, 163, 118));
        return buttonPanel;
    }

    private JButton createStartButton() {
        JButton startButton = new JButton("Hello");
        startButton.setLayout(new BorderLayout());

        return startButton;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(49, 163, 118));
        return mainPanel;
    }

    private JPanel createTextPanel() {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(new Color(49, 163, 118));
        return textPanel;
    }

    private JLabel createNameLabel() {
        JLabel nameLabel = new JLabel("PALM OIL TRANSLATOR");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setVerticalAlignment(SwingConstants.CENTER);
        nameLabel.setFont(new Font("Fira Code", Font.BOLD, 20));
        nameLabel.setForeground(Color.BLACK);
        return nameLabel;
    }

    private JLabel createDescriptionLabel() {
        JLabel description = new JLabel("Translates easy and fast all palm oil names to palm oil!");
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        description.setFont(new Font("Fira Code", Font.PLAIN, 16));
        description.setForeground(Color.BLACK);
        return description;

    }
    private static class CustomPanel extends JPanel {
        private Color backgroundColor;

        public CustomPanel(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
            setLayout(new BorderLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(backgroundColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

}
