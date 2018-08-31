package com.voally.vertical.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GlobalFunc {
	private static String configfile = "Config";
	private static String endline = "------分隔符------";

	public static String formateDate(String date) {
		if (date == null || date.equals("")) {
			return "";
		}
		return date.substring(0, 10);
	}

	/**
	 * Object 转 Long
	 * */
	public static Long parseLong(Object o) {
		try {
			return Long.valueOf(String.valueOf(o));
		}catch (Exception e){

		}
		return new Date().getTime();
	}

	public static int parseInt(String s) {
		try {
			if (s == null || s.equals(""))
				return 0;

			return Integer.parseInt(s.trim());
		} catch (Exception e) {
		}
		return 0;
	}

	public static double parseDouble(Object s) {
		try {
			if (s == null)
				return 0.0D;

			return Double.parseDouble(((String) s).trim());
		} catch (Exception e) {
		}
		return 0.0D;
	}

	public static double parseDouble(int i) {
		return parseDouble(String.valueOf(i));
	}

	public static double parseDouble(long i) {
		return parseDouble(String.valueOf(i));
	}

	public static String doubleToStr(double f) {
		return String.valueOf(parseDouble(Math.round(f * 100.0D)) / 100.0D);
	}

	public static int parseInt(Object s) {
		return parseInt(s, 0);
	}

	public static int parseInt(Object s, int def) {
		try {
			if (s == null)
				return def;

			return Integer.parseInt((s.toString()).trim());
		} catch (Exception e) {

		}
		return def;
	}

	public static float parseFloat(Object s) {
		try {
			if ((s == null) || (s.equals("")))
				return Float.parseFloat("0");

			return Float.parseFloat(s.toString().trim());
		} catch (Exception e) {
		}
		return Float.parseFloat("0");
	}

	public static String toString(Object s) {
		try {
			if (s == null)
				return "";

			// return String.valueOf(s).replace("null", "");' //若使用该方法.则表单中的就有错误
			return String.valueOf(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static Calendar getCal(String s) {
		Calendar cal = Calendar.getInstance();
		cal.set(getYear(s), getMonth(s) - 1, getDay(s), getHour(s),
				getMinute(s), getSecond(s));
		return cal;
	}

	public static int getHour(String s) {
		try {
			return Integer.parseInt(s.substring(11, 13));
		} catch (Exception e) {
		}
		return 0;
	}

	public static int getMinute(String s) {
		try {
			return Integer.parseInt(s.substring(14, 16));
		} catch (Exception e) {
		}
		return 0;
	}

	public static int getSecond(String s) {
		try {
			return Integer.parseInt(s.substring(17, 19));
		} catch (Exception e) {
		}
		return 0;
	}

	public static long getTime(Object time) {
		return getCal(toString(time)).getTime().getTime();
	}

	public static String getYear(Calendar cal) {
		return String.valueOf(cal.get(1));
	}

	public static boolean isNullStr(String s) {
		return ((s == null) || (s.trim().length() <= 0));
	}

	public static String strLen(String s, int len) {
		if (isNullStr(s))
			s = "";
		for (int i = 0; i < len - s.length(); ++i) {
			s = "0" + s;
		}
		return s;
	}

	public static String getMonth(Calendar cal) {
		return strLen(String.valueOf(cal.get(2) + 1), 2);
	}

	public static String getDay(Calendar cal) {
		return strLen(String.valueOf(cal.get(5)), 2);
	}

	public static String getHour(Calendar cal) {
		return strLen(String.valueOf(cal.get(11)), 2);
	}

	public static String getMinute(Calendar cal) {
		return strLen(String.valueOf(cal.get(12)), 2);
	}

	public static String getSecond(Calendar cal) {
		return strLen(String.valueOf(cal.get(13)), 2);
	}

	public static String getDateStr(Calendar cal) {
		return getYear(cal) + "/" + getMonth(cal) + "/" + getDay(cal);
	}

	public static String getDateStr(String date) {
		if (getDateStr(getCal(date)).equals("1970/01/01"))
			return "";
		if (getDateStr(getCal(date)).equals("1900/01/01"))
			return "";
		return getDateStr(getCal(date));
	}

	public static String getTimeStr(Calendar cal) {
		return getHour(cal) + ":" + getMinute(cal) + ":" + getSecond(cal);
	}

	public static String getTimeStr(String date) {
		return getTimeStr(getCal(date));
	}

	public static String getDate(Calendar cal) {
		return getDateStr(cal) + " " + getTimeStr(cal);
	}

	public static String getDate(Date dat) {
		if (dat == null)
			return "";
		Calendar cal = Calendar.getInstance();
		cal.setTime(dat);
		return getDateStr(cal) + " " + getTimeStr(cal);
	}

	/**
	 * @since 获取年份 params string, 返回int类型
	 */
	public static int getYear(String s) {
		try {
			return Integer.parseInt(s.substring(0, 4));
		} catch (Exception e) {
		}
		return 1970;
	}

	/**
	 * @since  获取月份 params string, 返回int类型
	 */
	public static int getMonth(String s) {
		try {
			return Integer.parseInt(s.substring(5, 7));
		} catch (Exception e) {
		}
		return 1;
	}

	/**
	 * @since 获取天数 params string 返回int类型
	 */
	public static int getDay(String s) {
		try {
			return Integer.parseInt(s.substring(8, 10));
		} catch (Exception e) {
		}
		return 1;
	}

	public static String getYearMonth(String s) {
		try {
			return s.substring(0, 7);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * @since 显示的格式如 1900/01/01 00:00:00
	 */
	public static String getNow() {
		Calendar now = Calendar.getInstance();
		return getDateStr(now) + " " + getTimeStr(now);
	}

	/**
	 * @since 显示的格式如 1900/01/01
	 */
	public static String getNowDate() {
		Calendar now = Calendar.getInstance();
		return getDateStr(now);
	}

	public static String getNowTime() {
		Calendar now = Calendar.getInstance();
		return getTimeStr(now);
	}

	public static String getThisWeek() {
		Calendar now = Calendar.getInstance();
		now.set(5, now.get(5) - now.get(7) + 1);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getThisWeekend() {
		Calendar now = Calendar.getInstance();
		now.set(5, now.get(5) - now.get(7) + 8);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	static String getThisWeek(String date) {
		Calendar now = getCal(date);
		now.set(5, now.get(5) - now.get(7) + 1);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getNextWeek() {
		Calendar now = Calendar.getInstance();
		now.set(5, now.get(5) - now.get(7) + 1 + 7);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getNextWeek(String date) {
		Calendar now = getCal(date);
		now.set(5, now.get(5) - now.get(7) + 1 + 7);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getNextMonth() {
		Calendar now = Calendar.getInstance();
		now.set(2, now.get(2) + 1);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getNextMonth(String date) {
		Calendar now = getCal(date);
		now.set(2, now.get(2) + 1);
		return getDateStr(now) + " " + getTimeStr(now);
	}

	public static String getChnDate(String computerDate) {
		String out = String.valueOf(getYear(computerDate)) + "年"
				+ String.valueOf(getMonth(computerDate)) + "月"
				+ String.valueOf(getDay(computerDate)) + "日";
		return out;
	}

	public static String getMonthLastDay(Calendar cal) {
		cal.add(cal.MONTH, 1);
		cal.set(cal.DATE, 1);
		cal.add(cal.DATE, -1);
		return getDateStr(cal);
	}

	public static String getMonthFristDay(Calendar cal) {
		cal.set(cal.DATE, 1);
		return getDateStr(cal);
	}

	public static String getYearAndMonth(String dateStr) {
		if (dateStr == null)
			return "";
		return dateStr.replace("年", "/").replace("月", "");
	}

	/** 获取上一个月 */
	public static String getLastMonth(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(dateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 取得上一个月时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		String lastMonth = sdf.format(calendar.getTime());
		return lastMonth;
	}

	/** 获取下一个月 */
	public static String getNextMonthFormat(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(dateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 取得下一个月时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		String lastMonth = sdf.format(calendar.getTime());
		return lastMonth;
	}

	// 获取上传文件的名字
	public static String getFileName(String filePathName) {
		int pos = 0;
		pos = filePathName.lastIndexOf(47);
		if (pos != -1)
			return filePathName.substring(pos + 1, filePathName.length());
		pos = filePathName.lastIndexOf(92);
		if (pos != -1)
			return filePathName.substring(pos + 1, filePathName.length());

		return filePathName;
	}

	public static String getChinaDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = simpleDateFormat.format(new Date());

		return date;
	}

	// 当前日期加几天后的日期
	public static String getAfterDate(Integer days) {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days);
		Date d = c.getTime();
		String afterDates = new SimpleDateFormat("yyyy-MM-dd").format(d);

		return afterDates;
	}

	/**
	 * 显示上个月日期
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String getLastDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(dateStr.substring(0, 8)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 取得上一个月时间
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		String lastMonth = sdf.format(calendar.getTime());
		return lastMonth + "-" + dateStr.substring(8, 10);
	}

	/**
	 * 根据输入的出生日期计算年龄
	 * 
	 * @param strDate
	 * @return
	 * @throws ParseException
	 */
	public static String getAgeByBirthDay(String strDate) throws ParseException {
		String age = "0";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		date = sdf.parse(strDate);
		// 使用calendar进行计算
		Calendar calendar = Calendar.getInstance();
		// 获取当前时间毫秒值
		long now = (new Date()).getTime();
		long Birthdate = date.getTime();
		long time = now - Birthdate;
		int count = 0;
		// 时间换算
		long days = time / 1000 / 60 / 60 / 24;
		// 判断闰年
		int birthYear = Integer.parseInt((strDate.substring(0, 4)));
		for (int i = calendar.get(Calendar.YEAR); i >= birthYear; i--) {
			if ((i % 4 == 0 && !(i % 100 == 0)) || (i % 400 == 0)) {
				count++;
			}
			// 加入闰年因素进行整理换算
			age = (((int) days - count) / 365) + "";
		}
		return age;
	}

	/**
	 * 得到几天后的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static String getDateAfter(Date d, int day) {

		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		Date after = now.getTime();
		String afterDates = new SimpleDateFormat("yyyy-MM-dd").format(after);

		return afterDates;
	}
	
	/**
	 * 根据生日获取年龄
	 * @param birthDate
	 */
	public static String getAge(Date birthDate) {

		if (birthDate == null)
			throw new RuntimeException("出生日期不能为null");

		int age = 0;

		Date now = new Date();
		
		SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
		SimpleDateFormat format_M = new SimpleDateFormat("MM");
		
		Long birthTime = birthDate.getTime();
		Long nowTime = now.getTime();
		
		if(birthTime<=nowTime){
			Long difference = (nowTime-birthTime)/(1000*60*60);//小时差
			//小于2天的  计算小时
			if(difference<48){
				return GlobalFunc.parseInt(difference)+" 小时";
			//小于61天的  计算天	
			}else if((difference/24)<61){
				return GlobalFunc.parseInt(difference/24)+" 天";
			//2年以下的 计算月份	
			}else if((difference/24)<730){
				
				String birth_year = format_y.format(birthDate);
				String this_year = format_y.format(now);
		
				String birth_month = format_M.format(birthDate);
				String this_month = format_M.format(now);
				
				int yearDiff = Integer.parseInt(this_year) - Integer.parseInt(birth_year);
				int monthDiff = Integer.parseInt(this_month) - Integer.parseInt(birth_month);
				
				return GlobalFunc.parseInt(monthDiff+(yearDiff*12))+" 月";
			}else if((difference/24)>=730){
		
				String birth_year = format_y.format(birthDate);
				String this_year = format_y.format(now);
		
				String birth_month = format_M.format(birthDate);
				String this_month = format_M.format(now);
		
				// 初步，估算
				age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);
		
				// 如果未到出生月份，则age - 1
				if (this_month.compareTo(birth_month) < 0)
					age -= 1;
				if (age < 0)
					age = 0;
				return age+" 岁";
			}
		}
		return "";
	}

	public static Long getSecondsNextEarlyMonrning(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR,1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.MILLISECOND,0);
		Long timeout = (calendar.getTimeInMillis()-System.currentTimeMillis())/100;
		return timeout;
	}

}