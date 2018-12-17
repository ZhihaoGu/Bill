package gui.listener;

import gui.panel.SpendPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpendPanelListener implements ActionListener {

    private SpendPanel sp;
    public SpendPanelListener(SpendPanel sp) {
        this.sp = sp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sp.setMonthSpend(10);
    }
}
