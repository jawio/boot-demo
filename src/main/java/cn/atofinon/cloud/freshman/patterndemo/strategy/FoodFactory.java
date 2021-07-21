package cn.atofinon.cloud.freshman.patterndemo.strategy;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/21 17:39
 * @Descrition
 */


public interface FoodFactory {

    void makeFood();

    default void drink(){
        System.out.println("FoodFactory drink.");
    }
}
