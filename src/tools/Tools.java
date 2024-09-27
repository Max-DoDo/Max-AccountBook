package tools;

import java.awt.*;
import java.util.Arrays;
import java.util.Calendar;

/**
 * <p><b>
 * 这个类是一个静态的工具类, 用于在构造项目中的某些算法的实现
 * </b></p>
 * 其所包含的所有方法都应当是静态的
 * 因此这个类不能被实例化为对象, 也不能被继承
 *
 * @author Maxwell
 * @version 1.1
 */
public final class Tools {

    /**
     * 判断字符串是否由纯整数组成
     *
     * @param str 判断字符串
     * @return 布尔值. 若为整数返回True. 反之False
     */
    public static boolean canParseInt(String str) {

        if (str == null) { //验证是否为空
            return false;
        }
        return str.matches("\\d+");
    }

    /**
     * 获得当前屏幕的宽度和高度
     *
     * @return int类型数组, 长度为2. 其中index0为屏幕宽度, index1为屏幕高度
     */
    public static int[] getScreenSize() {
        //获得当前屏幕的宽度和高度
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int[] value = new int[2];
        value[0] = (int) screenSize.getWidth();
        value[1] = (int) screenSize.getHeight();

        return value;
    }

    /**
     * 查找数组中是否包含某元素
     *
     * @param array 数组
     * @param obj   需要查找的元素
     * @return 如果包含该元素返回true, 否则返回false
     */
    public static boolean in(Object[] array, Object obj) {
        return Arrays.asList(array).contains(obj);
    }

    public static String getCurrentFormatTime(){
        //获得当前时间
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
//        int milSec = calendar.get(Calendar.MILLISECOND);
        return hour + ":" + min + ":" + sec/* + "-" + milSec*/;
    }

    public static String getCurrentFormatDate(){
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        return year + "-" + month + "-" + date;
    }


    /**
     * 私有化的构造方法. 禁止实例化本类对象
     */
    private Tools() {
    }

}
