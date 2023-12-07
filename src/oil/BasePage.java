package oil;

import javax.swing.*;
import java.awt.*;

public class BasePage extends JPanel {

    private final Color backgroundColor;

    public JPanel firstPanel;
    public JPanel secondPanel;
    public JPanel thirdPanel;
    public JPanel fourthPanel;

    public BasePage() {

        this.backgroundColor = new Color(49, 163, 118);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0; // Make the panels stretch horizontally

        firstPanel = createBasePanel();
        secondPanel = createBasePanel();
        thirdPanel = createBasePanel();
        fourthPanel = createBasePanel();

        addPanels(gbc);
    }

    public void addPanels(GridBagConstraints gbc) {
        add(firstPanel, gbc);
        gbc.gridy++;
        add(secondPanel, gbc);
        gbc.gridy++;
        add(thirdPanel, gbc);
        gbc.gridy++;
        add(fourthPanel, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(49, 163, 118));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private JPanel createBasePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(49, 163, 118));
        return panel;
    }
}
