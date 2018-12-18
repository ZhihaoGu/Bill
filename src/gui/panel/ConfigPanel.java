package gui.panel;

import gui.listener.ConfigListener;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    public static ConfigPanel instance = new ConfigPanel();

    JLabel lBudget = new JLabel("本月预算(￥)");
    public JTextField tfBudget = new JTextField("0");

    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPath = new JTextField("");

    JButton bSubmit = new JButton("更新");

    public ConfigPanel() {
        GuiUtil.setColor(ColorUtil.grayColor, lBudget,lMysql);
        GuiUtil.setColor(ColorUtil.blueColor, bSubmit);

        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        int gap =40;
        pInput.setLayout(new GridLayout(4,1,gap,gap));

        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysqlPath);
        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);

        pSubmit.add(bSubmit);
        this.add(pSubmit, BorderLayout.CENTER);

        addListener();
    }

    private void addListener() {
        ConfigListener l =new ConfigListener();
        bSubmit.addActionListener(l);
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(ConfigPanel.instance);
    }
}
