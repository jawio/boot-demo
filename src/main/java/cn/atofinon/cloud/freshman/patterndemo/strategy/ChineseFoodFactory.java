package cn.atofinon.cloud.freshman.patterndemo.strategy;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/21 17:40
 * @Descrition
 */


public class ChineseFoodFactory implements FoodFactory {

    @Override
    public void makeFood() {
        System.out.println("make chinese food.");
    }


}
