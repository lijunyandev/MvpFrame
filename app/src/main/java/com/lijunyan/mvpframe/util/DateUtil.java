package com.lijunyan.mvpframe.util;

import android.annotation.SuppressLint;
import android.text.format.Time;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@SuppressLint("SimpleDateFormat")
/**
 * 日期工具类
 */
public class DateUtil {

    /**
     * 时间格式 MM是月，mm是分，HH是24小时制，hh是12小时制
     */
    public static final String DATE_FORMAT_HH_MI_SS = "HH:mm:ss";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_MMDDHHMMSS = "MM.dd HH:mm:ss";
    public static final String DATE_FORMAT_MMDDHHMMSS_WITH_YUERI = "MM月dd日 HH:mm:ss";
    public static final String DATE_FORMAT_OYYYY_MM_DD_HH24_MI = "yyyy.MM.dd HH:mm:ss"; // 24小时制
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_MM_DD = "MM/dd";
    public static final String DATE_FORMAT_MMDD = "MM.dd";
    public static final String DATE_FORMAT_YYMMDD = "YY.MM.dd";
    public static final String DATE_FORMAT_YYYY = "yyyy";
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    public static final String DATE_FORMAT_YYYY_MM = "yyyy/MM";
    public static final String DATE_FORMAT_YY_MM_DD = "yy/MM/dd";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy/MM/dd";
    public static final String DATE_FORMAT_OYYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_MM_DD_HH24_MI = "MM-dd HH:mm";   // 24小时制
    public static final String DATE_FORMAT_OYYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd hh:mm:ss";  // 12小时制
    public static final String DATE_FORMAT_YY_MM_DD_HH_MI = "yy/MM/dd HH:mm";
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MI = "yyyy/MM/dd HH:mm";
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_FORMAT_HH_MI = "HH:mm";
    public static final String DATE_FORMAT_MM_DD_HH_MI = "MM/dd HH:mm";
    public static final String DATE_FORMAT_YYYYMMDDHHMI = "yyyyMMddHHmm";
    public static final String DATE_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_YYYYMMDD_HHMISS = "yyyyMMdd-HHmmss";
    public static final String DATE_FORMAT_YYYY$MM$DD$ = "yyyy年MM月dd日";
    public static final String DATE_FORMAT_YYYY$MM$ = "yyyy年MM月";
    public static final String DATE_FORMAT_MM$DD$ = "MM月dd日";
    public static final String DATE_FORMAT_MM_DD_HH_MI_E = "MM/dd hh:mm E"; // eg: "3/20 12:22 星期一"

    public static final String DATE_WEEKDAY = "date_weekday";										// 星期
    public static final String DATE_MONTH = "date_month";											// 月
    public static final String DATE_DAY = "date_day";												// 日
    public static final String DATE_YEAR = "date_year";												// 年

    /**
     *  转换字符串为日期类型
     * @param dateStr
     * @return
     */
    public static Date string2Date(String dateStr) {
        return string2Date(dateStr, DATE_FORMAT);
    }

