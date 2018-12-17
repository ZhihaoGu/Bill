package util;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {
    private double rate;
    private JComponent jComponent;
    private Boolean stretch;

    public CenterPanel(double rate, Boolean strech) {
        this.rate = rate;
        this.stretch = strech;
        this.setLayout(null);
    }

    public CenterPanel(double rate) {
        this(rate, true);

    }

    public void repaint() {
        if (null != jComponent) {
            Dimension containerSize = this.getSize();
            Dimension componentSize= jComponent.getPreferredSize();

            if(stretch)
                jComponent.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            else
                jComponent.setSize(componentSize);

            jComponent.setLocation(containerSize.width / 2 - jComponent.getSize().width / 2, containerSize.height / 2 - jComponent.getSize().height / 2);
        }
        super.repaint();
    }

    public void show(JComponent p) {
        this.jComponent = p;
        Component[] cs = getComponents();
        for (Component c : cs) {
            remove(c);
        }
        add(p);
        this.updateUI();
    }
}
