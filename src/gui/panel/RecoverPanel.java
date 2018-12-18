package gui.panel;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;

public class RecoverPanel extends JPanel {
    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover = new JButton("恢复");

    public RecoverPanel() {

        GuiUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);

        addActionListener();
    }

    private void addActionListener() {
        RecoverListener listener = new RecoverListener();
        bRecover.addActionListener(listener);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(RecoverPanel.instance);
    }
}
