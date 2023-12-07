package oil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FirstPage extends BasePage {

    public FirstPage(ActionListener changePageAction) {
        firstPanel.add(createNameLabel(), BorderLayout.CENTER);
        secondPanel.add(createDescriptionLabel(), BorderLayout.CENTER);

        JButton startButton = new Button();
        startButton.setText("Continue");
        startButton.addActionListener(changePageAction);

        thirdPanel.add(startButton, BorderLayout.CENTER);
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
        String text = "<html><div style='text-align: center;'><br><br>Translates easy and fast all palm oil names to palm oil!<br><br>" +
                "<br><br></div></html>";
        JLabel description = new JLabel(text);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setVerticalAlignment(SwingConstants.CENTER);
        description.setFont(new Font("Fira Code", Font.PLAIN, 16));
        description.setForeground(Color.BLACK);
        return description;
    }
}
