package com.dak.amazing.tools;

import android.text.TextUtils;

public class StringUtil {
    /**
     * null string 转为 ""或者string
     * <p>
     * <pre>
     * nullStrToEmpty(null) = &quot;&quot;;
     * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
     * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
     * </pre>
     *
     * @param str
     * @return
     */
    public static String nullStrToEmpty(String str) {
        return (str == null || "null".equals(str) ? "" : str);
    }

    /**
     * 把空字符串转换成自己定义的默认值
     *
     * @param str
     * @return
     */
    public static String nullStrToValue(String str, String toVal) {
        return (str == null || "null".equals(str) || "".equals(str.trim()) ? toVal : str);
    }

    /**
     * null string 转为 0或者0
     * <p>
     * <pre>
     * nullStrToEmpty(null) = 0;
     * nullStrToEmpty(&quot;&quot;) = 0;
     * nullStrToEmpty(&quot;aa&quot;) = 0;
     * </pre>
     *
     * @param str
     * @return
     */
    public static String nullStrToNumber(String str) {
        return (str == null || "null".equals(str) || "".equals(str.trim()) ? "0" : str);
    }

    /**
     * string 转为 Double类型数据
     * <p>
     * <pre>
     * StrToDouble(null) = 0;
     * StrToDouble(&quot;&quot;) = 0;
     * StrToDouble(&quot;aa&quot;) = 0;
     * </pre>
     *
     * @param str
     * @return
     */
    public static Double StrToDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException n) {
            return Double.valueOf("0");
        }
    }

    /**
     * string 转为 Integer类型数据
     * <p>
     * <pre>
     * StrToInteger(null) = 0;
     * StrToInteger(&quot;&quot;) = 0;
     * StrToInteger(&quot;aa&quot;) = 0;
     * </pre>
     *
     * @param str
     * @return
     */
    public static Integer StrToInteger(String str, int defaultVal) {
        if (isEmpty(str))
            return defaultVal;
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException n) {
            return defaultVal;
        }
    }

    /**
     * string 转为 Long类型数据
     * <p>
     * <pre>
     * StrToLong(null) = 0;
     * StrToLong(&quot;&quot;) = 0;
     * StrToLong(&quot;aa&quot;) = 0;
     * </pre>
     *
     * @param str
     * @return
     */
    public static Long StrToLong(String str) {
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException n) {
            return Long.valueOf("0");
        }
    }

    /**
     * 为空或者长度为0
     * <p>
     * <pre>
     * isEmpty(null) = true;
     * isEmpty(&quot;&quot;) = true;
     * isEmpty(&quot;  &quot;) = false;
     * </pre>
     *
     * @param str
     * @return boolean
     * @author gdpancheng@gmail.com 2013-10-16 下午10:48:02
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.trim().length() == 0 || "null".equals(str));
    }

    /**
     * 截取str最后以lastStr之后的字符串
     *
     * @param str
     * @param lastStr
     * @return
     */
    public static String getSubLastStr(String str, String lastStr) {
        try {
            if (!"".equals(str.trim()) && str != null && !"".equals(lastStr.trim()) && lastStr != null) {
                int lastIndexOf = str.lastIndexOf(lastStr);
                int length = str.length();
                return str.substring(lastIndexOf, length);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static String transitionStr(String transitionStr) {
        StringBuffer sBuffer=new StringBuffer();
        try {
            if (!TextUtils.isEmpty(transitionStr)) {
                String newStr=transitionStr.replaceAll(" ","");
                int length = newStr.length();
                for (int i = 0; i < length; i++) {
                    if (i>0 && i % 4 == 0 ) {
                        sBuffer.append(" ");
                    }
                    if (i >= 4 && i < length - 4) {
                        sBuffer.append("*");
                    } else {
                        sBuffer.append(newStr.charAt(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sBuffer.toString();
    }
}
