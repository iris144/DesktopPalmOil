package oil;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Button extends JButton {

    public Button() {
        setBackground(new Color(51, 51, 51));
        setPreferredSize(new Dimension(300, 50));
        setFont(new Font("Fira Code", Font.PLAIN, 16));
        setForeground(Color.white);
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        setOpaque(true);
        setContentAreaFilled(false);
    }


    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 20, 20);
        graphics.fill(roundedRectangle);

        super.paintComponent(g);
    }
}
