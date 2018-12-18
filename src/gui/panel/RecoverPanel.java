package gui.panel;

import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;

public class RecoverPanel extends JPanel {
    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover =new JButton("恢复");

    public RecoverPanel() {

        GuiUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);

    }

    public static void main(String[] args) {
        GuiUtil.showPanel(RecoverPanel.instance);
    }
}
