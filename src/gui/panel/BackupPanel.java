package gui.panel;

import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;

public class BackupPanel extends JPanel {


    public static BackupPanel instance = new BackupPanel();
    JButton bBackup =new JButton("备份");

    public BackupPanel() {
        GuiUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(BackupPanel.instance);
    }
}
