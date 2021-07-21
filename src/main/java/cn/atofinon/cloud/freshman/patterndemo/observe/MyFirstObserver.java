package cn.atofinon.cloud.freshman.patterndemo.observe;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/21 19:58
 * @Descrition
 */


public class MyFirstObserver extends MyObserver {


    public MyFirstObserver(MySubject mySubject) {
        this.mySubject = mySubject;
        mySubject.attach(this);
    }

    @Override
    public void update(int state) {
        System.out.println("MyFirstObserver update state = " + state);
    }
}
