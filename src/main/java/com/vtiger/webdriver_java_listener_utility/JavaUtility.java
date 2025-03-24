package com.vtiger.webdriver_java_listener_utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
    public int getRandomNum(int num) {
        Random random = new Random();
        int randomnum =random.nextInt(num);
        return randomnum;
    }
    public  String getStartDate () {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startdate = sdf.format(date);
        return startdate;
    }
    public  String getEndDate (int days) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.format(date);
        Calendar cal = sdf.getCalendar();
        cal.add(Calendar.DAY_OF_MONTH,days);
        String enddate = sdf.format(cal.getTime());
        return enddate;
    }
    public String currentDateTime() {
        String time =new Date().toString().replace(" ","_").replace(":","_");
        return time;
    }
}
