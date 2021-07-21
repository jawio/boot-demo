package cn.atofinon.cloud.freshman.patterndemo;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/20 22:49
 * @Descrition
 */


public class CockAdapter implements Duck {

    Cock cock;

    public CockAdapter(Cock cock) {
        this.cock = cock;
    }

    @Override
    public void quarck() {
        System.out.println("CockAdapter.quarck()");
    }

    @Override
    public void fly() {
        System.out.println("CockAdapter.fly()");
    }


}
