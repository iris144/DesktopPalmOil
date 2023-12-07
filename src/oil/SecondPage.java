package oil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;
import java.util.function.Function;

public class SecondPage extends BasePage {

    private JTextArea ingredients;

    public SecondPage(ActionListener changePageAction, Consumer<String> setIngredients) {
        firstPanel.add(page2Information(), BorderLayout.CENTER);
        secondPanel.add(yourIngredients(), BorderLayout.CENTER);
        thirdPanel.add(page2Text(), BorderLayout.CENTER);

        JButton findOutButton = new Button();
        findOutButton.setText("Find out");
        findOutButton.addActionListener(e -> {
            setIngredients.accept(ingredients.getText());
            changePageAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null) {
            });
        });

        fourthPanel.add(findOutButton, BorderLayout.CENTER);
    }

    private JLabel page2Information() {
        String text = "<html><div style='text-align: center;'><br><br>Fill in your list of ingredients of your product:<br><br></div></html>";
        JLabel newLabel = new JLabel(text);
        newLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newLabel.setVerticalAlignment(SwingConstants.CENTER);
        newLabel.setFont(new Font("Fira Code", Font.PLAIN, 16));
        newLabel.setForeground(Color.black);
        return newLabel;
    }

    private JScrollPane yourIngredients() {

        ingredients = new JTextArea();
        ingredients.setRows(5);
        ingredients.setColumns(20);

        ingredients.setLineWrap(true);
        ingredients.setWrapStyleWord(true);
        ingredients.setBackground(new Color(245, 244, 237));

        ingredients.setFont(new Font("Fira Code", Font.PLAIN, 12));

        // Set the start position to the top left corner
        ingredients.setCaretPosition(0);

        JScrollPane scrollPane = new JScrollPane(ingredients);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        Dimension preferredSize = new Dimension(300, 100);
        scrollPane.setPreferredSize(preferredSize);

        return scrollPane;
    }

    private JLabel page2Text() {
        String text = "<html><div style='text-align: center;'><br><br>" +
                "Find out if your product contains hidden palm oil!<br><br>Press the button<br><br></div></html>";
        JLabel newLabel = new JLabel(text);

        newLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newLabel.setVerticalAlignment(SwingConstants.CENTER);
        newLabel.setFont(new Font("Fira Code", Font.PLAIN, 16));
        newLabel.setForeground(Color.black);
        return newLabel;
    }
}
