package com.itheima.Day14_Junit_反射_注解.Work;


import org.junit.*;

/**
 * 1. 设置一个类Calculator，包含4个方法:加、减、乘、除，
 * 使用JUnit对4个方法进行单元测试。
 * 2. 在每个方法运行之前创建Calculator对象，在测试方法运行完毕之后将对象设置为null 。
 * Created by junc on 2018/10/28.
 */
public class Test01 {

    Calculator calculator;

    @BeforeClass
    public static void init() {

        System.out.println("加载类时，运行一次!!");
    }

    @Before
    public void myBefore() {

        if (calculator == null) {
            calculator = new Calculator();
        }

        System.out.println("运行方法前!");
    }

    @Test
    public void test() {

        int sum1 = calculator.sum(1, 2);
        System.out.println("和:" + sum1);
        Assert.assertEquals("加法有问题", 3, sum1);


    }

    @Test
    public void test1() {

        int sub = calculator.sub(5, 2);
        Assert.assertEquals("减法有问题！", 3, sub);
        System.out.println("差:" + sub);

    }

    @Test
    public void test2() {
        int cheng = calculator.cheng(2, 9);
        Assert.assertEquals("乘法有问题！", 18, cheng);
        System.out.println("积:" + cheng);

    }

    @Test
    public void Test3() {
        int chu = calculator.chu(30, 5);
        Assert.assertEquals("除法有问题!", 6, chu);
        System.out.println("商:" + chu);

    }

    @After
    public void myAfter() {

        calculator = null;

    }

    @AfterClass
    public static void destory() {
        System.out.println("结束!!");
    }

}

class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int cheng(int a, int b) {
        return a * b;
    }

    public int chu(int a, int b) {
        return a / b;
    }

}




