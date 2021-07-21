package cn.atofinon.cloud.freshman.patterndemo.strategy;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/21 17:41
 * @Descrition
 */


public class AmericaFoodFactory implements FoodFactory {


    @Override
    public void makeFood() {
        System.out.println("make america food.");
    }

    public AmericaFoodFactory() {
    }
}
