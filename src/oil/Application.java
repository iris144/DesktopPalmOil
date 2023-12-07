package oil;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class Application extends JFrame {
    private JTextArea ingredients;

    public Application() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 1000);
        setTitle("Palm oil translator");
        setIconImage(new ImageIcon("src/oil/orangutan.png").getImage());
        setLocationRelativeTo(null);

        CustomPanel customPanel = new CustomPanel(new Color(49, 163, 118));
        customPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 5, 0); // Adjust the vertical spacing

        // All the panels you will use throughout the whole process
        JPanel firstPanel = firstPanel();
        JPanel secondPanel = secondPanel();
        JPanel thirdPanel = thirdPanel();
        JPanel fourthPanel = fourthPanel();

        // the first 'page' with your labels and button
        JLabel nameLabel = createNameLabel();
        JLabel description = createDescriptionLabel();
        JButton startButton = new Button();
        startButton.setText("Continue");

        // adding your first page labels to your panels
        firstPanel.add(nameLabel, BorderLayout.NORTH);
        secondPanel.add(description, BorderLayout.CENTER);
        thirdPanel.add(startButton, BorderLayout.SOUTH);

        // creating new labels for your second page
        JLabel page2InformationText = page2Information();
        JScrollPane fillInIngredients = yourIngredients();
        JLabel foundOutIfText = page2Text();
        JButton findOutButton = new Button();
        findOutButton.setText("Find out");

        // creating new labels for third page
        JLabel foundAMatch = compareText();


        startButton.addActionListener(e -> {
            firstPanel.remove(nameLabel);
            secondPanel.remove(description);
            thirdPanel.remove(startButton);
            firstPanel.add(page2InformationText, BorderLayout.CENTER);
            secondPanel.add(fillInIngredients, BorderLayout.CENTER);
            thirdPanel.add(foundOutIfText, BorderLayout.CENTER);
            fourthPanel.add(findOutButton, BorderLayout.CENTER);


                findOutButton.addActionListener(f -> {
                    firstPanel.remove(page2InformationText);
                    secondPanel.remove(fillInIngredients);
                    thirdPanel.remove(foundOutIfText);
                    fourthPanel.remove(findOutButton);
                    firstPanel.add(foundAMatch);

                    customPanel.revalidate();
                    customPanel.repaint();
                });

            // Repaint the customPanel to reflect changes
            customPanel.revalidate();
            customPanel.repaint();
        });


        // Layout of your application.
        customPanel.add(firstPanel, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0);

        customPanel.add(secondPanel, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0);

        customPanel.add(thirdPanel, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 0, 0);

        customPanel.add(fourthPanel, gbc);

        // just making it visible
        setContentPane(customPanel);
        setVisible(true);
    }

    private JPanel firstPanel() {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(new Color(49, 163, 118));
        return textPanel;
    }

    private JPanel secondPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(49, 163, 118));
        return mainPanel;
    }

    private JPanel thirdPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBackground(new Color(49, 163, 118));
        return buttonPanel;
    }

    private JPanel fourthPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setBackground(new Color(49, 163, 118));
        return buttonPanel;
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


private JLabel page2Information() {
    String text = "<html><div style='text-align: center;'><br><br>Fill in your list of ingredients of your product:<br><br></div></html>";
    JLabel newLabel = new JLabel(text);
    newLabel.setHorizontalAlignment(SwingConstants.CENTER);
    newLabel.setVerticalAlignment(SwingConstants.CENTER);
    newLabel.setFont(new Font("Fira Code", Font.BOLD, 16));
    newLabel.setForeground(Color.black);
    return newLabel;
}

private JScrollPane yourIngredients() {

    ingredients = new JTextArea();
    ingredients.setRows(5); // Set the number of visible rows
    ingredients.setColumns(20); // Set the number of visible columns

    ingredients.setLineWrap(true);
    ingredients.setWrapStyleWord(true);

    // Set the start position to the start
    ingredients.setCaretPosition(0);

    JScrollPane scrollPane = new JScrollPane(ingredients);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    Dimension preferredSize = new Dimension(300, 100);
    scrollPane.setPreferredSize(preferredSize);

    return scrollPane;
}

    private JLabel page2Text() {
        String text = "<html><div style='text-align: center;'><br><br>" +
                "Find out if your product contains hidden palm oil!<br><br>Press the button</div></html>";
        JLabel newLabel = new JLabel(text);

        newLabel.setHorizontalAlignment(SwingConstants.CENTER);
        newLabel.setVerticalAlignment(SwingConstants.CENTER);
        newLabel.setFont(new Font("Fira Code", Font.BOLD, 16));
        newLabel.setForeground(Color.black);
        return newLabel;
    }

    public JLabel compareText(){
        JLabel foundAMatch = new JLabel();
        if (ingredients != null) {
            String enteredText = ingredients.getText();
            String[] splitEnteredText = enteredText.split("\\s+");
            String[] hiddenNames = HiddenPalmOilNames.hiddenNames;


            boolean palmOilFound = false;

            for (String name : splitEnteredText) {
                if (Arrays.asList(hiddenNames).contains(name)) {
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
