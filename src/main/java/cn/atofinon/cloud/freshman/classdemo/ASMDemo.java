package cn.atofinon.cloud.freshman.classdemo;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.IOException;

/**
 * @version 1.0
 * @Author atofinon
 * @Email yangjw@tuya.com
 * @Date 2019/9/13 5:29 PM
 * @Descrition
 */


public class ASMDemo {

//    public static void main(String[] args) throws IOException {

//        ClassReader classReader = new ClassReader("./HelloWorld");

//        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);

//        ClassVisitor classVisitor =

//    }

    static abstract class Human{
    }
    static class Man extends Human{
    }
    static class Woman extends Human{
    }
    public void sayHello(Human guy){
        System.out.println("hello,guy!");
    }
    public void sayHello(Man guy){
        System.out.println("hello,gentleman！");
    }
    public void sayHello(Woman guy){
        System.out.println("hello,lady！");
    }
    public static void main(String[]args) {
        Human man = new Man();
        Human woman = new Woman();
        ASMDemo sr = new ASMDemo();
        sr.sayHello(man);
        sr.sayHello(woman);
    }
}
