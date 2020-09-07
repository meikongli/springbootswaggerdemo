package com.example.demo.Coll;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateUtil {

    /** 得到系统当前日期及时间 格式为 yyyy-MM-dd HH:mm:ss * */
    public static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }



    /** 得到long型的日期值 * */
    public static Time getSqlTime() {
        return new Time(getTime());
    }

    /** 获取系统当前时间 * */
    public static long getTime() {
        java.util.Date dt = new java.util.Date();
        return dt.getTime();
    }

    /** 获取系统当前时间 * */
    public static Date getJavaDate() {
        return new java.util.Date();
    }

    /** 获取系统当前日期 得到的日期格式如：2004-10-09 * */
    public static java.sql.Date getSqlDate() {
        return new java.sql.Date(getTime());
    }

    /** 取得Timestamp类型时间 * */
    public static Timestamp getTimestamp() {
        return new Timestamp(getTime());
    }

    /** 得到Calendar对象 * */
    public static Calendar getCD() {
        Calendar mycd = Calendar.getInstance();
        return mycd;
    }

    /** 得到sStr格式日期 * */
    public static String getAll(String sStr) {
        Calendar mycd = Calendar.getInstance();
        return mycd.get(Calendar.YEAR) + sStr + (mycd.get(Calendar.MONTH) + 1)
                + sStr + mycd.get(Calendar.DATE);
    }

    /** 得到日期,以-为分割符 * */
    public static String getAll() {
        return getAll("-");
    }

    /** 得到系统当前年 * */
    public static int getYear() {
        Calendar mycd = Calendar.getInstance();
        return mycd.get(Calendar.YEAR);
    }

    /** 得到系统当前月 * */
    public static int getMonth() {
        Calendar mycd = Calendar.getInstance();
        return mycd.get(Calendar.MONTH) + 1;
    }

    /** 得到系统当前日 * */
    public static int getDate() {
        Calendar mycd = Calendar.getInstance();
        return mycd.get(Calendar.DATE);
    }

    /** 得到系统年 * */
    public static int getAddYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /** 得到系统月 * */
    public static int getAddMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /** 得到系统日 * */
    public static int getAddDate() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    /** 得到日期格式为yyyy-mm-dd * */
    public static String getMiddle() {
        return getMiddle("-");
    }

    /** 得到日期格式为YYYY $sStr MM 其中sStr为分割字符 * */
    public static String getMiddleYM(String sStr) {
        Calendar mycd = Calendar.getInstance();
        int year = mycd.get(Calendar.YEAR);
        int month = mycd.get(Calendar.MONTH) + 1;
        String re = "" + String.valueOf(year);
        if (month < 10)
            re += sStr + "0" + String.valueOf(month);
        else
            re += sStr + String.valueOf(month);
        return re;
    }

    /** 得到日期格式为YYYY $sStr MM $sStr DD其中sStr为分割字符 * */
    public static String getMiddle(String sStr) {
        Calendar mycd = Calendar.getInstance();
        int year = mycd.get(Calendar.YEAR);
        int month = mycd.get(Calendar.MONTH) + 1;
        int date = mycd.get(Calendar.DATE);
        String re = "" + String.valueOf(year);
        if (month < 10)
            re += sStr + "0" + String.valueOf(month);
        else
            re += sStr + String.valueOf(month);
        if (date < 10)
            re += sStr + "0" + String.valueOf(date);
        else
            re += sStr + String.valueOf(date);
        return re;
    }

    /** 得到日期格式为 YYYY $sStr MM $sStr DD $sStr hh:mm:ss其中sStr为分割字符 * */
    public static String getTimeStr(String sStr) {

        Calendar mycd = Calendar.getInstance();
        String re = "" + mycd.get(Calendar.YEAR);
        if (mycd.get(Calendar.MONTH) + 1 < 10)
            re += sStr + "0" + String.valueOf(mycd.get(Calendar.MONTH) + 1);
        else
            re += sStr + String.valueOf(mycd.get(Calendar.MONTH) + 1);
        if (mycd.get(Calendar.DATE) < 10)
            re += sStr + "0" + String.valueOf(mycd.get(Calendar.DATE));
        else
            re += sStr + String.valueOf(mycd.get(Calendar.DATE));

        if (mycd.get(Calendar.HOUR) < 10)
            re += " " + "0" + String.valueOf(mycd.get(Calendar.HOUR));
        else
            re += " " + String.valueOf(mycd.get(Calendar.HOUR));
        if (mycd.get(Calendar.MINUTE) < 10)
            re += ":0" + String.valueOf(mycd.get(Calendar.MINUTE));
        else
            re += ":" + String.valueOf(mycd.get(Calendar.MINUTE));
        if (mycd.get(Calendar.SECOND) < 10)
            re += ":0" + String.valueOf(mycd.get(Calendar.SECOND));
        else
            re += ":" + String.valueOf(mycd.get(Calendar.SECOND));
        return re;
    }


    /** 取得两个日期的相隔天数 * */
    public static int getDays(Date sd, Date ed) {
        return (int)((ed.getTime() - sd.getTime()) / (3600 * 24 * 1000));
    }

    /***************************************************************************
     * 取得yyyymm,参数一：yyyymm,参数二：number 得到减去月份的日期
     **************************************************************************/

    public static String getTime(String s) {
        if (s == null || s.equals(""))
            return "";
        String s1 = "";
        try {
            SimpleDateFormat simpledateformat = new SimpleDateFormat(s);
            s1 = simpledateformat.format(Calendar.getInstance().getTime());
        } catch (Exception exception) {
            System.out.println(Calendar.getInstance().toString()
                    + "cannot format time [function:getTime(String)]");
            exception.printStackTrace();
        }
        return s1;
    }

    /** 将String 转换操作，将sDt替换为Timestamp型的日期型 **/
    public static java.sql.Timestamp getDateTime ( String sDt )
    {
        try
        {
            return java.sql.Timestamp.valueOf (sDt) ; //sDt
            // format:yyyy-mm-dd
            // hh:mm:ss.fffffffff
        } catch (IllegalArgumentException iae)
        {
            sDt = sDt + " 00:00:00" ;
            try
            {
                return java.sql.Timestamp.valueOf ( sDt ) ;
            } catch (Exception e)
            {
                return null ;
            }
        }
    }

}
