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
        setLayout(new GridLayout(4, 1));

        firstPanel = createBasePanel();
        secondPanel = createBasePanel();
        thirdPanel = createBasePanel();
        fourthPanel = createBasePanel();

        addPanels();
    }

    public void addPanels() {
        this.add(firstPanel);
        this.add(secondPanel);
        this.add(thirdPanel);
        this.add(fourthPanel);
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
