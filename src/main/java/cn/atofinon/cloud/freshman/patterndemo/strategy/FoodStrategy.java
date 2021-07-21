package cn.atofinon.cloud.freshman.patterndemo.strategy;

import lombok.Data;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/21 17:37
 * @Descrition
 */


@Data
public class FoodStrategy {
    private FoodFactory foodFactory;

    public FoodStrategy(FoodFactory foodFactory) {
        this.foodFactory = foodFactory;
    }

    public void execute() {
        foodFactory.makeFood();
    }

    public static void main(String[] args) {
        FoodFactory cff = new ChineseFoodFactory();
        FoodStrategy foodStrategy = new FoodStrategy(cff);
        foodStrategy.execute();
        cff.drink();

        FoodFactory aff = new AmericaFoodFactory();
        FoodStrategy afood = new FoodStrategy(aff);
        afood.execute();


    }
}
