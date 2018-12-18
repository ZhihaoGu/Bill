package gui.panel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;

public class BackupPanel extends JPanel {


    public static BackupPanel instance = new BackupPanel();
    JButton bBackup = new JButton("备份（未完成）");

    public BackupPanel() {
        GuiUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
        addActionListener();
    }

    private void addActionListener() {
        BackupListener listener = new BackupListener();
        bBackup.addActionListener(listener);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(BackupPanel.instance);
    }
}
