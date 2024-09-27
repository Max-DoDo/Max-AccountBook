package tools;

import java.util.Calendar;

import static tools.Tools.getCurrentFormatTime;

public final class Out {

    private Out(){}

    /**
     * <p>
     * 输出带时间戳的内容到控制台.且在结尾换行
     * </p><p>
     * 用于替换<code>System.out.println()</code>方法
     * </p><p>
     * 这个方法的时间戳的实现本质上是创建和调用了<code>MCalendar</code>类的对象
     * 有很多优化空间, 例如使用<code>format()</code>方法来获得该类对象的事件内容
     * </p>
     * @see java.util.Calendar
     * @see java.lang.System
     * @param obj 输出的内容
     */
    public static void println(Object obj){
        String data = format(obj);
        Log.addLog(data);
        System.out.println(data);
    }



    private static String format(Object obj){

        return "LOG " + getCurrentFormatTime() +"\t"+ obj;
    }

    private static String formatErr(Object obj){
        return "ERROR " + getCurrentFormatTime() +"\t"+ obj;
    }
}
