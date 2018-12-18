package gui.panel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleBar;
import util.ColorUtil;
import util.GuiUtil;

import javax.swing.*;
import java.awt.*;

public class SpendPanel extends WorkingPanel {

    JLabel lMonthSpend = new JLabel("本月消费");
    JLabel lTodaySpend = new JLabel("今日消费");
    JLabel lAvgSpendPerDay = new JLabel("日均消费");
    JLabel lMonthLeft = new JLabel("本月剩余");
    JLabel lDayAvgAvailable = new JLabel("日均可用");
    JLabel lMonthLeftDay = new JLabel("距离月末");

    JLabel vMonthSpend = new JLabel("￥2300");
    JLabel vTodaySpend = new JLabel("￥25");
    JLabel vAvgSpendPerDay = new JLabel("￥120");
    JLabel vMonthAvailable = new JLabel("￥2084");
    JLabel vDayAvgAvailable = new JLabel("￥389");
    JLabel vMonthLeftDay = new JLabel("15天");

    CircleBar circleBar = new CircleBar();

    public void setMonthSpend(int num) {
        vMonthSpend.setText("￥" + num);
    }

    public void setvTodaySpend(int num) {
        vTodaySpend.setText("￥" + num);
    }

    public void setvAvgSpendPerDay(int num) {
        vAvgSpendPerDay.setText("￥" + num);
    }

    public void setvMonthAvailable(int num) {
        vMonthAvailable.setText("￥" + num);
    }

    public void setvDayAvgAvailable(int num) {
        vDayAvgAvailable.setText("￥" + num);
    }

    public void setvMonthLeftDay(int num) {
        vMonthLeftDay.setText(num + "天");
    }

    //单例
    private SpendPanel() {
        this.setLayout(new BorderLayout());
        GuiUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
                lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
        GuiUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    private static SpendPanel instance = new SpendPanel(); //加载时即刻实例化
    //private static SpendPanel instance; //加载时不实例化

    public static SpendPanel getInstance() {
        return instance;
    }

    public static SpendPanel InitializeSpendPanel() {
//        if (instance == null) {         //使用时创建实例
//            instance = new SpendPanel();
//        }
        return instance;
    }

    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(center_west(), BorderLayout.WEST);
        p.add(center_east(), BorderLayout.CENTER);
        return p;
    }

    private Component center_east() {

        circleBar.setBackgroundColor(ColorUtil.blueColor);
        return circleBar;
    }

    private Component center_west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }

    private JPanel south() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));
        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);
        return p;
    }

    public static void main(String[] args) {
        GuiUtil.showPanel(SpendPanel.instance);
    }

    public void updateData() {
        SpendPage spend = new SpendService().getSpendPage();
        vMonthSpend.setText(spend.monthSpend);
        vTodaySpend.setText(spend.todaySpend);
        vAvgSpendPerDay.setText(spend.avgSpendPerDay);
        vMonthAvailable.setText(spend.monthAvailable);
        vDayAvgAvailable.setText(spend.dayAvgAvailable);
        vMonthLeftDay.setText(spend.monthLeftDay);

        circleBar.setPercentage(spend.usagePercentage);
        if (spend.isOverSpend) {
            vMonthAvailable.setForeground(ColorUtil.warningColor);
            vMonthSpend.setForeground(ColorUtil.warningColor);
            vTodaySpend.setForeground(ColorUtil.warningColor);

        } else {
            vMonthAvailable.setForeground(ColorUtil.grayColor);
            vMonthSpend.setForeground(ColorUtil.blueColor);
            vTodaySpend.setForeground(ColorUtil.blueColor);
        }
        circleBar.setFrontColor(ColorUtil.getByPercentage(spend.usagePercentage));
        addListener();

    }

    public void addListener() {
        // Do nothing

    }


}
