package cn.atofinon.cloud.freshman.patterndemo.observe;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/21 19:54
 * @Descrition
 */


public abstract class MyObserver {

    protected MySubject mySubject;


    public abstract void update(int state);

}
