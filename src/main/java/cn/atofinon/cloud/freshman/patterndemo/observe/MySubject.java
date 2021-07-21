package cn.atofinon.cloud.freshman.patterndemo.observe;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @Author yangjw@tuya.com
 * @Date 2021/7/21 19:50
 * @Descrition
 */


public class MySubject {

    List<MyObserver> observables=new ArrayList<>();
    private Integer  state;

    public void setState(Integer state) {
        this.state = state;
        notifyAllObservers();
    }

    public Integer getState() {
        return state;
    }

    public void attach(MyObserver obs){
        this.observables.add(obs);
    }


    public void notifyAllObservers(){
        for (MyObserver observable : observables) {
            observable.update(state);
        }
    }

    public static void main(String[] args) {
        MySubject mySubject=new MySubject();
        MyFirstObserver myFirstObserver= new MyFirstObserver(mySubject);
        mySubject.setState(2);
    }
}
