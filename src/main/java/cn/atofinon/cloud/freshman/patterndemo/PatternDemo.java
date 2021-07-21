package cn.atofinon.cloud.freshman.patterndemo;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/20 22:47
 * @Descrition
 */


public class PatternDemo {


    public static void main(String[] args) {
        Cock cock=new WildCock();
        Duck wildDuck=new CockAdapter(cock);
        wildDuck.quarck();
    }
}
