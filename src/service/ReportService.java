package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

public class ReportService {

    /**
     * 获取某一天的消费金额
     * @param d
     * @param monthRawData
     * @return
     */

    public int getDaySpend(Date d, List<Record> monthRawData) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = simpleDateFormat.format(d);
        int daySpend = 0;
        for (Record record : monthRawData) {
            String DateFromRecord = simpleDateFormat.format(record.getDate());
            if(nowDate.equals(DateFromRecord)){
                daySpend+=record.getSpend();
            }
        }
        return daySpend;
    }

    /**
     * 获取一个月的消费记录集合
     * @return
     */
    public List<Record> listThisMonthRecords() {
        RecordDAO dao= new RecordDAO();
        List<Record> monthRawData= dao.listThisMonth();
        List<Record> result= new ArrayList<>();
        Date monthBegin = DateUtil.monthBegin();
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            Record r = new Record();
            c.setTime(monthBegin);
            c.add(Calendar.DATE, i);
            Date eachDayOfThisMonth=c.getTime() ;
            int daySpend = getDaySpend(eachDayOfThisMonth,monthRawData);
            r.spend=daySpend;
            result.add(r);
        }
        return result;

    }

}