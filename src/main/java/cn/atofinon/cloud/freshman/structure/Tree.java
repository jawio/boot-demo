package cn.atofinon.cloud.freshman.structure;

import com.google.common.collect.Lists;
import jdk.nashorn.internal.ir.BinaryNode;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Stack;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/6/9 23:56
 * @Descrition
 */


public class Tree {


    public static void main(String[] args) {

//        List<String> expression = Lists.newArrayList("a", "b", "+", "c", "d", "e", "+", "*", "*");
//
//        String res="";
//
//        Stack stack = new Stack();
//        for (int i = 0; i < expression.size(); i++) {
//            String s = expression.get(i);
//            char c = s.charAt(0);
//            if (Character.isLowerCase(c)) {
//                stack.push(s);
//            } else {
//                String c1 = (String) stack.pop();
//                String c2 = (String) stack.pop();
//                res="("+c2 + s + c1+")";
//                stack.push(res);
//            }
//        }
//        Integer x=4;
//        System.out.println(x.compareTo(3));
//        System.out.println(res);

//        int codeSize=10;
//        for (int i = 0; i < codeSize - 1; ++i) {
//            System.out.println(i);
//        }
//
//        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 56, 7);
//        List<Integer> integers = list.subList(list.size() - 3 + 1, list.size());
//        System.out.println(integers);

        Long gmtCreate = 1623773089443L;
        LocalDateTime instant =  LocalDateTime.ofInstant(Instant.ofEpochMilli(gmtCreate), ZoneId.systemDefault());
        System.out.println(instant.getMonth().getValue());
        System.out.println(instant.getDayOfMonth());
        System.out.println(instant.getYear());

         String index = "paladin_station_alarm_info_index";
        int mon = instant.getMonth().getValue();
        int day = instant.getDayOfMonth();
        int year = instant.getYear();
        String month = mon < 10 ? "0" + mon : String.valueOf(mon);

        index = index + "-" + year + "." + month + "." + day;
        System.out.println(index);
    }


}
