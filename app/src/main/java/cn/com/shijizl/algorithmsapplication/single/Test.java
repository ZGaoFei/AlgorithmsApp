package cn.com.shijizl.algorithmsapplication.single;


/**
 * Created by zgfei on 2017/8/7.
 */

public class Test {

    /**
     * 会先创建一个静态的全局的对象
     * 然后构造函数私有化
     * 对外暴露一个方法，返回对象
     * 懒汉式天生就是线程安全的
     * 但是无论是否用到都会创建一个对象
     * 资源问题
     */
    /*private static final Test test = new Test();
    private Test() {}
    public static Test instance() {
        return test;
    }*/

    /**
     * 恶汉式
     * 双重判断，一个用于避免每次都进行锁操作
     * 另一个用于避免重复初始化
     */
    /*private static Test test;
    private Test() {};
    public static Test instance() {
        if (test == null) {
            synchronized (Test.class) {
                if (test == null) {
                    test = new Test();
                }
            }
        }
        return test;
    }*/

    /**
     * 利用静态内部类只会被执行一次的原理
     */
    private Test() {}
    static class InnerClass {
        public static Test test = new Test();
    }
    public static Test instance() {
        return InnerClass.test;
    }
}
