package cn.atofinon.cloud.freshman.classdemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @Author atofinon
 * @Email yangjw@tuya.com
 * @Date 2019/9/13 5:31 PM
 * @Descrition
 */


@Slf4j
public class HelloWorld {


    private String name;

    private static String country = "China";

    public void getName(String name) {
        System.out.println("name:" + name);
    }

    @Deprecated
    public void getName(String name, String country) {
        System.out.println("name:" + name + " and  country:" + country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
