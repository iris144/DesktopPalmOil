package oil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Locale;

public class ThirdPage extends BasePage {

    public ThirdPage(ActionListener changePageAction, String ingredients) {

        /*
        JButton button = new JButton("Button");
        String tooltipText = String.join(", \r\n", HiddenPalmOilNames.hiddenNames);

        button.setToolTipText(tooltipText);
        firstPanel.add(button, BorderLayout.CENTER);

         */

        secondPanel.add(compareText(ingredients.toLowerCase()), BorderLayout.CENTER);

        JButton tryAgainButton = new Button();
        tryAgainButton.setText("Check another product");
        tryAgainButton.addActionListener(changePageAction);

        thirdPanel.add(tryAgainButton, BorderLayout.CENTER);
    }


    private JLabel happyImageLabel() {
        ImageIcon image = new ImageIcon("src/oil/happy_orangutan.png");

        // Get the original image from the image
        Image originalImage = image.getImage();

        // Get the width and height of the label
        int labelWidth = 200;
        int labelHeight = 200;

        // Scale the image to fit the label while maintaining aspect ratio
        Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return new JLabel(scaledIcon);
    }
    private JLabel sadImageLabel() {
        ImageIcon image = new ImageIcon("src/oil/sad_orangutan.png");

        // Get the original image from the image
        Image originalImage = image.getImage();

        // Get the width and height of the label
        int labelWidth = 200;
        int labelHeight = 200;

        // Scale the image to fit the label while maintaining aspect ratio
        Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

        // Create a new ImageIcon from the scaled image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return new JLabel(scaledIcon);
    }

    public JLabel compareText(String ingredients){
        JLabel foundAMatch = new JLabel();
        foundAMatch.setHorizontalAlignment(SwingConstants.CENTER);
        foundAMatch.setVerticalAlignment(SwingConstants.CENTER);
        foundAMatch.setFont(new Font("Fira Code", Font.BOLD, 20));
        foundAMatch.setForeground(Color.BLACK);
        if (ingredients != null) {


            String[] hiddenNames = HiddenPalmOilNames.hiddenNames;

            boolean palmOilFound = false;

            for (String hiddenName : hiddenNames) {
                if (ingredients.contains(hiddenName.toLowerCase(Locale.ROOT))) {
                    palmOilFound = true;
                    break;
                }
            }

            String text;
            if (palmOilFound) {
               firstPanel.add(sadImageLabel(), BorderLayout.CENTER);
                text = "<html><div style='text-align: center;'><br><br>" +
                        "Sadly there is palm oil in this product.<br><br></div></html>";
            } else {
                firstPanel.add(happyImageLabel(), BorderLayout.CENTER);
                text = "<html><div style='text-align: center;'><br><br>" +
                        "Hooray! No palm oil here!<br><br></div></html>";
            }

            foundAMatch.setText(text);

        } else {
            foundAMatch.setText("Please fill in ingredients.");
        }

        return foundAMatch;
    }
}