    /**
     *
     * 转换字符串为日期类型
     *
     * @param dateStr 日期字符串
     * @param dateFormat 日期字符串格式
     * @return 日期
     *
     */
    public static Date string2Date(String dateStr, String dateFormat) {
        Date result = null;
        try {
            DateFormat df = new SimpleDateFormat(dateFormat);
            result = df.parse(dateStr);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    /**
     *  转换 日期 为字符串
     * @return
     */
    public static String date2String(){
        return date2String(new Date());
    }

    /** 转换 日期 为字符串
     *
     * @param dateFormat   格式化
     * @return
     */
    public static String date2String(String dateFormat){
        return date2String(new Date(), dateFormat);
    }

    /**
     *  转换 日期 为字符串
     * @param date
     * @return
     */
    public static String date2String(Date date){
        return date2String(date, DATE_FORMAT);
    }

    public static String date2String(Date date, String dateFormat){
        String dateStr = "";
        try{
            DateFormat df = new SimpleDateFormat(dateFormat);
            dateStr = df.format(date);
        }catch (Exception e){
            dateStr = "";
        }
        return dateStr;
    }

    /**
     *  当前 日期 转换成毫秒
     * @return
     */
    public static long date2Long(){
        return new Date().getTime();
    }

    public static long date2Long(Date date){
        return date.getTime();
    }

    /**
     * 获取当前点的时间戳
     *
     * @param
     * @return
     */
    public static long getCurrentTime() {
        return Calendar.getInstance().getTimeInMillis() / 1000;
    }

    /**
     * 获取当前点的微秒时间戳
     *
     * @param
     * @return
     */
    public static long getCurrentMillisTime() {
        return Calendar.getInstance().getTimeInMillis();
    }


    /**  String 转化为时间戳
     *
     * @param date
     * @param format
     * @return
     */
    public static long getFormat(String date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.parse(date).getTime();
        } catch (ParseException e) {
        }
        return 0L;
    }

    /**
     *  将long秒 时间 转为 String时间
     * @param time
     * @param format
     * @return
     */
    public static String getTimeString(long time, String format) {
        String date = "";
        try {
            date = getDateString(new Date(time * 1000), format);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getDateString(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.CHINESE);
        return formatter.format(date);
    }

    /**
     * 格式化时间 ，秒数-->00:00:00
     *
     * @param
     * @return
     */
    public static String getStandardTime(long timestamp) {
        SimpleDateFormat sdf;
        if (timestamp < 3600) {// 一小时以内
            sdf = new SimpleDateFormat("mm:ss", Locale.getDefault());

        } else {
            sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        }
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        Date date = new Date(timestamp * 1000);
        sdf.format(date);
        return sdf.format(date);
    }


    /**
     * 判断日期是否是今天
     * 忽略时分秒
     * @return
     */
    public static boolean compareDate(Calendar c){
        if(c ==null) return false;
        Calendar today = Calendar.getInstance();
        if(c.get(Calendar.YEAR) == today.get(Calendar.YEAR)){
            if(c.get(Calendar.MONTH)== today.get(Calendar.MONTH )){
                if(c.get(Calendar.DATE)== today.get(Calendar.DATE)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断两个日期是不是同一天
     * 忽略时分秒
     * @param c1
     * @param c2
     * @return
     */
    public static boolean compareDate(Calendar c1, Calendar c2){
        if(c1 ==null || c2 == null) return false;
        if(c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)){
            if(c1.get(Calendar.MONTH)== c2.get(Calendar.MONTH )){
                if(c1.get(Calendar.DATE)== c2.get(Calendar.DATE)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  通过月份返回月份参数
     * @param m
     * @return
     */
    public static String getFriendlyMonth(int m){
        String ret = null;
        switch (m) {
            case 0:
                ret = "一月";
                break;
            case 1:
                ret = "二月";
                break;
            case 2:
                ret = "三月";
                break;
            case 3:
                ret = "四月";
                break;
            case 4:
                ret = "五月";
                break;
            case 5:
                ret = "六月";
                break;
            case 6:
                ret = "七月";
                break;
            case 7:
                ret = "八月";
                break;
            case 8:
                ret = "九月";
                break;
            case 9:
                ret = "十月";
                break;
            case 10:
                ret = "十一月";
                break;
            case 11:
                ret = "十二月";
                break;

            default:
                break;
        }
        return ret;
    }



    /**
     *  通过月份返回月份参数
     * @param m
     * @return
     */
    public static String getEnglishMonth(int m){
        String ret = null;
        switch (m) {
            case 1:
                ret = "Jan";
                break;
            case 2:
                ret = "Feb";
                break;
            case 3:
                ret = "Mar";
                break;
            case 4:
                ret = "Apr";
                break;
            case 5:
                ret = "May";
                break;
            case 6:
                ret = "Jun";
                break;
            case 7:
                ret = "Jul";
                break;
            case 8:
                ret = "Aug";
                break;
            case 9:
                ret = "Sep";
                break;
            case 10:
                ret = "Oct";
                break;
            case 11:
                ret = "Nov";
                break;
            case 12:
                ret = "Dec";
                break;

            default:
                ret = "";
                break;
        }
        return ret;
    }


    /**
     *  通过月份返回月份参数
     * @param m
     * @return
     */
    public static String getEnglishWeekday(int m){
        String ret = null;
        switch (m) {
            case 1:
                ret = "Mon";
                break;
            case 2:
                ret = "Tue";
                break;
            case 3:
                ret = "Wed";
                break;
            case 4:
                ret = "Thur";
                break;
            case 5:
                ret = "Fri";
                break;
            case 6:
                ret = "Sat";
                break;
            case 7:
                ret = "Sun";
                break;

            default:
                ret = "0";
                break;
        }
        return ret;
    }

    /**
     *  判断是否是今天
     * @param t
     * @return
     */
    public static boolean isToday(long t){
        Time time = new Time();
        time.set(t);

        int thenYear = time.year;
        int thenMonth = time.month;
        int thenMonthDay = time.monthDay;

        time.set(System.currentTimeMillis());
        return (thenYear == time.year)
                && (thenMonth == time.month)
                && (thenMonthDay == time.monthDay);
    }

    /**
     *  判断是否是昨天
     * @param t
     * @return
     */
    public static boolean isYesterday(long t){
        Time time = new Time();
        time.set(t);

        int thenYear = time.year;
        int thenMonth = time.month;
        int thenMonthDay = time.monthDay;

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);

        return (thenYear == cal.get(Calendar.YEAR))
                && (thenMonth == cal.get(Calendar.MONTH ))
                && (thenMonthDay == cal.get(Calendar.DATE));
    }

    /**
     *  传入生日，得到年龄
     * @param birthday
     * @return
     */
    public static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
//                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
//                    age += 1;
//                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

    /**
     *  传入生日，得到年龄
     * @param birthday
     * @return
     */
    public static int getYear(Date date) {
        int age = 0;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

    public static List<Long> getWeekDayList(String date, String formatSrt) {
        // 存放每一天时间的集合
        List<Long> weekMillisList = new ArrayList<Long>();
        Log.e("getWeekDayList", "aaa");
        long dateMill = 0;
        try {
            // 获取date的毫秒值
            dateMill = getMillis(date, formatSrt);
        } catch (ParseException e) {
            Log.e("getWeekDayList", "e"+e);
            e.printStackTrace();
        }
        // Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateMill);
        // 本周的第几天
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK);
        Log.e("--getWeekDayList", weekNumber + "");
        if (weekNumber == 1){
            weekNumber = 7;
        }else {
            weekNumber = weekNumber - 1;
        }
        Log.e("getWeekDayList", weekNumber + "");
        // 获取本周一的毫秒值
        long mondayMill = dateMill - 86400000 * (weekNumber - 1);

        for (int i = 0; i < 7; i++) {
            weekMillisList.add(mondayMill + 86400000 * i);
            Log.d("getWeekDayList",(mondayMill + 86400000 * i)+"");
        }
        return weekMillisList;
    }

    /**
     * 把格式化过的时间转换毫秒值
     *
     * @param time      时间
     * @param formatSrt 时间格式 如 yyyy-MM-dd
     * @return 当前日期的毫秒值
     */
    public static long getMillis(String time, String formatSrt) throws ParseException {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat(formatSrt);
        return format.parse(time).getTime();
    }

    /**
     * 将毫秒值格转换为时间 yyyy-MM-dd HH:mm:ss 格式
     *
     * @param date
     * @param format 你要的时间格式 yyyy-MM-dd HH:mm:ss或者yyyy-MM-dd
     * @return 返回转换后的值
     */
    public static String getWeekformatDate(Long date, String format) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }


    /**
     * 获取日期坐在月的天数
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    /**  耗时计算 分钟
     *
     * @param timeStamp
     * @return
     */
    public static int getMinuteCount(long timeStamp) {
        int hour = Integer.valueOf(getTimeString(timeStamp,"HH"));
        int minute = Integer.valueOf(getTimeString(timeStamp,"mm"));
        Log.d("FragmentSleep","hour : "+hour+" minute : "+minute);
//        int d = (int) (timeStamp / 86400);
//        int h = (int) ((timeStamp - 86400 * d) / 3600);
//        int m = (int) ((timeStamp - 86400 * d - h * 3600) / 60);
        return hour * 60 + minute;
    }

    /**
     *  个位时间前面补0
     * @param timeStamp
     * @return
     */
    public static String time2Opt(int timeStamp) {
        if (timeStamp <= 9)
            return "0" + timeStamp;
        else
            return "" + timeStamp;
    }
}
