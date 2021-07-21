package cn.atofinon.cloud.freshman.patterndemo;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/20 22:51
 * @Descrition
 */


public class WildCock implements Cock {

    @Override
    public void gg() {
        System.out.println("WildCock.gg()");
    }

    @Override
    public void fly() {
        System.out.println("WildCock.fly()");
    }
}
