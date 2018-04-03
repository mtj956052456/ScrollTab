package com.mtj.mytestlist.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lenovo on 2017/12/27.
 */

public class DateUtil {


    /**
     * 返回前七天的数据
     * @return
     */
    public static String getFront7Date() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -7);    //得到前一天
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(date));
        return df.format(date);
    }
    /**
     * 返回当前年月日
     */
    public static String getNowDate() {
        Date date = new Date();
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return nowDate;
    }

    /**
     * 返回当前年月日 时分秒 时间
     */
    public static String getNowDateTime() {
        Date date = new Date();
        String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return nowDate;
    }

    /**
     * 获取当天周几
     *
     * @param dt
     * @return
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 获取小时和分钟
     *
     * @return
     */
    public static String getHHmmTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(date);
    }
    public static String gethhmmTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        return sdf.format(date);
    }

    /**
     * 获取上午下午
     *
     * @return
     */
    public static String getAMPM() {
        Calendar cal = Calendar.getInstance();
        int bool = cal.get(Calendar.AM_PM);
        if (bool == 0) {
            return "上午";
        }
        return "下午";
    }

    /**
     * 返回当月天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getDays(int year, int month) {
        int days;
        int FebDay = 28;
        if (isLeap(year))
            FebDay = 29;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = FebDay;
                break;
            default:
                days = 0;
                break;
        }
        return days;
    }

    /**
     * 判断闰年
     */
    public static boolean isLeap(int year) {
        if (((year % 100 == 0) && year % 400 == 0) || ((year % 100 != 0) && year % 4 == 0))
            return true;
        else
            return false;
    }

}
