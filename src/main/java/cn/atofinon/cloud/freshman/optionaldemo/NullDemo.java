package cn.atofinon.cloud.freshman.optionaldemo;

import cn.atofinon.cloud.freshman.lambdademo.data.Car;
import cn.atofinon.cloud.freshman.lambdademo.data.Insurance;
import cn.atofinon.cloud.freshman.lambdademo.data.UserDO;

import java.util.Optional;

/**
 * @Author 南北[yangjw@tuya.com]
 * @Date 2019/11/22 5:48 PM
 * @Descrition
 */


public class NullDemo {


    public static void main(String[] args) {
        UserDO userDO = new UserDO();
        String name = Optional.ofNullable(userDO).map(UserDO::getCar).map(Car::getInsurance).map(Insurance::getName).orElse(null);
        if (Optional.ofNullable(userDO).isPresent()) {

        }

    }

}
