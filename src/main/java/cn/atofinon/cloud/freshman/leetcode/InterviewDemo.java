package cn.atofinon.cloud.freshman.leetcode;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/6/22 00:35
 * @Descrition
 */


public class InterviewDemo {


    public static void main(String[] args) {
        String word = "word";

        int l = 2;
        if (word.length() <= l) {
            System.out.println(0);
        }

        char[] chars = word.toCharArray();
        int length = chars.length;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {

            int end = i + l ;
            if (end <= length) {
                String s = word.substring(i, end);
                result.add(s);
            }
        }
        System.out.println(result);
    }
}
