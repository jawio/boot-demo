package cn.atofinon.cloud.freshman.guide;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/2/7 15:01
 * @Descrition
 */


public class GenericsDemo {

    public static void main(String[] args) {
        try {
            List<Integer> list = new ArrayList<>();

            list.add(12);
            //这里直接添加会报错
            Class<? extends List> clazz = list.getClass();
            Method add = clazz.getDeclaredMethod("add", Object.class);
            //但是通过反射添加，是可以的
            add.invoke(list, "kl");

            System.out.println(list);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
