package gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.ChartUtil;
import util.GuiUtil;

public class ReportPanel extends JPanel {
    public static ReportPanel instance = new ReportPanel();

    public JLabel l = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());
        Image i =ChartUtil.getImage(400, 300);
        ImageIcon icon= new ImageIcon(i);
        l.setIcon(icon);
        this.add(l);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(ReportPanel.instance);
    }

}