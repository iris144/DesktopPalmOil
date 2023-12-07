package oil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Locale;

public class ThirdPage extends BasePage {

    public ThirdPage(ActionListener changePageAction, String ingredients) {

        firstPanel.add(compareText(ingredients.toLowerCase()), BorderLayout.CENTER);

        JButton tryAgainButton = new Button();
        tryAgainButton.setText("Find out");
        tryAgainButton.addActionListener(changePageAction);

        secondPanel.add(tryAgainButton, BorderLayout.CENTER);
    }


    public JLabel compareText(String ingredients){
        JLabel foundAMatch = new JLabel();
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
                text = "<html><div style='text-align: center;'><br><br>" +
                        "There is palm oil in this product.</div></html>";
            } else {
                text = "<html><div style='text-align: center;'><br><br>" +
                        "Hooray! No palm oil here!.</div></html>";
            }

            foundAMatch.setText(text);

        } else {
            foundAMatch.setText("Please fill in ingredients.");
        }

        return foundAMatch;
    }
}
