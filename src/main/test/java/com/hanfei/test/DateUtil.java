package com.hanfei.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Hanfei
 * @Date: 2017/9/9
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:DateUtil
 */
public class DateUtil {

    private DateUtil() {

    }

    /*
        日期格式
     */
    public static final String TIME_PATTERN = "HH:mm:ss";

    public static final String DATE_PATTERN = "YYYY-MM-dd";

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_PATTERN_ZH = "HH时mm分ss秒";

    public static final String DATE_PATTERN_ZH = "yyyy年MM月dd日";

    public static final String DATETIME_PATTERN_ZH = "yyyy年MM月dd日 HH时mm分ss秒";


    /**
     * 日期->日期字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 日期字符串->日期
     *
     * @param dateString
     * @param pattern
     * @return
     */
    public static Date stringToDate(String dateString, String pattern) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateString);
    }

    /**
     * 当前时间格式化
     *
     * @param pattern
     * @return
     */
    public static String getDate(String pattern) {
        return dateToString(new Date(), pattern);
    }


    /**
     * 日期计算
     *
     * @param date
     * @param field
     * @param amount
     * @return
     */
    public static final Date addDate(Date date, int field, int amount) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }


    /**
     * 间隔天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static final int dayBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.set(Calendar.HOUR_OF_DAY, 0);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND, 0);
        end.set(Calendar.MILLISECOND, 0);

        long n = end.getTimeInMillis() - start.getTimeInMillis();
        return (int) (n / (60 * 60 * 24 * 1000l));
    }





    public static void main(String[] args) {
        System.out.println(dayBetween(addDate(new Date(), Calendar.YEAR, 1), new Date()));
    }

}
