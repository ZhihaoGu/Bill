package startup;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;

import javax.swing.*;

public class Bootstrap {
    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.getInstance());
            }
        });
    }
}
