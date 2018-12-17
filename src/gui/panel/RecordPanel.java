package gui.panel;


import gui.model.CategoryComboBoxModel;
import util.ColorUtil;
import util.GuiUtil;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.*;

import org.jdesktop.swingx.JXDatePicker;


public class RecordPanel extends JPanel {

    public static RecordPanel instance = new RecordPanel();
    JLabel lSpend = new JLabel("花费(￥)");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");
    public JTextField tfSpend = new JTextField("0");
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<String> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());
    JButton bSubmit = new JButton("记一笔");

    private RecordPanel() {
        this.setLayout(new BorderLayout());
        GuiUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,lDate);
        GuiUtil.setColor(ColorUtil.blueColor, bSubmit);
        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4,2,gap,gap));

        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datepick);

        pSubmit.add(bSubmit);
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        GuiUtil.showPanel(RecordPanel.instance);
    }
}
