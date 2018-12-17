package util;

import javax.swing.*;
import java.awt.*;

public class CircleBar extends JPanel {

    private int percentage;
    private Color frontColor;
    private Color backgroundColor;
    private int max, min;

    public CircleBar() {
        percentage = 0;
        max = 100;
        min = 0;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        int fontSize = 0;
        if (getWidth() >= getHeight()) {                //取中间位置大小
            x = (getWidth() - getHeight()) / 2 + 25;
            y = 25;
            width = getHeight() - 50;
            height = getHeight() - 50;
            fontSize = getWidth() / 8;
        } else {
            x = 25;
            y = (getHeight() - getWidth()) / 2 + 25;
            width = getWidth() - 50;
            height = getWidth() - 50;
            fontSize = getHeight() / 8;
        }
        graphics2d.setStroke(new BasicStroke(20.0f));
        graphics2d.setColor(backgroundColor);
        graphics2d.drawArc(x, y, width, height, 0, 360);
        graphics2d.setColor(frontColor);
        graphics2d.drawArc(x, y, width, height, 90,
                -(int) (360 * ((percentage * 1.0) / (max - min))));
        graphics2d.setFont(new Font("黑体", Font.BOLD, fontSize));
        FontMetrics fontMetrics = graphics2d.getFontMetrics();
        int digitalWidth = fontMetrics.stringWidth(String.valueOf(percentage));
        int digitalAscent = fontMetrics.getAscent();
        graphics2d.setColor(frontColor);
        graphics2d.drawString(String.valueOf(percentage), getWidth() / 2 - digitalWidth / 2, getHeight() / 2 + digitalAscent / 2);
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int progress) {
        if (progress >= min && progress <= max)
            this.percentage = progress;
        if (progress > max)
            this.percentage = max;
        percentage = progress;
        this.repaint();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.repaint();
    }

    public Color getFrontColor() {
        return frontColor;
    }

    public void setFrontColor(Color foregroundColor) {
        this.frontColor = foregroundColor;
        this.repaint();
    }

}
