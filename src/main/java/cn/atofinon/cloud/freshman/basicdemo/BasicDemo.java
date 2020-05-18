package cn.atofinon.cloud.freshman.basicdemo;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @Author yangjw@tuya.com
 * @Date 2020/5/10 1:38 pm
 * @Descrition
 */


public class BasicDemo {

    public static void main(String[] args) {
        List<String> strList = Lists.newArrayList("A","B","C","D");

        System.out.println(strList.get(-1));
    }

}
